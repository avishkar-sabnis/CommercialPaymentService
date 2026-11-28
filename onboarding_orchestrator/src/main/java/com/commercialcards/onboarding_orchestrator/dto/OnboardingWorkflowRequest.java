package com.commercialcards.onboarding_orchestrator.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;


public class OnboardingWorkflowRequest {


    @NotBlank(message = "Company name cannot be blank")
    @Size(max = 100, message = "Company name cannot exceed 100 characters")
    private String companyName;

    @NotBlank(message = "Registration number cannot be blank")
    @Size(max = 50, message = "Registration number cannot exceed 50 characters")
    private String companyRegistrationNumber;

    @NotBlank(message = "Country code is required")
    @Size(min = 2, max = 2, message = "Country code must be 2 characters")
    @Pattern(
            regexp = "^[A-Z]{2}$",
            message = "Country code must contain two uppercase letters"
    )
    private String country;

    public OnboardingWorkflowRequest() {
    }

    public OnboardingWorkflowRequest(String companyName, String companyRegistrationNumber, String country) {
        this.companyName = companyName;
        this.companyRegistrationNumber = companyRegistrationNumber;
        this.country = country;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyRegistrationNumber() {
        return companyRegistrationNumber;
    }

    public void setCompanyRegistrationNumber(String companyRegistrationNumber) {
        this.companyRegistrationNumber = companyRegistrationNumber;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
