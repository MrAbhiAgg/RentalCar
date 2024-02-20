package com.example.rentalcar.demo.DTO;

import org.springframework.stereotype.Component;

@Component
public class Response {
    private String message;
    private boolean isSuccess;

    public Response() {
    }

    public Response(String message, boolean isSuccess) {
        this.message = message;
        this.isSuccess = isSuccess;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }
}
