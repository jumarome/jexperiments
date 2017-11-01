package com.javamasters;

import com.javamasters.employee.Employee;
import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.assertThat;


public class EmployeeHashTest {
    private List<Employee> employees;
    private Set<Employee> employeeSet;
    private final double raisePercentage = 20.0;

    @Before
    public void init() {
        this.employees = new ArrayList<>();
        this.employeeSet = new HashSet<>();
        Employee juan = new Employee("juan", 28, 1100);
        Employee andres = new Employee("andres", 35, 1300);
        employees.addAll(Arrays.asList(juan, andres));
        employeeSet.addAll(Arrays.asList(juan, andres));
    }

    @Test
    public void shouldIncreaseEmployeeSalariesInList() {
        Map<String, Double> oldSalaries = getOldSalaries(employees);
        employees.forEach(e -> e.giveRaise(raisePercentage));
        employees.forEach(e -> {
            double oldSalary = oldSalaries.get(e.getId());
            assertThat(e.getSalary(), greaterThan(oldSalary));
        });
    }

    @Test
    public void shouldIncreaseEmployeeSalariesInSet(){
        Map<String, Double> oldSalaries = getOldSalaries(employeeSet);
        employeeSet.forEach(e -> e.giveRaise(raisePercentage));
        employeeSet.forEach(e -> {
            double oldSalary = oldSalaries.get(e.getId());
            assertThat(e.getSalary(), greaterThan(oldSalary));
        });
    }

    Map<String,Double> getOldSalaries(Collection<Employee> employees){
        return  employees.stream().collect(Collectors.toMap(Employee::getId,Employee::getSalary));
    }


}
