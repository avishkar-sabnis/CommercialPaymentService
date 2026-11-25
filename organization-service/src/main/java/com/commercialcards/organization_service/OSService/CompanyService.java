package com.commercialcards.organization_service.OSService;

import com.commercialcards.organization_service.OSDto.CompanyPaginatedResponse;
import com.commercialcards.organization_service.OSDto.CompanyRequest;
import com.commercialcards.organization_service.OSDto.CompanyResponse;
import com.commercialcards.organization_service.OSDto.CompanyUpdateRequest;
import com.commercialcards.organization_service.OSEntity.Company;
import com.commercialcards.organization_service.OSRepository.CompanyRepo;
import com.commercialcards.organization_service.OsException.CompanyExistsException;
import com.commercialcards.organization_service.OsException.CompanyNotFoundException;
import com.commercialcards.organization_service.mapper.CompanyReqToCompanyMapper;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


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
        return getCompanyResponse(companyResponse);     //get company response in required format

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
    private static CompanyPaginatedResponse getPaginatedCompanyResponse(
            List<CompanyResponse> companies,
            int totalPages,
            int pageableNumber,
            int pageableSize,
            long pageTotalElements,
            boolean hasNext,
            boolean hasPrevious) {

        return new CompanyPaginatedResponse(
                companies,
                totalPages,
                pageableNumber,
                pageableSize,
                pageTotalElements,
                hasNext,
                hasPrevious
        );
    }

    public CompanyResponse findCompanyByUuid(UUID companyId) {

        Optional<Company> company = companyRepo.findById(companyId);
        if(company.isPresent())
            return getCompanyResponse(company.get());
        else
            throw new CompanyNotFoundException("Company Does Not Exists");

    }

    @Transactional
    public CompanyResponse updateCompanyName(UUID companyId, CompanyUpdateRequest companyUpdateRequest) {

        Optional<Company> company = companyRepo.findById(companyId);
        if(company.isPresent()){
            company.get().setCompanyName(companyUpdateRequest.getCompanyName());
            Company savedCompany = companyRepo.save(company.get());
            return getCompanyResponse(savedCompany);
        }else
            throw new CompanyNotFoundException("Company Does Not Exists");
    }

    @Transactional
    public CompanyResponse activateCompany(UUID companyId){
        Optional<Company> company = companyRepo.findById(companyId);
        if(company.isPresent()){
            company.get().activate();
        }
        else
            throw new CompanyNotFoundException("Company Does Not Exists");

        return getCompanyResponse(company.get());
    }

    @Transactional
    public CompanyResponse closeCompany(UUID companyId){

        Optional<Company> company = companyRepo.findById(companyId);
        if(company.isPresent()){
            company.get().close();
        }
        else
            throw new CompanyNotFoundException("Company Does Not Exists");

        return getCompanyResponse(company.get());

    }

    @Transactional
    public CompanyResponse suspendCompany(UUID companyId){

        Optional<Company> company = companyRepo.findById(companyId);
        if(company.isPresent()){
            company.get().suspend();
        }
        else
            throw new CompanyNotFoundException("Company Does Not Exists");

        return getCompanyResponse(company.get());

    }

    @Transactional
    public CompanyResponse deactivateCompany(UUID companyId){

        Optional<Company> company = companyRepo.findById(companyId);
        if(company.isPresent()){
            company.get().deactivate();
        }
        else
            throw new CompanyNotFoundException("Company Does Not Exists");

        return getCompanyResponse(company.get());

    }
    @Transactional
    public CompanyResponse reactivateCompany(UUID companyId){

        Optional<Company> company = companyRepo.findById(companyId);
        if(company.isPresent()){
            company.get().reactivate();
        }
        else
            throw new CompanyNotFoundException("Company Does Not Exists");

        return getCompanyResponse(company.get());

    }

    public CompanyPaginatedResponse getAllCompanies(int pageNumber, int pageSize){
        PageRequest pageable = PageRequest.of(pageNumber,pageSize);
        Page<Company> companyResponsePageable = companyRepo.findAll(pageable);
        int totalPages = companyResponsePageable.getTotalPages();
        int pageableNumber = companyResponsePageable.getNumber();
        int pageableSize = companyResponsePageable.getSize();
        long pageTotalElements = companyResponsePageable.getTotalElements();
        boolean hasNext = companyResponsePageable.hasNext();
        boolean hasPrevious = companyResponsePageable.hasPrevious();
        List<Company> allCompanies = companyResponsePageable.getContent();

        List<CompanyResponse> list = allCompanies.stream().map(CompanyService::getCompanyResponse).toList();
        return getPaginatedCompanyResponse(list
        ,totalPages,pageableNumber,pageableSize,pageTotalElements,hasNext,hasPrevious);

    }
}
