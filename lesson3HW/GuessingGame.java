package ru.geekbrains.balyanova.lesson3HW;

import java.util.Scanner;

public class GuessingGame {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        do {
            int number = (int) (Math.random() * 10);
            System.out.println("Угадайте число от 0 до 9 за 3 попытки");
            for (int i = 0; i < 3; i++) {
                System.out.println("Ваша попытка № " + (i + 1 + ":"));
                int guess = scanner.nextInt();
                if (guess == number) {
                    System.out.println("Вы угадали! Это " + guess);
                    break;
                }
                if (guess < number) System.out.println("Введенное число больше");
                if (guess > number) System.out.println("Введенное число меньше");
            }
            System.out.println("Повторить игру еще раз?\n1 – да / 0 – нет");
        }
        while (scanner.nextInt() == 1);
        System.out.println("Вы вышли из игры");
    }
}


/*
1. Написать программу, которая загадывает случайное число от 0 до 9 и пользователю дается 3 попытки угадать это число.
 При каждой попытке компьютер должен сообщить, больше ли указанное пользователем число, чем загаданное, или меньше.
  После победы или проигрыша выводится запрос – «Повторить игру еще раз? 1 – да / 0 – нет»(1 – повторить, 0 – нет).
 */