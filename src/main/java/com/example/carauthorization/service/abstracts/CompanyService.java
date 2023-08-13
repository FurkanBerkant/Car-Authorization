package com.example.carauthorization.service.abstracts;

import com.example.carauthorization.model.Company;

import java.util.List;
import java.util.Optional;

public interface CompanyService {
    public List<Company> getAllCompany();
    public Optional<Company> getCompanyById(Long companyId);
    public Company createCompany(Company company);
    public Company updateCompany(Long companyId, Company updatedCompany);
    public void deleteCompany(Long companyId);

}
