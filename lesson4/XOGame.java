package ru.geekbrains.balyanova.lesson4;

import java.util.Random;
import java.util.Scanner;

public class XOGame {
    static char[][] map;
    static final int SIZE = 5;
    static final char DOT_PLAYER = 'X';
    static final char DOT_AI = 'O';
    static final char DOT_IS_EMPTY = '*';
    static final int DOT_TO_WIN = 4;

    static Scanner sc = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) {
        prepareMap();
        printMap();

        while (true) {
            playerTurn();
            printMap();
            if (checkWin(DOT_PLAYER)) {
                System.out.println("YOU WIN!");
                break;
            }
            if (isMapFull()) {
                System.out.println("  DRAW");
                break;
            }

            aiTurn();
            printMap();
            if (checkWin(DOT_AI)) {
                System.out.println("AI WON ((");
                break;
            }
            if (isMapFull()) {
                System.out.println("  DRAW");
                break;
            }
        }
        System.out.println("GAME OVER");
    }

    public static void prepareMap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_IS_EMPTY;
            }
        }
    }

    public static void printMap() {
        System.out.print("  ");
        for (int i = 1; i <= SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print((i + 1 + " "));
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[j][i] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void playerTurn() {
        int x, y;
        do {
            System.out.println("Enter coordinates: 'x y'");
            x = sc.nextInt() - 1; //отнимаем в соответствии с эл-тами массива
            y = sc.nextInt() - 1;
        } while (!isCellEmpty(x, y));
        map[x][y] = DOT_PLAYER;
    }

    public static boolean isCellEmpty(int x, int y) {
        if (x < 0 || y < 0 || x >= SIZE || y >= SIZE)
            return false;
        if (map[x][y] == DOT_IS_EMPTY) {
            return true;
        }
        return false;
    }

    public static void aiTurn() { //4. *** Доработать ИИ, чтобы он мог блокировать ходы игрока.
        for (int i = 0; i < SIZE; i++)
            for (int j = 0; j < SIZE; j++) {
                if (isCellEmpty(i, j)) {
                    map[i][j] = DOT_AI;
                    if (checkWin(DOT_AI)) return;
                    map[i][j] = DOT_IS_EMPTY;
                }
            }
        for (int i = 0; i < SIZE; i++)
            for (int j = 0; j < SIZE; j++) {
                if (isCellEmpty(i, j)) {
                    map[i][j] = DOT_PLAYER;
                    if (checkWin(DOT_PLAYER)) {
                        map[i][j] = DOT_AI;
                        return;
                    }
                    map[i][j] = DOT_IS_EMPTY;
                }
            }
        int x, y;
        do {
            x = random.nextInt(SIZE);
            y = random.nextInt(SIZE);
        } while (!isCellEmpty(x, y));
        map[x][y] = DOT_AI;
        System.out.printf("Ход ИИ: [%d / %d]\n", x + 1, y + 1);
    }

    public static boolean isMapFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_IS_EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean checkWin(char dot) {   // пока не получается решить задачу для второстепенных диагоналей. код тяжелый, и наверное, нужен еще один метод...
        int hor, vert, dia1, dia2;
        for (int i = 0; i < SIZE; i++) {
            hor = 0;
            vert = 0;
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == dot) {
                    hor++; //горизонтальные
                }
                if (map[j][i] == dot) {
                    vert++; //вертикальные
                }
            }
            if (hor >= DOT_TO_WIN || vert >= DOT_TO_WIN) {
                return true;
            }
        }
        dia1 = 0;
        dia2 = 0; 
        for (int i = 0; i < SIZE; i++) {
            if (map[i][i] == dot) {
                dia1++; //диагональ слева направо
            }
            if (map[i][SIZE - i - 1] == dot) {
                dia2++; //диагональ справа налево
            }
        }
        if (dia1 >= DOT_TO_WIN || dia2 >= DOT_TO_WIN) {
            return true;
        }
        return false;
    }
}

/*1. Полностью разобраться с кодом, попробовать переписать с нуля, стараясь не подглядывать в методичку.
  2. Переделать проверку победы, чтобы она не была реализована просто набором условий, например, с использованием циклов.
  3. * Попробовать переписать логику проверки победы, чтобы она работала для поля 5х5 и количества фишек 4.
  Очень желательно не делать это просто набором условий для каждой из возможных ситуаций;
  4. *** Доработать искусственный интеллект, чтобы он мог блокировать ходы игрока.
*/