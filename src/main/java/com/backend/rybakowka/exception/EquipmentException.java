package com.backend.rybakowka.exception;

public class EquipmentException extends RuntimeException{
    public EquipmentException() {
        super();
    }

    public EquipmentException(String s) {
        super(s);
    }

    public EquipmentException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public EquipmentException(Throwable throwable) {
        super(throwable);
    }

    protected EquipmentException(String s, Throwable throwable, boolean b, boolean b1) {
        super(s, throwable, b, b1);
    }
}
