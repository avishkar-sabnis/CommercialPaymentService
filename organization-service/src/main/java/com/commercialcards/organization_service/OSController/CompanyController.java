package com.commercialcards.organization_service.OSController;

import com.commercialcards.organization_service.OSDto.CompanyRequest;
import com.commercialcards.organization_service.OSDto.CompanyResponse;
import com.commercialcards.organization_service.OSDto.CompanyUpdateRequest;
import com.commercialcards.organization_service.OSEntity.Company;
import com.commercialcards.organization_service.OSService.CompanyService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Blob;
import java.util.UUID;

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

    @GetMapping("/companies/{companyId}")
    public ResponseEntity<CompanyResponse> findCompanyByUUID(@PathVariable UUID companyId){
        CompanyResponse companyByUuid = companyService.findCompanyByUuid(companyId);
        return new ResponseEntity<>(companyByUuid,HttpStatus.OK);

    }

    @PutMapping("/companies/updateCompany/{companyId}")
    public ResponseEntity<CompanyResponse> updateCompanyByCompanyName(@PathVariable UUID companyId,
                                                                      @RequestBody CompanyUpdateRequest companyName){
        CompanyResponse companyResponse = companyService.updateCompanyName(companyId,companyName);
        return new ResponseEntity<>(companyResponse,HttpStatus.OK);

    }

    @PatchMapping("/companies/{companyId}/activate") //patch mapping because we only modify company status from pending to activate
    public ResponseEntity<CompanyResponse> activateCompany(@PathVariable UUID companyId){
        companyService.activateCompany(companyId);
        return new ResponseEntity<>(HttpStatus.OK);
        
    }

}
