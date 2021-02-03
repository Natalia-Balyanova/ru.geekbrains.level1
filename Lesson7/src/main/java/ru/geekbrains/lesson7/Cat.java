package ru.geekbrains.lesson7;

public class Cat {
    protected String name;
    protected int appetite;
    protected boolean fullness;

    public Cat(String name, int appetite, boolean fullness) {
        this.name = name;
        this.appetite = appetite;
        this.fullness = fullness;
    }

    public int getAppetite() {
        return appetite;
    }

    public void eat(Plate p) {
        p.decreaseFood(appetite);
    }
}
