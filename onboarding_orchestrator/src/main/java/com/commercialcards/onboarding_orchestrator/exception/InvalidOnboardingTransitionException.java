package com.commercialcards.onboarding_orchestrator.exception;

public class InvalidOnboardingTransitionException extends RuntimeException {


    public InvalidOnboardingTransitionException() {
    }

    public InvalidOnboardingTransitionException(String message) {
        super(message);
    }

    public InvalidOnboardingTransitionException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidOnboardingTransitionException(Throwable cause) {
        super(cause);
    }

    public InvalidOnboardingTransitionException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
