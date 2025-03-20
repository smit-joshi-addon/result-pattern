package com.smit.result;

import com.smit.result.errors.EntityAlreadyExistsError;
import com.smit.result.errors.EntityNotFoundError;
import com.smit.result.errors.Error;
import com.smit.result.errors.UnauthorizedError;
import com.smit.result.errors.ValidationError;
import com.smit.result.providers.ResultConstantsProvider;

public class CustomResult<T> extends ResultBase {
    private T data;
    private String message;

    public CustomResult(T data) {
        super(true, null);
        this.data = data;
        this.message = ResultConstantsProvider.getResultConstants().getSuccessMessage();
    }

    public CustomResult(T data, String message) {
        super(true, null);
        this.data = data;
        this.message = message;
    }

    public CustomResult(boolean success) {
        super(success, null);
        this.data = null;
    }

    public CustomResult(boolean success, Error error) {
        super(success, error);
        this.message = error.getMessage();
        this.data = null;
    }

    public T getData() {
        return data;
    }

    public String getMessage() {
        return message;
    }

    public static <T> CustomResult<T> success(T data) {
        return new CustomResult<T>(data);
    }

    public static <T> CustomResult<T> success(T data, String message) {
        return new CustomResult<T>(data, message);
    }

    public static <T> CustomResult<T> failure(Error error) {
        return new CustomResult<T>(false, error);
    }

    public static <T> CustomResult<T> failure(String message) {
        return new CustomResult<T>(false, new Error(message));
    }

    public static <T> CustomResult<T> failure(Boolean isError) {
        return new CustomResult<T>(false);
    }

    public static <T> CustomResult<T> unauthorizedException(String message) {
        return new CustomResult<T>(false, new UnauthorizedError(message));
    }

    public static <T> CustomResult<T> entityNotFoundException(String message) {
        return new CustomResult<T>(false, new EntityNotFoundError(message));
    }

    public static <T> CustomResult<T> entityAlreadyExistsException(String message) {
        return new CustomResult<T>(false, new EntityAlreadyExistsError(message));
    }

    public static <T> CustomResult<T> validationException(String message) {
        return new CustomResult<T>(false, new ValidationError(message));
    }

    public <R> CustomResult<R> map(java.util.function.Function<T, R> mapper) {
        if (isSuccess() && data != null) {
            return CustomResult.success(mapper.apply(data));
        }
        return new CustomResult<>(isSuccess(), getException());
    }
}