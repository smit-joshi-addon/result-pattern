package com.smit.result.constants;

public class DefaultResultConstants implements ResultConstants {

    @Override
    public String getSuccessMessage() {
        return "Operation completed successfully.";
    }

    @Override
    public String getErrorMessage(String errorDetail) {
        return "An error occurred: ";
    }

}
