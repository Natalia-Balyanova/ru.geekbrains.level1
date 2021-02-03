package ru.geekbrains.lesson7;
public class Main {

    public static void main(String[] args) {

        Cat[] cats = new Cat[3];
        cats[0] = new Cat("Barsik", 5, false);
        cats[1] = new Cat("Murka", 20, false);
        cats[2] = new Cat("Boris", 76, false);

        Plate plate = new Plate(100);
        plate.fillMax();
        plate.info();
        plate.checkFood(cats, plate);
        plate.info();

        plate.increaseFood(50);
        plate.info();

        Plate plate2 = new Plate(80); //создаем новую тарелку и снова корми котов
        plate2.fillMax();
        plate2.info();
        plate2.checkFood(cats, plate2);//и снова кормим голодных котов
        plate2.info();
        plate2.increaseFood(30);
        plate2.info();

        plate2.checkFood(plate2, cats[2]);
        plate2.info();

    }
}
/*
Вывод в консоль:
Plate: 100
Barsik ate and full
Murka ate and full
Boris didn`t eat and cat is hungry. Too little feed! Please add food
Plate: 75
Added food to the plate
Plate: 100
Plate: 80
Barsik ate and full
Murka ate and full
Boris didn`t eat and cat is hungry. Too little feed! Please add food
Plate: 55
Added food to the plate
Plate: 80
Boris ate and full
Plate: 4

Process finished with exit code 0

1. Расширить задачу про котов и тарелки с едой.
2. Сделать так, чтобы в тарелке с едой не могло получиться отрицательного количества еды
(например, в миске 10 еды, а кот пытается покушать 15-20).

3. Каждому коту нужно добавить поле сытость (когда создаем котов, они голодны).
 Если коту удалось покушать (хватило еды), сытость = true.

4. Считаем, что если коту мало еды в тарелке, то он её просто не трогает,
 то есть не может быть наполовину сыт (это сделано для упрощения логики программы).

5. Создать массив котов и тарелку с едой, попросить всех котов покушать из этой тарелки
и потом вывести информацию о сытости котов в консоль.

6. Добавить в тарелку метод, с помощью которого можно было бы добавлять еду в тарелку.

Добавила возможность покормить одного голодного кода, убрала возможность заполнять тарелку
свыше ее объема
 */