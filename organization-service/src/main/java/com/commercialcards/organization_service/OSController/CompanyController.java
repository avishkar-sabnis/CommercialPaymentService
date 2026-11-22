package com.commercialcards.organization_service.OSController;

import com.commercialcards.organization_service.OSDto.CompanyRequest;
import com.commercialcards.organization_service.OSDto.CompanyResponse;
import com.commercialcards.organization_service.OSService.CompanyService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class CompanyController {

    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }


    @PostMapping("/registerCompany")
    public ResponseEntity<CompanyResponse> registerCompany(@Valid @RequestBody CompanyRequest companyRequest){
        CompanyResponse companyResponse = companyService.companyRegistration(companyRequest);

        return new ResponseEntity<>(companyResponse, HttpStatus.CREATED);
    }

}
