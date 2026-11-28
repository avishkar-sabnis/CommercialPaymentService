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
        
        return onboardingWorkflowResponse;
    }

}
