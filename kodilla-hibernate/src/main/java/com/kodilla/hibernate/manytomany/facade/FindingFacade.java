package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindingFacade {
    @Autowired
    private CompanyDao companyDao;

    @Autowired
    private EmployeeDao employeeDao;

    private static final Logger LOGGER = LoggerFactory.getLogger(FindingFacade.class);

    public List<Company> findingCompany(final String letters) throws FindingProcessException {
        String arg = "%" + letters + "%";
        LOGGER.info("Searching process has been started.");
        List<Company> companies = companyDao.retrieveCompanyContainingLetters(arg);
        if (companies.size() <= 0) {
            LOGGER.error("Error!");
            throw new FindingProcessException(FindingProcessException.CANNOT_FIND_COMPANY);
        }
        LOGGER.info("Results of searching process: " + companies);
        return companies;
    }

    public List<Employee> findingEmployee(final String letters) throws FindingProcessException {
        String arg = "%" + letters + "%";
        LOGGER.info("Searching process has been started.");
        List<Employee> employees = employeeDao.retrieveEmployeeContainingLetters(arg);
        if (employees.size() <= 0) {
            LOGGER.error("Error!");
            throw new FindingProcessException(FindingProcessException.CANNOT_FIND_COMPANY);
        }
        LOGGER.info("Results of searching process: " + employees);
        return employees;
    }
}
