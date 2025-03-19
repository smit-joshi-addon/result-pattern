package com.smit.result;

import com.smit.result.errors.Error;

public class ResultBase {
    private boolean success;
    private Error exception;

    public ResultBase(boolean success, Error error) {
        this.success = success;
        this.exception = error;
    }

    public boolean isSuccess() {
        return success;
    }

    public Error getException() {
        return exception;
    }
}