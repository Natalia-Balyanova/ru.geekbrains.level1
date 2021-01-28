package ru.geekbrains.balyanova.lesson5;

public class Employee {
    private String name;
    private String position;
    private String email;
    private long phone;
    private int salary;
    private int age;

    public Employee(String name, String position, String email, long phone, int salary, int age){
        this.name = name;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;

    }
    int getAge(){
        return age;
    }

    public void print(){
        System.out.println(name + " " + position + " " + email + " " + phone + " " + salary + " " + age);
    }



}
