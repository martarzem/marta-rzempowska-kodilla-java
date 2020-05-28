package com.kodilla.patterns2.adapter.company;

import com.kodilla.patterns2.adapter.company.oldhrsystem.SalaryCalculator;
import com.kodilla.patterns2.adapter.company.oldhrsystem.Workers;
//import org.junit.Test;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SalaryAdapterTestSuite {
    @Test
    public void testTotalSalary() {
        // Given
        Workers workers = new Workers(); //przechowuje dane ze starego systemu
        SalaryAdapter salaryAdapter = new SalaryAdapter(); // obiekt adaptera
        // When
        // z adaptera wywołujemy metodę starego systemu
        double totalSalary = salaryAdapter.totalSalary(workers.getWorkers(),workers.getSalaries());
        // Then
        System.out.println(totalSalary);
        assertEquals(totalSalary, 27750, 0);
    }
}
