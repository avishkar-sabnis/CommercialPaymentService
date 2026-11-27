package com.commercialcards.onboarding_orchestrator.repository;

import com.commercialcards.onboarding_orchestrator.domain.OnboardingWorkflow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OnboardingWorkflowRepository extends JpaRepository<OnboardingWorkflow, UUID> {


}
