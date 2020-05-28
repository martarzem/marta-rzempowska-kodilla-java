package com.kodilla.hibernate.manytomany.dao;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

//kontroler repozytorium dla encji Company
@Transactional
@Repository
public interface CompanyDao extends CrudRepository<Company, Integer> {
    @Query
    List<Company> retrieveCompanyStartedWithLetters(@Param("LETTERS") String letters);

    @Query
    List<Company> retrieveCompanyContainingLetters(@Param("LETTERS") String letters);

}
