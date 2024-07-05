package com.consultation.models;

public class Answers {

    private int questionId;
    private String answerText;

    public Answers(int questionId, String answerText) {

        this.questionId = questionId;
        this.answerText = answerText;
    }

    public int getQuestionId() {
        return questionId;
    }

    public String getAnswerText() {
        return answerText;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public void setAnswerText(String answerText) {
        this.answerText = answerText;
    }
}
