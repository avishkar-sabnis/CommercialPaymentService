package com.commercialcards.onboarding_orchestrator.mapper;

import com.commercialcards.onboarding_orchestrator.domain.OnboardingWorkflow;
import com.commercialcards.onboarding_orchestrator.dto.OnboardingWorkflowRequest;
import com.commercialcards.onboarding_orchestrator.dto.OnboardingWorkflowResponse;

public class OnboardingWorkflowReqMapper {

    public static OnboardingWorkflowResponse getOnboardingWorkflowResponse(OnboardingWorkflow onboardingWorkflow){

        OnboardingWorkflowResponse onboardingWorkflowResponse = new OnboardingWorkflowResponse();
        onboardingWorkflowResponse.setOnboardingStatus(onboardingWorkflow.getOnboardingStatus());
        onboardingWorkflowResponse.setCreatedDate(onboardingWorkflow.getcreatedDate());
        onboardingWorkflowResponse.setUpdatedDate(onboardingWorkflow.getupdatedDate());
        onboardingWorkflowResponse.setWorkflowId(onboardingWorkflow.getWorkflowId());
        onboardingWorkflowResponse.setCompanyName(
                onboardingWorkflow.getCompanyName());

        onboardingWorkflowResponse.setCompanyRegistrationNumber(
                onboardingWorkflow.getcompanyRegistrationNumber());

        onboardingWorkflowResponse.setCountry(
                onboardingWorkflow.getCountry());
        
        return onboardingWorkflowResponse;
    }
    public static OnboardingWorkflow getOnboardingWorkflowRequest(OnboardingWorkflowRequest onboardingWorkflow){

        OnboardingWorkflow onboardingWorkflows = new OnboardingWorkflow();
        onboardingWorkflows.setCompanyName(
                onboardingWorkflow.getCompanyName());
        onboardingWorkflows.setCountry(
                onboardingWorkflow.getCountry());
        onboardingWorkflows.setcompanyRegistrationNumber(onboardingWorkflow.getCompanyRegistrationNumber());

        return onboardingWorkflows;
    }

}
