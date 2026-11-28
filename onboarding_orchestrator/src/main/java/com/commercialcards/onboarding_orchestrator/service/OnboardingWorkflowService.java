package com.commercialcards.onboarding_orchestrator.service;

import com.commercialcards.onboarding_orchestrator.domain.OnboardingWorkflow;
import com.commercialcards.onboarding_orchestrator.dto.OnboardingWorkflowRequest;
import com.commercialcards.onboarding_orchestrator.dto.OnboardingWorkflowResponse;
import com.commercialcards.onboarding_orchestrator.exception.OnboardingWorkflowNotFoundException;
import com.commercialcards.onboarding_orchestrator.mapper.OnboardingWorkflowReqMapper;
import com.commercialcards.onboarding_orchestrator.repository.OnboardingWorkflowRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Service
public class OnboardingWorkflowService {

    private final OnboardingWorkflowRepository onboardingWorkflowRepository;

    public OnboardingWorkflowService(OnboardingWorkflowRepository onboardingWorkflowRepository) {
        this.onboardingWorkflowRepository = onboardingWorkflowRepository;
    }

    @Transactional
    public OnboardingWorkflowResponse saveOnboardingWorkflow(OnboardingWorkflowRequest onboardingWorkflowRequest) {
        OnboardingWorkflow onboardingWorkflows= OnboardingWorkflowReqMapper.getOnboardingWorkflowRequest(onboardingWorkflowRequest);
        OnboardingWorkflow onboardingWorkflow1 = onboardingWorkflowRepository.save(onboardingWorkflows);
        return OnboardingWorkflowReqMapper.getOnboardingWorkflowResponse(onboardingWorkflow1);
    }

    @Transactional(readOnly = true)
    public OnboardingWorkflowResponse findWorkflowById(UUID workflowId) {

        Optional<OnboardingWorkflow> workflow = onboardingWorkflowRepository.findById(workflowId);
        if(workflow.isPresent()) {
            OnboardingWorkflow workflow1 = workflow.get();
            return OnboardingWorkflowReqMapper.getOnboardingWorkflowResponse(workflow1);
        } else
            throw new OnboardingWorkflowNotFoundException("Workflow Does Not Exists");

    }



}
