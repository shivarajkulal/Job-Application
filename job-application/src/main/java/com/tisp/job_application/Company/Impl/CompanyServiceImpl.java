package com.tisp.job_application.Company.Impl;

import com.tisp.job_application.Company.Company;
import com.tisp.job_application.Company.CompanyRepository;
import com.tisp.job_application.Company.CompanyService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {

    CompanyRepository companyRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    @Override
    public void createCompany(Company company) {
        companyRepository.save(company);
    }

    @Override
    public Company getCompanyById(Long id) {
        return companyRepository.findById(id).orElse(null);
    }

    @Override
    public boolean deleteCompanyById(Long id) {
      try{
          companyRepository.deleteById(id);
          return true;
      } catch (Exception e) {
          return false;
      }
    }

    @Override
    public boolean updateCompany(Long id, Company updatedCompany) {
        Optional<Company> CompanyOptional = companyRepository.findById(id);
        if(CompanyOptional.isPresent()){
            Company company = CompanyOptional.get();
            company.setName(updatedCompany.getName());
            company.setDescription(updatedCompany.getDescription());
            company.setJobs(updatedCompany.getJobs());
            companyRepository.save(company);
            return true;
        } else return false;
    }
}
