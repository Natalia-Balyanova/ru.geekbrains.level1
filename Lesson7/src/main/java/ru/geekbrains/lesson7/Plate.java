package ru.geekbrains.lesson7;

public class Plate {
    private int food;
    private int capacity;

    public int getFood() {
        return food;
    }

    public void fillMax() {
        food = capacity;
    }

    public Plate(int capacity) {
        this.capacity = capacity;
    }

    public void decreaseFood(int amount) { //убираем еду из тарелки(ест)
        food -= amount;
    }

    public void increaseFood(int plusFood) { //добавляем еду
        food += plusFood;
        if (food > capacity) {
            food = capacity;//чтобы нельзя было добавить в тарелку еды больше, чем ее вместимость
            System.out.println("Added food to the plate");
        }
    }

    public void info() {
        System.out.println("Plate: " + food);
    }

    public void checkFood(Cat[] cats, Plate p) {
        for (int i = 0; i < cats.length; i++) {
            if (cats[i].appetite <= p.food) { /*cats[i].fullness == false после кормежки коты больше не голодные,
            поэтому убираю параметр для повторной кормежки
            */
                cats[i].eat(p);
                cats[i].fullness = true;
                System.out.println(cats[i].name + " ate and full");
            } else {
                System.out.println(cats[i].name + " didn`t eat and cat is hungry. " +
                        "Too little feed! Please add food");
            }
        }
    }

    public void checkFood(Plate p, Cat cats) { //кормим одного голодного кота из массива
        if (cats.appetite <= p.food) {
            cats.eat(p);
            cats.fullness = true;
            System.out.println(cats.name + " ate and full");
        } else {
            System.out.println(cats.name + " didn`t eat and cat is hungry. " +
                    "Too little feed! Please add food");
        }
    }
}
