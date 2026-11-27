package com.commercialcards.onboarding_orchestrator.domain;

import com.commercialcards.onboarding_orchestrator.enums.OnboardingStatus;
import com.commercialcards.onboarding_orchestrator.exception.InvalidOnboardingTransitionException;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name= "onboarding_orchestrator")
public class OnboardingWorkflow {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "workflowId", nullable = false)
    private UUID workflowId;

    @NotBlank(message = "Company name cannot be blank")
    @Size(max = 100, message = "Company name cannot exceed 100 characters")
    @Column(name = "companyName", nullable = false, length = 100)
    private String companyName;

    @NotBlank(message = "Registration number cannot be blank")
    @Size(max = 50, message = "Registration number cannot exceed 50 characters")
    @Column(name = "companyRegistrationNumber", nullable = false, length = 50)
    private String companyRegistrationNumber;

    @NotBlank(message = "Country code is required")
    @Size(min = 2, max = 2, message = "Country code must be 2 characters")
    @Pattern(
            regexp = "^[A-Z]{2}$",
            message = "Country code must contain two uppercase letters"
    )
    @Column(name = "companyCountry", nullable = false, length = 2, columnDefinition = "CHAR(2)")
    private String country;

    @NotNull(message = "onboardingStatus status is required")
    @Enumerated(EnumType.STRING)
    @Column(name = "onboardingStatus", nullable = false, length = 20)
    private OnboardingStatus onboardingStatus;

    @Column(name = "createdDate", nullable = false, updatable = false)
    private Instant createdDate;

    @Column(name = "updatedDate", nullable = false)
    private Instant updatedDate;

    public OnboardingWorkflow() {
    }

    @PrePersist
    protected void onCreate() {
        Instant now = Instant.now();
        this.createdDate = now;
        this.updatedDate = now;
        this.onboardingStatus = OnboardingStatus.RECEIVED;
    }
    @PreUpdate
    protected void onUpdate() {
        this.updatedDate = Instant.now();
    }

    public OnboardingWorkflow(UUID workflowId, String companyName, String companyRegistrationNumber, String country, OnboardingStatus onboardingStatus, Instant createdDate, Instant updatedDate) {
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

    public String getcompanyRegistrationNumber() {
        return companyRegistrationNumber;
    }

    public void setcompanyRegistrationNumber(String companyRegistrationNumber) {
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

    public void transitionTo(OnboardingStatus nextStatus) {

        if (this.onboardingStatus == OnboardingStatus.RECEIVED
                && nextStatus == OnboardingStatus.VALIDATING_COMPANY) {

            this.onboardingStatus = OnboardingStatus.VALIDATING_COMPANY;

        } else if (this.onboardingStatus == OnboardingStatus.VALIDATING_COMPANY
                && nextStatus == OnboardingStatus.PROCESSING) {

            this.onboardingStatus = OnboardingStatus.PROCESSING;

        } else if (this.onboardingStatus == OnboardingStatus.VALIDATING_COMPANY
                && nextStatus == OnboardingStatus.COMPANY_INVALID) {
            this.onboardingStatus = OnboardingStatus.COMPANY_INVALID;
        } else if (this.onboardingStatus == OnboardingStatus.PROCESSING
                && nextStatus == OnboardingStatus.REGISTRATION_COMPLETED) {

            this.onboardingStatus = OnboardingStatus.REGISTRATION_COMPLETED;

        } else if (this.onboardingStatus == OnboardingStatus.REGISTRATION_COMPLETED
                && nextStatus == OnboardingStatus.ONBOARDED) {

            this.onboardingStatus = OnboardingStatus.ONBOARDED;

        } else if (this.onboardingStatus == OnboardingStatus.PROCESSING
                && nextStatus == OnboardingStatus.FAILED) {

            this.onboardingStatus = OnboardingStatus.FAILED;

        }
        else {
            throw new InvalidOnboardingTransitionException("Invalid Status Transition");
        }
    }
}
