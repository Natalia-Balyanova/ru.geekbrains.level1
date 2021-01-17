package ru.geekbrains.balyanova.lesson2HW;

import java.util.Arrays;

public class Lesson2HW {
    public static void main(String[] args) {

        invertArray();
        fillArray();
        changeArray();
        fillDiagonal();
        minMax();
        //6.
        int[] mes = {2, 2, 2, 1, 2, 2, 10, 1};
        System.out.println(checkBalance(mes));
        //7.
        int[] myArray = {1, 2, 3, 4, 5, 6};
        cicleMoveArray(myArray, 3);

    }

    //1. Задать целочисленный массив, состоящий из элементов 0 и 1. Например:
    //[ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. С помощью цикла и условия заменить 0 на 1, 1 на 0;
    public static void invertArray() {
        System.out.println("Task1");
        int[] array = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                array[i] = 1;
            } else array[i] = 0;
        } System.out.print(Arrays.toString(array));
    }

    //2. Задать пустой целочисленный массив размером 8. С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;
    public static void fillArray() {
        System.out.println("\nTask2");
        int[] arr = new int[8];
        for (int i = 0, j = 0; i < arr.length; i++, j += 3) {
            arr[i] = j;
            System.out.print(arr[i] + " ");
        }
    }

    //3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;
    public static void changeArray() {
        System.out.println("\nTask3");
        int[] myArr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < myArr.length; i++) {
            if (myArr[i] < 6)
                myArr[i] *= 2;
            System.out.print(myArr[i] + " ");
        }
    }

    //4.  Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое)
    //и с помощью цикла(-ов) заполнить его диагональные элементы единицами;
    public static void fillDiagonal() {
        System.out.println("\nTask4");
        int[][] dia = new int[5][5]; //any identical values
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                dia[i][i] = 1;
                dia[i][5 - i - 1] = 1;
                System.out.print(dia[i][j] + " ");
            }
            System.out.println(); // +отступ
        }
    }

    //5. ** Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета)
    public static void minMax() {
        System.out.println("\nTask5");
        int[] elem = {1, 67, -1, -10, 4, 44, -50};
        int min, max;
        min = max = elem[0];
        for (int i = 1; i < 7; i++) {
            if (elem[i] < min)
                min = elem[i];
            if (elem[i] > max)
                max = elem[i];
        }
        System.out.println("Element with min value: " + min + "\n" + "Element with max value: " + max);
    }

    //6. ** Написать метод, в который передается не пустой одномерный целочисленный массив, метод должен вернуть true,
    //если в массиве есть место, в котором сумма левой и правой части массива равны. Примеры:
    //checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true, checkBalance([1, 1, 1, || 2, 1]) → true,
    //граница показана символами ||, эти символы в массив не входят.
    public static boolean checkBalance(int[] mes) {
        System.out.println("\nTask6");
        int leftSum, rightSum;
        for (int i = 0; i < mes.length; i++) {
            leftSum = 0;
            rightSum = 0;

            for (int j = 0; j < i; j++) {
                leftSum += mes[j];
            }
            for (int j = i; j < mes.length; j++) {
                rightSum += mes[j];
            }
            if (leftSum == rightSum) {
                return true;
            }
        }
        return false;
    }

    //7. **** Написать метод, которому на вход подается одномерный массив и число n (может быть положительным,
    // или отрицательным), при этом метод должен сместить все элементы массива на n позиций.
    // Элементы смещаются циклично. Для усложнения задачи нельзя пользоваться вспомогательными массивами.
    //Примеры: [ 1, 2, 3 ] при n = 1 (на один вправо) -> [ 3, 1, 2 ]; [ 3, 5, 6, 1] при n = -2 (на два влево) ->

    static void cicleMoveArray(int[] myArray, int n) {
        System.out.println("\nTask7");
        System.out.print("Before: " + Arrays.toString(myArray));
        if (n > 0) { //if n = positive myArray goes to RIGHT
            for (int i = 0; i < n; i++) {
                int t = myArray[myArray.length - 1]; // temporary var
                for (int j = myArray.length - 1; j > 0; j--) {
                    myArray[j] = myArray[j - 1];
                }
                myArray[0] = t;
            }
        } else if (n < 0) { // if n = negative myArray goes to LEFT
            for (int i = 0; i < n * (-1); i++) {
                int t = myArray[0];
                for (int j = 0; j < myArray.length - 1; j++) {
                    myArray[j] = myArray[j + 1];
                }
                myArray[myArray.length - 1] = t;
            }
        }
        System.out.println(); // +отступ
        System.out.println("After:  " + Arrays.toString(myArray));
        }
    }