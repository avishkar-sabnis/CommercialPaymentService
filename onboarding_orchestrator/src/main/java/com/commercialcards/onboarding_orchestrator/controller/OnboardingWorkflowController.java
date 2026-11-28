package com.commercialcards.onboarding_orchestrator.controller;

import com.commercialcards.onboarding_orchestrator.domain.OnboardingWorkflow;
import com.commercialcards.onboarding_orchestrator.dto.OnboardingWorkflowRequest;
import com.commercialcards.onboarding_orchestrator.mapper.OnboardingWorkflowReqMapper;
import com.commercialcards.onboarding_orchestrator.service.OnboardingWorkflowService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/onboarding")
public class OnboardingWorkflowController {

    private final OnboardingWorkflowService onboardingWorkflowService;

    public OnboardingWorkflowController(OnboardingWorkflowService onboardingWorkflowService) {
        this.onboardingWorkflowService = onboardingWorkflowService;
    }

    @PostMapping("/saveWorkflow")
    ResponseEntity<OnboardingWorkflowRequest> saveOnboardingWorkflow(@RequestBody OnboardingWorkflow onboardingWorkflow){
        OnboardingWorkflowRequest workflow = onboardingWorkflowService.saveOnboardingWorkflow(onboardingWorkflow);
        return new ResponseEntity<>(workflow,HttpStatus.CREATED);

    }
    @GetMapping("/findWorkflowById/{onboardingWorkflow}")
    ResponseEntity<OnboardingWorkflowRequest> findWorkflowById(@PathVariable UUID onboardingWorkflow){
        OnboardingWorkflowRequest workflow = onboardingWorkflowService.findWorkflowById(onboardingWorkflow);
        return new ResponseEntity<>(workflow,HttpStatus.OK);
    }


}
