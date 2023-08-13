package com.example.carauthorization.service.concretes;

import com.example.carauthorization.model.Company;
import com.example.carauthorization.repository.CompanyRepository;
import com.example.carauthorization.service.abstracts.CompanyService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CompanyManager implements CompanyService {

    private final CompanyRepository companyRepository;

    @Override
    public List<Company> getAllCompany() {
        return companyRepository.findAll();
    }

    @Override
    public Optional<Company> getCompanyById(Long companyId) {
        return companyRepository.findById(companyId);
    }
    @Override

    public Company createCompany(Company company) {
        return companyRepository.save(company);
    }
    @Override

    public Company updateCompany(Long companyId, Company updatedCompany) {
        Optional<Company> company = companyRepository.findById(companyId);
        if (company.isPresent()) {
            Company foundCompany = company.get();
            foundCompany.setCompany_id(updatedCompany.getCompany_id());
            foundCompany.setCompanyName(updatedCompany.getCompanyName());
            return companyRepository.save(foundCompany);
        }
        return null;
    }
    @Override

    public void deleteCompany(Long companyId) {
        companyRepository.deleteById(companyId);
    }
}
