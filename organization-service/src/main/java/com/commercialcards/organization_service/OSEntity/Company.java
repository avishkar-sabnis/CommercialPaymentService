package com.commercialcards.organization_service.OSEntity;

import com.commercialcards.organization_service.OSDto.CompanyStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.time.Instant;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(
        name = "companies",
        uniqueConstraints = {
                @UniqueConstraint(
                        columnNames = {"companyCountry", "companyRegistrationNumber"}
                )
        }
)
public class Company {


    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID companyId;

    @Size(max = 100,message = "Official display name")
    @NotBlank(message = "Company Name cannot be blank")
    @Column(name = "companyName", nullable = false)
    private String companyName;


    @Column(name = "companyRegistrationNumber", nullable = false)
    @NotBlank(message = "Registration number cannot be blank")
    private String companyRegistrationNumber;

    @NotBlank(message = "Country code is required")
    @Size(min = 2, max = 2, message = "Country code must be 2 characters")
    @Pattern(regexp = "^[A-Z]{2}$", message = "Country code must be a valid ISO 3166-1 alpha-2 code (e.g., IN, US)")
    @Column(name = "companyCountry", nullable = false, length = 2, columnDefinition = "CHAR(2)")
    private String companyCountry;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "Company Status  is required")
    @Column(name = "companyStatus", nullable = false)
    private CompanyStatus companyStatus ;

    @Column(name = "companyUpdatedDate", nullable = false)
    private Instant companyUpdatedDate;

    @PrePersist
    protected void onCreate() {
        this.companyUpdatedDate = Instant.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.companyUpdatedDate = Instant.now();
    }

    public Company() {
    }

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

    public Instant getCompanyUpdatedDate() {
        return companyUpdatedDate;
    }

    public void setCompanyUpdatedDate(Instant companyUpdatedDate) {
        this.companyUpdatedDate = companyUpdatedDate;
    }

    public Company(UUID companyId, String companyName, String companyRegistrationNumber, String companyCountry, CompanyStatus companyStatus, Instant companyUpdatedDate) {
        this.companyId = companyId;
        this.companyName = companyName;
        this.companyRegistrationNumber = companyRegistrationNumber;
        this.companyCountry = companyCountry;
        this.companyStatus = companyStatus;
        this.companyUpdatedDate = companyUpdatedDate;
    }
}
