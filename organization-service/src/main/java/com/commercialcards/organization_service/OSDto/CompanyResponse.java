package com.commercialcards.organization_service.OSDto;

import com.commercialcards.organization_service.OSEnum.CompanyStatus;

import java.time.Instant;
import java.util.UUID;

// Sends company registration details back to the client
public class CompanyResponse {

    private UUID companyId;

    private String companyName;

    private String companyRegistrationNumber;

    private String companyCountry;

    private CompanyStatus companyStatus;

    private Instant companyCreatedDate;

    private Instant companyUpdatedDate;

    public UUID getCompanyId() {
        return companyId;
    }

    public void setCompanyId(UUID companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyRegistrationNumber() {
        return companyRegistrationNumber;
    }

    public void setCompanyRegistrationNumber(String companyRegistrationNumber) {
        this.companyRegistrationNumber = companyRegistrationNumber;
    }

    public String getCompanyCountry() {
        return companyCountry;
    }

    public void setCompanyCountry(String companyCountry) {
        this.companyCountry = companyCountry;
    }

    public CompanyStatus getCompanyStatus() {
        return companyStatus;
    }

    public void setCompanyStatus(CompanyStatus companyStatus) {
        this.companyStatus = companyStatus;
    }

    public Instant getCompanyCreatedDate() {
        return companyCreatedDate;
    }

    public void setCompanyCreatedDate(Instant companyCreatedDate) {
        this.companyCreatedDate = companyCreatedDate;
    }

    public Instant getCompanyUpdatedDate() {
        return companyUpdatedDate;
    }

    public void setCompanyUpdatedDate(Instant companyUpdatedDate) {
        this.companyUpdatedDate = companyUpdatedDate;
    }
}
