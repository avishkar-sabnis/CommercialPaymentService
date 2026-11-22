
package com.commercialcards.organization_service.OSEntity;

import com.commercialcards.organization_service.OSEnum.CompanyStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.time.Instant;
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
    @Column(name = "companyId", nullable = false)
    private UUID companyId;

    @NotBlank(message = "Company name cannot be blank")
    @Size(max = 100, message = "Company name cannot exceed 100 characters")
    @Column(name = "companyName", nullable = false, length = 100)
    private String companyName;

    @NotBlank(message = "Registration number cannot be blank")
    @Size(max = 50, message = "Registration number cannot exceed 50 characters")
    @Column(name = "companyRegistrationNumber", nullable = false, length = 50)
    private String companyRegistrationNumber;

    @NotBlank(message = "Country code is required")
    @Size(min = 2, max = 2, message = "Country code must be 2 characters")
    @Pattern(
            regexp = "^[A-Z]{2}$",
            message = "Country code must contain two uppercase letters"
    )
    @Column(name = "companyCountry", nullable = false, length = 2, columnDefinition = "CHAR(2)")
    private String companyCountry;

    @NotNull(message = "Company status is required")
    @Enumerated(EnumType.STRING)
    @Column(name = "companyStatus", nullable = false, length = 20)
    private CompanyStatus companyStatus;

    @Column(name = "companyCreatedDate", nullable = false, updatable = false)
    private Instant companyCreatedDate;

    @Column(name = "companyUpdatedDate", nullable = false)
    private Instant companyUpdatedDate;

    public Company() {
        // Required by JPA
    }

    public Company(
            String companyName,
            String companyRegistrationNumber,
            String companyCountry
    ) {
        this.companyName = companyName;
        this.companyRegistrationNumber = companyRegistrationNumber;
        this.companyCountry = companyCountry;
        this.companyStatus = CompanyStatus.PENDING;
    }

    @PrePersist
    protected void onCreate() {
        Instant now = Instant.now();
        this.companyCreatedDate = now;
        this.companyUpdatedDate = now;
    }

    @PreUpdate
    protected void onUpdate() {
        this.companyUpdatedDate = Instant.now();
    }

    public UUID getCompanyId() {
        return companyId;
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

    public Instant getCompanyCreatedDate() {
        return companyCreatedDate;
    }

    public Instant getCompanyUpdatedDate() {
        return companyUpdatedDate;
    }

    // Controlled business operation for status changes
    public void activate() {
        if (this.companyStatus != CompanyStatus.PENDING) {
            throw new IllegalStateException(
                    "Only pending companies can be activated"
            );
        }
        this.companyStatus = CompanyStatus.ACTIVE;
    }

    public void suspend() {
        if (this.companyStatus != CompanyStatus.ACTIVE) {
            throw new IllegalStateException(
                    "Only active companies can be suspended"
            );
        }
        this.companyStatus = CompanyStatus.SUSPENDED;
    }

    public void close() {
        if (this.companyStatus == CompanyStatus.CLOSED) {
            throw new IllegalStateException(
                    "Company is already closed"
            );
        }
        this.companyStatus = CompanyStatus.CLOSED;
    }
}
