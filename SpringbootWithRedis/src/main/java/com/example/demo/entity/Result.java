package com.example.demo.entity;

public class Result<T> {

    boolean success;

    T data;

    public void setData(T data) {
        this.data = data;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public boolean isSuccess() {
        return success;
    }
}
