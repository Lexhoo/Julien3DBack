package com.example.Julien3DBack.exceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class DataApplicationException extends RuntimeException {

    public DataApplicationException() {
        super();
    }
    public DataApplicationException(String message, Throwable cause) {
        super(message, cause);
    }
    public DataApplicationException(String message) {
        super(message);
    }
    public DataApplicationException(Throwable cause) {
        super(cause);
    }
}
