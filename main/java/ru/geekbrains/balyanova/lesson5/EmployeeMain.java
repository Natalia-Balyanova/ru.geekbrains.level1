package ru.geekbrains.balyanova.lesson5;

public class EmployeeMain {
    public static void main(String[] args) {
        Employee[] empArray = new Employee[5];

        empArray[0] = new Employee("Ivanov Ivan", "Director", "ivanovdirector@mail.ru", 89991234567L, 200000, 50);
        empArray[1] = new Employee("Petrov Egor", "Lead Engineer", "petrovengineerlead@yandex.ru", 89096544017L, 120000, 41);
        empArray[2] = new Employee("Vasil`ev Vasiliy", "Engineer", "vasvas@mail.ru", 89056372891L, 100000, 30);
        empArray[3] = new Employee("Smirnov Alexandr", "Junior Engineer", "smirnovalex@gmail.com", 89881032345L, 30000, 22);
        empArray[4] = new Employee("Alexeev Denis", "Design", "alexeevdenis@gmail.com", 89063423231L, 70000, 35);

//        for (int i = 0; i < empArray.length; i++) {
//            if (empArray[i].getAge() > 40) {
//                empArray[i].print();
//            }
                for(Employee item : empArray) {
                    if(item.getAge() > 40) item.print();
            }
        }
    }

/*
1. Создать класс "Сотрудник" с полями: ФИО, должность, email, телефон, зарплата, возраст.
2. Конструктор класса должен заполнять эти поля при создании объекта.
3. Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль.
4. Создать массив из 5 сотрудников.
Пример:
Person[] persArray = new Person[5]; // Вначале объявляем массив объектов
persArray[0] = new Person("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", "892312312", 30000, 30); // потом для каждой ячейки массива задаем объект
persArray[1] = new Person(...);
...
persArray[4] = new Person(...);

5. С помощью цикла вывести информацию только о сотрудниках старше 40 лет.
 */