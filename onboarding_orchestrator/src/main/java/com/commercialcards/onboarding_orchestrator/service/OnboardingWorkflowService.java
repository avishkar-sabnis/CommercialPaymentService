package com.commercialcards.onboarding_orchestrator.service;

import com.commercialcards.onboarding_orchestrator.domain.OnboardingWorkflow;
import com.commercialcards.onboarding_orchestrator.enums.OnboardingStatus;
import com.commercialcards.onboarding_orchestrator.exception.OnboardingWorkflowNotFoundException;
import com.commercialcards.onboarding_orchestrator.repository.OnboardingWorkflowRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class OnboardingWorkflowService {

    private final OnboardingWorkflowRepository onboardingWorkflowRepository;

    public OnboardingWorkflowService(OnboardingWorkflowRepository onboardingWorkflowRepository) {
        this.onboardingWorkflowRepository = onboardingWorkflowRepository;
    }

    @Transactional
    public OnboardingWorkflow saveOnboardingWorkflo(OnboardingWorkflow onboardingWorkflow){
        List<OnboardingWorkflow> onboardingWorkflows = onboardingWorkflowRepository.findAll();
        if(onboardingWorkflows.isEmpty()){
            onboardingWorkflow.transitionTo(OnboardingStatus.RECEIVED);
        }
        return onboardingWorkflowRepository.save(onboardingWorkflow);
    }

    @Transactional
    public OnboardingWorkflow findWorkflowById(UUID workflowId) {

        Optional<OnboardingWorkflow> workflow = onboardingWorkflowRepository.findById(workflowId);
        if(workflow.isPresent())
            return workflow.get();
        else
            throw new OnboardingWorkflowNotFoundException("Workflow Does Not Exists");

    }

}
