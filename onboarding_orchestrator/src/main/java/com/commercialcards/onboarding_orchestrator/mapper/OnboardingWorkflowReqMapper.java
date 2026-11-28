package com.commercialcards.onboarding_orchestrator.mapper;

import com.commercialcards.onboarding_orchestrator.domain.OnboardingWorkflow;
import com.commercialcards.onboarding_orchestrator.dto.OnboardingWorkflowRequest;

public class OnboardingWorkflowReqMapper {

    public static OnboardingWorkflowRequest getOnboardingWorkflowRequest(OnboardingWorkflow onboardingWorkflow){

        OnboardingWorkflowRequest onboardingWorkflowRequest = new OnboardingWorkflowRequest();
        onboardingWorkflowRequest.setCompanyName(onboardingWorkflow.getCompanyName());
        onboardingWorkflowRequest.setCompanyRegistrationNumber(onboardingWorkflow.getcompanyRegistrationNumber());
        onboardingWorkflowRequest.setCountry(onboardingWorkflow.getCountry());
        return onboardingWorkflowRequest;
    }

}
