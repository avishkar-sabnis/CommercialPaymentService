package com.commercialcards.organization_service.mapper;

import com.commercialcards.organization_service.OSDto.CompanyRequest;
import com.commercialcards.organization_service.OSEntity.Company;
import org.springframework.stereotype.Component;

@Component
public class CompanyReqToCompanyMapper {

    public Company mapCompanyRequestToCompany(CompanyRequest companyRequest){
        Company company = new Company();
        company.setCompanyName(companyRequest.getCompanyName());
        company.setCompanyCountry(companyRequest.getCompanyCountry());
        company.setCompanyRegistrationNumber(companyRequest.getCompanyRegistrationNumber());
        return company;
    }
}
