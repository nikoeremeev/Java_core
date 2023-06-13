package ru.geekbrains.seminar_03;

public class HourlyEmployee extends Worker {
    private double hourlyRate;

    public HourlyEmployee(String name, double hourlyRate) {
        super(name);
        this.hourlyRate = hourlyRate;
    }

}
