package com.commercialcards.onboarding_orchestrator.controller;

import com.commercialcards.onboarding_orchestrator.domain.OnboardingWorkflow;
import com.commercialcards.onboarding_orchestrator.dto.OnboardingWorkflowRequest;
import com.commercialcards.onboarding_orchestrator.dto.OnboardingWorkflowResponse;
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
    ResponseEntity<OnboardingWorkflowResponse> saveOnboardingWorkflow(@RequestBody OnboardingWorkflowRequest onboardingWorkflowRequest){

        OnboardingWorkflowResponse workflow = onboardingWorkflowService.saveOnboardingWorkflow(onboardingWorkflowRequest);
        return new ResponseEntity<>(workflow,HttpStatus.CREATED);

    }
    @GetMapping("/findWorkflowById/{onboardingWorkflow}")
    ResponseEntity<OnboardingWorkflowResponse> findWorkflowById(@PathVariable UUID onboardingWorkflow){
        OnboardingWorkflowResponse workflow = onboardingWorkflowService.findWorkflowById(onboardingWorkflow);
        return new ResponseEntity<>(workflow,HttpStatus.OK);
    }


}
