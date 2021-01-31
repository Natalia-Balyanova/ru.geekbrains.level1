package ru.geekbrains.balyanova.lesson6.Animals;

public class Cat extends Animal {

    public Cat(String name) {
        this.name = name;
    }

    @Override
    public void swim(int distanceSwim) {
        // System.out.println(name + " не умеет плавать"); //необязательное условие
    }

    @Override
    public void run(int distanceRun) {
        if ((distanceRun <= 200) && (distanceRun >= 0)) {
            System.out.println(name + " пробежал " + distanceRun + " м.");
        }
//         else {
////            System.out.println(name + " не пробежит " + distanceRun + " м.");//вместо false
//        }
    }

    public void voice() {
        System.out.println(name + " мяу");
    }
}
