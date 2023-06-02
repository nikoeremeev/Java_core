package ru.geekbrains.seminar_02;

import java.util.Random;
import java.util.Scanner;

public class Program {


    private static final int WIN_COUNT = 4;
    private static final char DOT_HUMAN = 'X';
    private static final char DOT_AI = 'O';
    private static final char DOT_EMPTY = '*';

    private static final Scanner SCANNER = new Scanner(System.in);

    private static char[][] field; // Двумерный массив хранит текущее состояние игрового поля

    private static final Random random = new Random();

    private static int fieldSizeX; // Размерность игрового поля
    private static int fieldSizeY; // Размерность игрового поля


    public static void main(String[] args) {
        while (true) {
            initialize();
            printField();
            while (true) {
                humanTurn();
                printField();
                if (gameCheck(DOT_HUMAN, "You WIN!")) break;
                aiTurn();
                printField();
                if (gameCheck(DOT_AI, "PC WIN!")) break;
            }
            System.out.println("Would you like to play again? (Y - yes)");
            if (!SCANNER.next().equalsIgnoreCase("Y")) break;
        }
    }

    /**
     * Инициализация игрового поля
     */
    private static void initialize() {
        // Установим размерность игрового поля
        fieldSizeX = 5;
        fieldSizeY = 5;


        field = new char[fieldSizeX][fieldSizeY];
        // Пройдем по всем элементам массива
        for (int x = 0; x < fieldSizeX; x++) {
            for (int y = 0; y < fieldSizeY; y++) {
                // Проинициализируем все элементы массива DOT_EMPTY (признак пустого поля)
                field[x][y] = DOT_EMPTY;
            }
        }
    }

    /**
     * Отрисовка игрового поля
     * //TODO: Поправить отрисовку игрового поля
     */
    private static void printField() {
        System.out.print("+");
        for (int i = 0; i < fieldSizeX * 2 + 1; i++) {
            System.out.print((i % 2 == 0) ? "-" : i / 2 + 1);
        }
        System.out.println();

        for (int i = 0; i < fieldSizeX; i++) {
            System.out.print(i + 1 + "|");

            for (int j = 0; j < fieldSizeY; j++)
                System.out.print(field[i][j] + "|");

            System.out.println();
        }

        for (int i = 0; i < fieldSizeX * 2 + 2; i++) {
            System.out.print("-");
        }
        System.out.println();

    }

    /**
     * Обработка хода игрока (человек)
     */
    private static void humanTurn() {
        int x, y;
        do {
            System.out.print("Enter the coordinates of the X and Y stroke (from 1 to 3) separated by a space >>> ");
            x = SCANNER.nextInt() - 1;
            y = SCANNER.nextInt() - 1;
        } while (!isCellValid(x, y) || !isCellEmpty(x, y));
        field[x][y] = DOT_HUMAN;
    }

    /**
     * Проверка, ячейка является пустой
     *
     * @param x
     * @param y
     * @return
     */
    static boolean isCellEmpty(int x, int y) {
        return field[x][y] == DOT_EMPTY;
    }

    /**
     * Проверка корректности ввода
     * (координаты хода не должны превышать размерность массива, игрового поля)
     *
     * @param x
     * @param y
     * @return
     */
    static boolean isCellValid(int x, int y) {
        return x >= 0 && x < fieldSizeX && y >= 0 && y < fieldSizeY;
    }

    /**
     * Ход компьютера
     */
    private static void aiTurn() {
        int x, y;
        do {
            x = random.nextInt(fieldSizeX);
            y = random.nextInt(fieldSizeY);
        } while (!isCellEmpty(x, y));
        field[x][y] = DOT_AI;
    }

    /**
     * Проверка победы
     * TODO: Переработать метод в домашнем задании
     *
     * @param sym
     * @return
     */
    static boolean checkWin(char sym) {
        int count_horizontal = 1;
        int count_vertical = 1;
        int count_main = 1;
        int count_reverse = 1;
        for (int i = 0; i < fieldSizeX; i++) {
            for (int j = 0; j < fieldSizeY; j++) {
                // проверка по горизонтали
                if (j > 1) {
                    if (field[i][j] == field[i][j - 1] && field[i][j] == sym) {
                        count_horizontal++;
                        if (count_horizontal == WIN_COUNT) {
                            return true;
                        }
                    } else {
                        count_horizontal = 1;
                    }
                }
                // проверка по диагонали
                if (i == j && i > 0) {
                    if (i == j && field[i][j] == field[i - 1][j - 1] && field[i][j] == sym) {
                        count_main++;
                        if (count_main == WIN_COUNT) {
                            return true;
                        }
                    } else {
                        count_main = 1;
                    }
                }
                // проверка по обратной диагонали
                if (i == j && i > 0) {
                    if (field[i][fieldSizeY - j] == field[i - 1][fieldSizeY - j - 1] && field[i][fieldSizeY - j - 1] == sym) {
                        count_reverse++;
                        if (count_reverse == WIN_COUNT) {
                            return true;
                        }
                    } else {
                        count_reverse = 1;
                    }
                }

                // проверка по вертикали
                for (int k = 1; k < fieldSizeX; k++) {
                    if (field[k][j] == field[k - 1][j] && field[k][j] == sym) {
                        count_vertical++;
                        if (count_vertical == WIN_COUNT) {
                            return true;
                        }
                    } else {
                        count_vertical = 1;
                    }

                }
            }
        }


        return false;
    }

    /**
     * Проверка на ничью
     *
     * @return
     */
    static boolean checkDraw() {
        for (int x = 0; x < fieldSizeX; x++) {
            for (int y = 0; y < fieldSizeY; y++)
                if (isCellEmpty(x, y)) return false;
        }
        return true;
    }

    /**
     * Метод проверки состояния игры
     *
     * @param c
     * @param str
     * @return
     */
    static boolean gameCheck(char c, String str) {
        if (checkWin(c)) {
            System.out.println(str);
            return true;
        }
        if (checkDraw()) {
            System.out.println("DRAW!");
            return true;
        }

        return false; // Игра продолжается
    }

}
