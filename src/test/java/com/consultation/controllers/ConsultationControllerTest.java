package com.consultation.controllers;

import com.consultation.models.Answers;
import com.consultation.models.Questions;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ConsultationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testGetQuestions() throws Exception {
        List<Questions> expectedQuestions = Arrays.asList(
                new Questions(1, "Do you have any allergies?"),
                new Questions(2, "Are you currently taking any medications?"),
                new Questions(3, "What is your age?")
        );

        mockMvc.perform(get("/api/consultation/questions"))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(expectedQuestions)));
    }

    @Test
    public void testSubmitAnswersEligible() throws Exception {
        List<Answers> answers = Arrays.asList(
                new Answers(1, "No"),
                new Answers(2, "No"),
                new Answers(3, "25")
        );

        mockMvc.perform(post("/api/consultation/answers")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(answers)))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"eligible\":true,\"message\":\"You are eligible for the prescription.\"}"));
    }

    @Test
    public void testSubmitAnswersNotEligible() throws Exception {
        List<Answers> answers = Arrays.asList(
                new Answers(1, "Yes"),
                new Answers(2, "No"),
                new Answers(3, "25")
        );

        mockMvc.perform(post("/api/consultation/answers")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(answers)))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"eligible\":false,\"message\":\"You are not eligible for the prescription.\"}"));
    }
}
