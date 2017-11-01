package com.javamasters.employee;

import java.util.Objects;
import java.util.UUID;

public class Employee {
    private String id;
    private String name;
    private int age;
    private double salary;

    public Employee(String name, int age, double salary) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    public void giveRaise(double percentage){
        this.salary *= (1.0 + percentage/100);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(id, employee.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
