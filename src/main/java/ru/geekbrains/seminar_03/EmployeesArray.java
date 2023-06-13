package ru.geekbrains.seminar_03;


import java.util.Arrays;
import java.util.Comparator;


public class EmployeesArray {
    private Employee[] employees;

    public EmployeesArray(Employee[] employees) {
        this.employees = employees;
    }

    /**
     * Method for displaying information about employees
     */
    public void printEmployeesInfo() {
        for (Employee employee : employees) {
            System.out.println("Name: " + employee.getName() + ", Average Salary: " + employee.calculateAverageSalary());
        }
    }

    /**
     * Method for sorting an array of workers by name
     */
    public void sortByName() {
        Arrays.sort(employees, Comparator.comparing(Employee::getName));
    }

    /**
     * A method for sorting an array of employees by salary
     */
    public void sortByAverageSalary() {
        Arrays.sort(employees, Comparator.comparing(Employee::calculateAverageSalary));
    }
}
