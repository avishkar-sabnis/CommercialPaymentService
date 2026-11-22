package com.commercialcards.organization_service.OsException;

import org.springframework.stereotype.Component;


public class CompanyExistsException extends RuntimeException {


    public CompanyExistsException() {
    }

    public CompanyExistsException(String message) {
        super(message);
    }

    public CompanyExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public CompanyExistsException(Throwable cause) {
        super(cause);
    }

    public CompanyExistsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
