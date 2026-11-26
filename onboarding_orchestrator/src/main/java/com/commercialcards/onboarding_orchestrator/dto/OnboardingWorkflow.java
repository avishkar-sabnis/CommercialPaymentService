package com.commercialcards.onboarding_orchestrator.dto;

import com.commercialcards.onboarding_orchestrator.enums.OnboardingStatus;
import jakarta.persistence.Column;

import java.time.Instant;
import java.util.UUID;

public class OnboardingWorkflow {

    private UUID workflowId;
    private String companyName;
    private long registrationNumber;
    private String country;
    private OnboardingStatus onboardingStatus;
    private Instant companyCreatedDate;
    private Instant companyUpdatedDate;

    public OnboardingWorkflow() {
    }

    public OnboardingWorkflow(UUID workflowId, String companyName, long registrationNumber, String country, OnboardingStatus onboardingStatus, Instant companyCreatedDate, Instant companyUpdatedDate) {
        this.workflowId = workflowId;
        this.companyName = companyName;
        this.registrationNumber = registrationNumber;
        this.country = country;
        this.onboardingStatus = onboardingStatus;
        this.companyCreatedDate = companyCreatedDate;
        this.companyUpdatedDate = companyUpdatedDate;
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

    public long getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(long registrationNumber) {
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

    public Instant getCompanyCreatedDate() {
        return companyCreatedDate;
    }

    public void setCompanyCreatedDate(Instant companyCreatedDate) {
        this.companyCreatedDate = companyCreatedDate;
    }

    public Instant getCompanyUpdatedDate() {
        return companyUpdatedDate;
    }

    public void setCompanyUpdatedDate(Instant companyUpdatedDate) {
        this.companyUpdatedDate = companyUpdatedDate;
    }
}
