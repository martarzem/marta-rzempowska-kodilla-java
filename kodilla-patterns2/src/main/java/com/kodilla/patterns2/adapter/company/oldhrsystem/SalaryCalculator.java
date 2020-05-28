package com.kodilla.patterns2.adapter.company.oldhrsystem;

// interfejs do obliczania łącznego kosztu wynagrodzenia pracowników w starym systemie HR
public interface SalaryCalculator {
    double totalSalary(String[][] workers, double[] salaries);
}
