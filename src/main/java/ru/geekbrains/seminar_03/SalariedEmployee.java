package ru.geekbrains.seminar_03;

public class SalariedEmployee extends Employee {

    private double salary;

    public SalariedEmployee(String name, double salary) {
        super(name);
        this.salary = salary;
    }

    @Override
    public double calculateAverageSalary() {
        return salary;
    }
}
