package com.commercialcards.onboarding_orchestrator.service;

import com.commercialcards.onboarding_orchestrator.domain.OnboardingWorkflow;
import com.commercialcards.onboarding_orchestrator.dto.OnboardingWorkflowRequest;
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
    public OnboardingWorkflowRequest saveOnboardingWorkflow(OnboardingWorkflow onboardingWorkflow) {
        OnboardingWorkflow onboardingWorkflow1 = onboardingWorkflowRepository.save(onboardingWorkflow);
        return OnboardingWorkflowReqMapper.getOnboardingWorkflowRequest(onboardingWorkflow1);
    }

    @Transactional(readOnly = true)
    public OnboardingWorkflowRequest findWorkflowById(UUID workflowId) {

        Optional<OnboardingWorkflow> workflow = onboardingWorkflowRepository.findById(workflowId);
        if(workflow.isPresent()) {
            OnboardingWorkflow workflow1 = workflow.get();
            return OnboardingWorkflowReqMapper.getOnboardingWorkflowRequest(workflow1);
        } else
            throw new OnboardingWorkflowNotFoundException("Workflow Does Not Exists");

    }



}
