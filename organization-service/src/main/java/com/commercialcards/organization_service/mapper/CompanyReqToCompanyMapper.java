package com.commercialcards.organization_service.mapper;

import com.commercialcards.organization_service.OSDto.CompanyRequest;
import com.commercialcards.organization_service.OSEntity.Company;
import com.commercialcards.organization_service.OSEnum.CompanyStatus;
import org.springframework.stereotype.Component;

@Component
public class CompanyReqToCompanyMapper {

    public Company mapCompanyRequestToCompany(CompanyRequest companyRequest){
        return new Company(companyRequest.getCompanyName(), companyRequest.getCompanyRegistrationNumber(),
                companyRequest.getCompanyCountry());
    }
}
