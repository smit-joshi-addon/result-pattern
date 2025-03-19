package com.smit.result.errors;

public class ValidationError  extends Error{
    
    public ValidationError(String message) {
        super(message);
    }
}