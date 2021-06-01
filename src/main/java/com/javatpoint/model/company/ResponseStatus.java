package com.javatpoint.model.company;

public class ResponseStatus {
    private boolean success;

    public ResponseStatus(boolean success) {
        this.success = success;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
