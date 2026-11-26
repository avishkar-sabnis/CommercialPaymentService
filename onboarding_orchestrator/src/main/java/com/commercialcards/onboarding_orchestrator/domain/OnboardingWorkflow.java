package com.commercialcards.onboarding_orchestrator.domain;

import com.commercialcards.onboarding_orchestrator.enums.OnboardingStatus;
import java.time.Instant;
import java.util.UUID;

public class OnboardingWorkflow {

    private UUID workflowId;
    private String companyName;
    private String registrationNumber;
    private String country;
    private OnboardingStatus onboardingStatus;
    private Instant createdDate;
    private Instant updatedDate;

    public OnboardingWorkflow() {
    }

    public OnboardingWorkflow(UUID workflowId, String companyName, String registrationNumber, String country, OnboardingStatus onboardingStatus, Instant createdDate, Instant updatedDate) {
        this.workflowId = workflowId;
        this.companyName = companyName;
        this.registrationNumber = registrationNumber;
        this.country = country;
        this.onboardingStatus = onboardingStatus;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }

    public UUID getWorkflowId() {
        return workflowId;
    }

    public void setWorkflowId(UUID workflowId) {
        this.workflowId = workflowId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public OnboardingStatus getOnboardingStatus() {
        return onboardingStatus;
    }

    public Instant getcreatedDate() {
        return createdDate;
    }

    public void setcreatedDate(Instant createdDate) {
        this.createdDate = createdDate;
    }

    public Instant getupdatedDate() {
        return updatedDate;
    }

    public void setupdatedDate(Instant updatedDate) {
        this.updatedDate = updatedDate;
    }

    public void transitionTo(OnboardingStatus onboardingStatus){

        if(onboardingStatus == OnboardingStatus.RECEIVED){
            onboardingStatus = OnboardingStatus.VALIDATING_COMPANY;
        }else if(onboardingStatus == OnboardingStatus.VALIDATING_COMPANY)
            onboardingStatus = OnboardingStatus.PROCESSING;
        else if (onboardingStatus == OnboardingStatus.PROCESSING)
            onboardingStatus = OnboardingStatus.REGISTRATION_COMPLETED;
        else if (onboardingStatus == OnboardingStatus.REGISTRATION_COMPLETED)
            onboardingStatus = OnboardingStatus.ONBOARDED;


    }
}
