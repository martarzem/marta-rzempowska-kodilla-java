package com.kodilla.hibernate.manytomany.dao;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CompanyDaoTestSuite {
    @Autowired
    private CompanyDao companyDao;
    @Autowired
    private EmployeeDao employeeDao;

    @Test
    public void testSaveManyToMany() {
        //Given
        //tworzymy 3 pracowników
        Employee johnSmith = new Employee("John", "Smith");
        Employee stephanieClarckson = new Employee("Stephanie", "Clarckson");
        Employee lindaKovalsky = new Employee("Linda", "Kovalsky");

        //i 3 firmy
        Company softwareMachine = new Company("Software Machine");
        Company dataMaesters = new Company("Data Maesters");
        Company greyMatter = new Company("Grey Matter");

        //przypisujemy firmie pracowników oraz pracownikom firmy
        softwareMachine.getEmployees().add(johnSmith);
        dataMaesters.getEmployees().add(stephanieClarckson);
        dataMaesters.getEmployees().add(lindaKovalsky);
        greyMatter.getEmployees().add(johnSmith);
        greyMatter.getEmployees().add(lindaKovalsky);

        johnSmith.getCompanies().add(softwareMachine);
        johnSmith.getCompanies().add(greyMatter);
        stephanieClarckson.getCompanies().add(dataMaesters);
        lindaKovalsky.getCompanies().add(dataMaesters);
        lindaKovalsky.getCompanies().add(greyMatter);

        //When
        //za pomocą kontrolera zapisujemy 3 obiekty firmy w bazie
        companyDao.save(softwareMachine);
        int softwareMachineId = softwareMachine.getId();
        companyDao.save(dataMaesters);
        int dataMaestersId = dataMaesters.getId();
        companyDao.save(greyMatter);
        int greyMatterId = greyMatter.getId();

        //Then
        Assert.assertNotEquals(0, softwareMachineId);
        Assert.assertNotEquals(0, dataMaestersId);
        Assert.assertNotEquals(0, greyMatterId);

        //CleanUp
        //sprzątanie po teście opatrzone frazą try-catch w razie, gdyby test nie wykonał się
        //poprawnie i w bazie pozostałyby fragmentaryczne dane, przez co program mógłby napotkać
        //na błąd przy próbie usunięcia nieistniejących danych
        try {
            companyDao.deleteById(softwareMachineId);
            companyDao.deleteById(dataMaestersId);
            companyDao.deleteById(greyMatterId);
        } catch (Exception e) {
            //do nothing
        }
    }

    @Test
    public void testNamedQueries() {
        //Given
        Employee johnSmith = new Employee("John", "Smith");
        Employee peterSmith = new Employee("Peter", "Smith");
        Employee stephanieClarckson = new Employee("Stephanie", "Clarckson");
        Employee lindaKovalsky = new Employee("Linda", "Kovalsky");

        Company dateSoftwareMachine = new Company("DataSoftware Machine");
        Company dataMaesters = new Company("Data Maesters");
        Company dataGreyMatter = new Company("DataGrey Matter");

        dateSoftwareMachine.getEmployees().add(johnSmith);
        dateSoftwareMachine.getEmployees().add(peterSmith);
        dataMaesters.getEmployees().add(stephanieClarckson);
        dataMaesters.getEmployees().add(lindaKovalsky);
        dataGreyMatter.getEmployees().add(johnSmith);
        dataGreyMatter.getEmployees().add(lindaKovalsky);

        johnSmith.getCompanies().add(dateSoftwareMachine);
        peterSmith.getCompanies().add(dataGreyMatter);
        stephanieClarckson.getCompanies().add(dataMaesters);
        lindaKovalsky.getCompanies().add(dataMaesters);
        lindaKovalsky.getCompanies().add(dataGreyMatter);

        companyDao.save(dateSoftwareMachine);
        int softwareMachineId = dateSoftwareMachine.getId();
        companyDao.save(dataMaesters);
        int dataMaestersId = dataMaesters.getId();
        companyDao.save(dataGreyMatter);
        int greyMatterId = dataGreyMatter.getId();

        //When
        List<Employee> listEmployee = employeeDao.retrieveEmployeesWithLastname("Smith");
        List<Company> listCompany = companyDao.retrieveCompanyStartedWithLetters("Dat");

        //Then
        Assert.assertEquals(2, listEmployee.size());
        Assert.assertEquals(3, listCompany.size());

        //CleanUp
        try {
            companyDao.deleteById(softwareMachineId);
            companyDao.deleteById(dataMaestersId);
            companyDao.deleteById(greyMatterId);
        } catch (Exception e) {
            //do nothing
        }
    }
}
