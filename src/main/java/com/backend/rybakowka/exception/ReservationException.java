package com.backend.rybakowka.exception;

public class ReservationException extends RuntimeException {
    public ReservationException() {
        super();
    }

    public ReservationException(String s) {
        super(s);
    }

    public ReservationException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public ReservationException(Throwable throwable) {
        super(throwable);
    }

    protected ReservationException(String s, Throwable throwable, boolean b, boolean b1) {
        super(s, throwable, b, b1);
    }
}
