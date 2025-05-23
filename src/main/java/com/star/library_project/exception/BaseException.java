package com.star.library_project.exception;

public class BaseException extends RuntimeException {

    public BaseException(ErrorMessage errorMessage) {
        super(errorMessage.prepareErrorMessage());
    }
}
