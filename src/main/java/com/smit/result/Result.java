package com.smit.result;

import com.smit.result.errors.EntityAlreadyExistsError;
import com.smit.result.errors.EntityNotFoundError;
import com.smit.result.errors.Error;
import com.smit.result.errors.UnauthorizedError;
import com.smit.result.errors.ValidationError;
import com.smit.result.providers.ResultConstantsProvider;

public class Result<T> extends ResultBase {
    private T data;
    private String message;

    public Result(T data) {
        super(true, null);
        this.data = data;
        this.message = ResultConstantsProvider.getInstance().getSuccessMessage();
    }

    public Result(T data, String message) {
        super(true, null);
        this.data = data;
        this.message = message;
    }

    public Result(boolean success) {
        super(success, null);
        this.data = null;
    }

    public Result(boolean success, Error error) {
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

    public static <T> Result<T> success(T data) {
        return new Result<T>(data);
    }

    public static <T> Result<T> success(T data, String message) {
        return new Result<T>(data, message);
    }

    public static <T> Result<T> failure(Error error) {
        return new Result<T>(false, error);
    }

    public static <T> Result<T> failure(String message) {
        return new Result<T>(false, new Error(message));
    }

    public static <T> Result<T> failure(Boolean isError) {
        return new Result<T>(false);
    }

    public static <T> Result<T> unauthorizedException(String message) {
        return new Result<T>(false, new UnauthorizedError(message));
    }

    public static <T> Result<T> entityNotFoundException(String message) {
        return new Result<T>(false, new EntityNotFoundError(message));
    }

    public static <T> Result<T> entityAlreadyExistsException(String message) {
        return new Result<T>(false, new EntityAlreadyExistsError(message));
    }

    public static <T> Result<T> validationException(String message) {
        return new Result<T>(false, new ValidationError(message));
    }

    public <R> Result<R> map(java.util.function.Function<T, R> mapper) {
        if (isSuccess() && data != null) {
            return Result.success(mapper.apply(data));
        }
        return new Result<>(isSuccess(), getException());
    }
}