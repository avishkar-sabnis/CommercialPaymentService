package com.commercialcards.organization_service.OsException;

public class InvalidCompanyStateException extends RuntimeException {


    public InvalidCompanyStateException() {
    }

    public InvalidCompanyStateException(String message) {
        super(message);
    }

    public InvalidCompanyStateException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidCompanyStateException(Throwable cause) {
        super(cause);
    }

    public InvalidCompanyStateException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
