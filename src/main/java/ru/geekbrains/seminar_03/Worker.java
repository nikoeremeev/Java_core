package ru.geekbrains.seminar_03;

public abstract class Worker {
    protected String name;

    public Worker(String name) {
        this.name = name;
    }

    /**
     * Abstract method of calculating the average monthly salary
     */
    public abstract double calculateAverageSalary();


    public String getName() {
        return name;
    }


}
