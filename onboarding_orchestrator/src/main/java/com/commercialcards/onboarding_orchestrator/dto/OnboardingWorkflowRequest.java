package com.commercialcards.onboarding_orchestrator.dto;

public class OnboardingWorkflowRequest {

    String companyName;
    String companyRegistrationNumber;
    String country;

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
