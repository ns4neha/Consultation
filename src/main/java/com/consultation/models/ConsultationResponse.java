package com.consultation.models;

public class ConsultationResponse {

    private boolean eligible;
    private String message;

    public  ConsultationResponse(boolean eligible, String message) {

        this.eligible = eligible;
        this.message = message;
    }

    public boolean isEligible() {
        return eligible;
    }

    public String getMessage() {
        return message;
    }

    public void setEligible(boolean eligible) {
        this.eligible = eligible;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
