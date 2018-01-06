package com.backend.rybakowka.exception;

public class TypeException extends RuntimeException{
    public TypeException() {
        super();
    }

    public TypeException(String s) {
        super(s);
    }

    public TypeException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public TypeException(Throwable throwable) {
        super(throwable);
    }

    protected TypeException(String s, Throwable throwable, boolean b, boolean b1) {
        super(s, throwable, b, b1);
    }
}
