package com.commercialcards.organization_service.OsException;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(CompanyExistsException.class)
    public ResponseEntity<String> handleDuplicateCompany(CompanyExistsException companyExistsException){
        return new ResponseEntity<>(companyExistsException.getMessage(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(CompanyNotFoundException.class)
    public ResponseEntity<String> companyNotFound(CompanyNotFoundException companyNotFoundException){
        return new ResponseEntity<>(companyNotFoundException.getMessage(), HttpStatusCode.valueOf(404));
    }


}
