package com.commercialcards.onboarding_orchestrator.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalHandlerException {

    @ExceptionHandler(InvalidOnboardingTransitionException.class)
    public ResponseEntity<InvalidOnboardingTransitionException> invalidOnboardingTransitionException(InvalidOnboardingTransitionException onboardingTransitionException){
        return new ResponseEntity<>(onboardingTransitionException, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
