package com.commercialcards.organization_service.OSRepository;

import com.commercialcards.organization_service.OSEntity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CompanyRepo extends JpaRepository<Company, UUID> {

    public boolean existsByCompanyCountryAndCompanyRegistrationNumber(String companyCountry,String companyRegistrationNumber);

}
