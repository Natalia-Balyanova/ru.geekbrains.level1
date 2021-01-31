package ru.geekbrains.balyanova.lesson6.Animals;

public abstract class Animal {
    public static int animalCount = 0;

    String name;

    public abstract void run(int distanceRun);
    public abstract void swim(int distanceSwim);
    public abstract void voice();

    public Animal(){
        animalCount++;
        System.out.println("Количество животных: " + animalCount);
    }
}