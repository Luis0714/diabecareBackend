package com.example.demo.Application.Dtos;

import org.springframework.http.HttpStatus;

public class CustomResponse<T> {
    private T data;
    private int statusCode;
    private String message;


    public CustomResponse(T data, int statusCode, String message) {
        this.data = data;
        this.statusCode = statusCode;
        this.message = message;
    }

    public CustomResponse(T data, String message) {
        this.data = data;
        this.statusCode = HttpStatus.ACCEPTED.value();
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
