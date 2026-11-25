package com.commercialcards.organization_service.OSDto;

import com.commercialcards.organization_service.OSEntity.Company;

import java.util.List;

public class CompanyPaginatedResponse {

    private List<CompanyResponse> company;
    private int totalPages;
    private int pageableNumber;
    private int pageableSize;
    private long pageTotalElements;
    private boolean hasNext;
    private boolean hasPrevious;


    public CompanyPaginatedResponse(List<CompanyResponse> company, int totalPages, int pageableNumber, int pageableSize, long pageTotalElements, boolean hasNext, boolean hasPrevious) {
        this.company = company;
        this.totalPages = totalPages;
        this.pageableNumber = pageableNumber;
        this.pageableSize = pageableSize;
        this.pageTotalElements = pageTotalElements;
        this.hasNext = hasNext;
        this.hasPrevious = hasPrevious;
    }

    public List<CompanyResponse> getCompany() {
        return company;
    }

    public void setCompany(List<CompanyResponse> company) {
        this.company = company;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getPageableNumber() {
        return pageableNumber;
    }

    public void setPageableNumber(int pageableNumber) {
        this.pageableNumber = pageableNumber;
    }

    public int getPageableSize() {
        return pageableSize;
    }

    public void setPageableSize(int pageableSize) {
        this.pageableSize = pageableSize;
    }

    public long getPageTotalElements() {
        return pageTotalElements;
    }

    public void setPageTotalElements(long pageTotalElements) {
        this.pageTotalElements = pageTotalElements;
    }

    public boolean isHasNext() {
        return hasNext;
    }

    public void setHasNext(boolean hasNext) {
        this.hasNext = hasNext;
    }

    public boolean isHasPrevious() {
        return hasPrevious;
    }

    public void setHasPrevious(boolean hasPrevious) {
        this.hasPrevious = hasPrevious;
    }
}
