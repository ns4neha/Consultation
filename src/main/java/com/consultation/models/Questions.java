package com.consultation.models;

public class Questions {
    private int id;
    private String questionText;

    public Questions(int id, String questionText) {

        this.id = id;
        this.questionText = questionText;
    }

    public int getId() {
        return id;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }
}
