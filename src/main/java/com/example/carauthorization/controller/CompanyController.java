package com.example.carauthorization.controller;

import com.example.carauthorization.model.Company;
import com.example.carauthorization.model.UserGroupAuthorization;
import com.example.carauthorization.service.abstracts.CompanyService;
import lombok.AllArgsConstructor;
import org.springframework.data.repository.cdi.Eager;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/companies")
@AllArgsConstructor
public class CompanyController {
    private final CompanyService companyService;

    @GetMapping
    public ResponseEntity<List<Company>> getAllCompany() {
        return new ResponseEntity<>(companyService.getAllCompany(), HttpStatus.OK);
    }
    @GetMapping("/{companyId}")
    public ResponseEntity<Company>getOneCompany(@PathVariable Long companyId) {
        Company company = companyService.getCompanyById(companyId).orElse(null);
        if(company == null) {
            return ResponseEntity.notFound().build();
        }
        return new ResponseEntity<>(company,HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Company> createCompany(@RequestBody Company createCompany) {
        Company company= companyService.createCompany(createCompany);
        return ResponseEntity.status(HttpStatus.CREATED).body(company);
    }
    @PutMapping("/{companyId}")
    public ResponseEntity<Company> updateCompany(@PathVariable Long companyId, @RequestBody Company company) {
        Company updatedCompany = companyService.updateCompany(companyId, company);
        return ResponseEntity.ok(updatedCompany);
    }
    @DeleteMapping("/{companyId}")
    public ResponseEntity<Void> deleteCompany(@PathVariable Long companyId) {
        companyService.deleteCompany(companyId);
        return ResponseEntity.noContent().build();
    }



}
