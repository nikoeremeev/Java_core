package ru.geekbrains.seminar_04;

public class MyArraySizeException extends RuntimeException {
    MyArraySizeException(String msg) {
        super("Array size error.\n" + " " + msg);
    }
}
