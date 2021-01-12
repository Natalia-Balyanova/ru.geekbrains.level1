package ru.geekbrains.lesson1hw;

public class HomeWorkLesson1 {
    public static void main(String[] args) {
        //1. Создать пустой проект в IntelliJ IDEA и прописать метод main().

        //2. Создать переменные всех пройденных типов данных и инициализировать их значения.

        byte bt = 2;
        short sh = 8;
        int i = 10;
        long l = 35;

        float a = 12.123f;
        double g = 708.00614;

        char h = 'h';

        boolean isYes = true;

        //3.
        float b = 434f;
        float c = 450.67f;
        float d = 90f;
        System.out.println(thirdTask(a, b, c, d));
        //4.
        System.out.println(sumTenToTwenty(sh, i));
        //5.
        checkNumber(i);
        //6.
        System.out.println(positiveOrNegative(i));
        //7.
        String name = "Наташа";
        hi(name);
        //8.
        int year = 2021;
        year(year);

    }

    //3. Написать метод вычисляющий выражение a * (b + (c / d)) и возвращающий
    // результат, где a, b, c, d – аргументы этого метода, имеющие тип float.

    public static float thirdTask(float a, float b, float c, float d) {
        return a * (b + (c / d));
    }

    //4. Написать метод, принимающий на вход два целых числа и проверяющий, что их сумма
    // лежит в пределах от 10 до 20 (включительно), если да – вернуть true, в противном случае – false.

    public static boolean sumTenToTwenty(short sh, int i) {
        int sum = sh + i;
        {
            return sum >= 10 && sum <= 20;
        }
    }

    //5. Написать метод, которому в качестве параметра передается целое число, метод должен напечатать в консоль,
    // положительное ли число передали или отрицательное. Замечание: ноль считаем положительным числом.

    public static void checkNumber(int i) {
        if (i >= 0) {
            System.out.println("Вы передали положительное число");
        } else {
            System.out.println("Вы передали отрицательное число");
        }
    }

    //6. Написать метод, которому в качестве параметра передается целое число. Метод должен вернуть true,
    // если число отрицательное, и вернуть false если положительное.

    public static boolean positiveOrNegative(int i) {

        return i < 0;
    }

    //7. Написать метод, которому в качестве параметра передается строка, обозначающая имя.
    // Метод должен вывести в консоль сообщение «Привет, указанное_имя!».

    public static void hi(String name) {

        System.out.println("Привет, " + name + "!");
    }

    //8 *Написать метод, который определяет, является ли год високосным, и выводит сообщение в консоль.
    // Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.

    public static void year(int year) {
        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
            System.out.println("Этот год високосный");
        } else {
            System.out.println("Этот год невисокосный");
        }
    }
}


