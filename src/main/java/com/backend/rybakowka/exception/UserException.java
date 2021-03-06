package com.backend.rybakowka.exception;

public class UserException extends RuntimeException {
    public UserException() {
        super();
    }

    public UserException(String s) {
        super(s);
    }

    public UserException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public UserException(Throwable throwable) {
        super(throwable);
    }

    protected UserException(String s, Throwable throwable, boolean b, boolean b1) {
        super(s, throwable, b, b1);
    }
}
