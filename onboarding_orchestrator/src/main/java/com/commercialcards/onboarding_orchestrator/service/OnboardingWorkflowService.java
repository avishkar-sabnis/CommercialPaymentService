package com.commercialcards.onboarding_orchestrator.service;

import com.commercialcards.onboarding_orchestrator.domain.OnboardingWorkflow;
import com.commercialcards.onboarding_orchestrator.domain.OnboardingWorkflowRequest;
import com.commercialcards.onboarding_orchestrator.repository.OnboardingWorkflowRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class OnboardingWorkflowService {

    OnboardingWorkflowRepository onboardingWorkflowRepository;

    public OnboardingWorkflowService(OnboardingWorkflowRepository onboardingWorkflowRepository) {
        this.onboardingWorkflowRepository = onboardingWorkflowRepository;
    }

    @Transactional
    public OnboardingWorkflow onboardingWorkflow(OnboardingWorkflow onboardingWorkflow){
        OnboardingWorkflow saveWorkFlow = onboardingWorkflowRepository.save(onboardingWorkflow);
        return saveWorkFlow;
    }

    public OnboardingWorkflow findWorkflowById(UUID workflowId) {

        Optional<OnboardingWorkflow> workflow = onboardingWorkflowRepository.findById(workflowId);
        if(workflow.isPresent())
            return workflow.get();
        else
            throw new RuntimeException("Workflow Does Not Exists");

    }

}
