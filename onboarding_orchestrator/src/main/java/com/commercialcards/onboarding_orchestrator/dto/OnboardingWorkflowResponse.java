package com.commercialcards.onboarding_orchestrator.dto;

import com.commercialcards.onboarding_orchestrator.enums.OnboardingStatus;

import java.time.Instant;
import java.util.UUID;

public class OnboardingWorkflowResponse {

    private UUID workflowId;
    private String companyName;
    private String companyRegistrationNumber;
    private String country;
    private OnboardingStatus onboardingStatus;
    private Instant createdDate;
    private Instant updatedDate;

    public OnboardingWorkflowResponse() {
    }

    public OnboardingWorkflowResponse(UUID workflowId, String companyName,
                                      String companyRegistrationNumber, String country,
                                      OnboardingStatus onboardingStatus,
                                      Instant createdDate, Instant updatedDate) {
        this.workflowId = workflowId;
        this.companyName = companyName;
        this.companyRegistrationNumber = companyRegistrationNumber;
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

    public OnboardingStatus getOnboardingStatus() {
        return onboardingStatus;
    }

    public void setOnboardingStatus(OnboardingStatus onboardingStatus) {
        this.onboardingStatus = onboardingStatus;
    }

    public Instant getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Instant createdDate) {
        this.createdDate = createdDate;
    }

    public Instant getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Instant updatedDate) {
        this.updatedDate = updatedDate;
    }
}