package com.consultation.controllers;

import com.consultation.models.Answers;
import com.consultation.models.ConsultationResponse;
import com.consultation.models.Questions;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/consultation")
public class ConsultationController {

    private static final List<Questions> questions = new ArrayList<>();
    static {
        questions.add(new Questions(1, "Do you have any allergies?"));
        questions.add(new Questions(2, "Are you currently taking any medications?"));
        questions.add(new Questions(3, "What is your age?"));
    }

    @GetMapping("/questions")
    public List<Questions> getQuestions() {
        return questions;
    }

    @PostMapping("/answers")
    public ConsultationResponse submitAnswers(@RequestBody List<Answers> answers) {
        // Simple logic to determine eligibility
        boolean eligible = answers.stream().noneMatch(answer -> answer.getAnswerText().equalsIgnoreCase("yes"));
        String message = eligible ? "You are eligible for the prescription." : "You are not eligible for the prescription.";
        return new ConsultationResponse(eligible, message);
    }
}
