package ru.geekbrains.seminar_04;

public class MyArrayDataException extends RuntimeException {
    MyArrayDataException(String msg) {
        super("Error converting an array element to an integer.\n" + " " + msg);
    }
}
