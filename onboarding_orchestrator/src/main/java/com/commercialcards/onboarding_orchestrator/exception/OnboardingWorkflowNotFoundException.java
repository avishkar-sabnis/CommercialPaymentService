package com.commercialcards.onboarding_orchestrator.exception;

public class OnboardingWorkflowNotFoundException extends RuntimeException{

    public OnboardingWorkflowNotFoundException() {
    }

    public OnboardingWorkflowNotFoundException(String message) {
        super(message);
    }

    public OnboardingWorkflowNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public OnboardingWorkflowNotFoundException(Throwable cause) {
        super(cause);
    }

    public OnboardingWorkflowNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
