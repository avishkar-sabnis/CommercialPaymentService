package com.commercialcards.organization_service.OSService;

import com.commercialcards.organization_service.OSDto.CompanyRequest;
import com.commercialcards.organization_service.OSDto.CompanyResponse;
import com.commercialcards.organization_service.OSEntity.Company;
import com.commercialcards.organization_service.OSRepository.CompanyRepo;
import com.commercialcards.organization_service.OsException.CompanyExistsException;
import com.commercialcards.organization_service.mapper.CompanyReqToCompanyMapper;
import org.springframework.stereotype.Service;


@Service
public class CompanyService {

    private final CompanyRepo companyRepo;

    private final CompanyReqToCompanyMapper companyReqToCompanyMapper;

    public CompanyService(CompanyRepo companyRepo, CompanyReqToCompanyMapper companyReqToCompanyMapper) {
        this.companyRepo = companyRepo;
        this.companyReqToCompanyMapper = companyReqToCompanyMapper;
    }

    public CompanyResponse companyRegistration(CompanyRequest companyRequest) throws CompanyExistsException {

        boolean b = companyRepo.existsByCompanyCountryAndCompanyRegistrationNumber(companyRequest.getCompanyCountry()
                , companyRequest.getCompanyRegistrationNumber());
        if(b){
            throw new CompanyExistsException("Company Already Exists");
        }

        Company company = companyReqToCompanyMapper.mapCompanyRequestToCompany(companyRequest);
        Company companyResponse = companyRepo.save(company);
        return getCompanyResponse(companyResponse);

    }

    private static CompanyResponse getCompanyResponse(Company company) {
        CompanyResponse companyResponse = new CompanyResponse();
        companyResponse.setCompanyCountry(company.getCompanyCountry());
        companyResponse.setCompanyId(company.getCompanyId());
        companyResponse.setCompanyCreatedDate(company.getCompanyCreatedDate());
        companyResponse.setCompanyName(company.getCompanyName());
        companyResponse.setCompanyRegistrationNumber(company.getCompanyRegistrationNumber());
        companyResponse.setCompanyStatus(company.getCompanyStatus());
        companyResponse.setCompanyUpdatedDate(company.getCompanyUpdatedDate());
        return companyResponse;
    }

}
