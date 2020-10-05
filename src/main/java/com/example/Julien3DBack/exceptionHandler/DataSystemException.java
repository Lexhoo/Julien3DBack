package com.example.Julien3DBack.exceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class DataSystemException extends RuntimeException {

    public DataSystemException() {
        super();
    }
    public DataSystemException(String message, Throwable cause) {
        super(message, cause);
    }
    public DataSystemException(String message) {
        super(message);
    }
    public DataSystemException(Throwable cause) {
        super(cause);
    }
}
