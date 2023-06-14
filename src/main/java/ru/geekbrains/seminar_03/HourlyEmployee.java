package ru.geekbrains.seminar_03;

public class HourlyEmployee extends Employee {
    private double hourlyRate;

    public HourlyEmployee(String name, double hourlyRate) {
        super(name);
        this.hourlyRate = hourlyRate;
    }


    @Override
    public double calculateAverageSalary() {
        return 20.8 * 8 * hourlyRate;
    }
}
