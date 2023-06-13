package ru.geekbrains.seminar_03;

public class Main {
    public static void main(String[] args) {
        Employee[] employees = new Employee[4];
        employees[0] = new HourlyEmployee("Ronaldinho", 1000);
        employees[1] = new HourlyEmployee("Ronaldo", 1200);
        employees[2] = new SalariedEmployee("Messi", 220000);
        employees[3] = new SalariedEmployee("Mbappe", 190000);

        EmployeesArray employeesArray = new EmployeesArray(employees);

        employeesArray.sortByName();

        System.out.println();
        System.out.println("-----------------------------------------");
        System.out.println("List of employees after sorting by name:");
        employeesArray.printEmployeesInfo();

        employeesArray.sortByAverageSalary();

        System.out.println();
        System.out.println("-----------------------------------------");
        System.out.println("List of employees after sorting by salary:");
        employeesArray.printEmployeesInfo();
    }
}
