package com.shop.pojo;

public class ApiResponse<T> {

    private Boolean status;
    private T data;
    private String message;

    public ApiResponse() {
    }

    public ApiResponse(T data, String message) {
        this.status = true;
        this.data = data;
        this.message = message;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
