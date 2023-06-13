package ru.geekbrains.seminar_03;

public abstract class Worker {
    protected String name;

    public Worker(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
