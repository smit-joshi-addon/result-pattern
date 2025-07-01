package com.smit.result;

import com.smit.result.errors.Error;

public class ResultBase {
    private boolean success;
    private Error error;

    public ResultBase(boolean success, Error error) {
        this.success = success;
        this.error = error;
    }

    public boolean isSuccess() {
        return success;
    }

    public Error getError() {
        return error;
    }
}