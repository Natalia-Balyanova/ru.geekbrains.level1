import ru.geekbrains.balyanova.lesson6.Animals.Animal;
import ru.geekbrains.balyanova.lesson6.Animals.Cat;
import ru.geekbrains.balyanova.lesson6.Animals.Dog;

public class MainApp {
    static int count = 0;

    public static void main(String[] args) {

        Cat cat = new Cat("Barsik");
        count++;
        cat.run(150);
        cat.swim(2);
        cat.voice();

        System.out.println("Общее количество котов: " + count);

        Dog dog = new Dog("Bobik");
        count++;
        dog.swim(2);
        dog.voice();
        dog.run(200);
        Dog dog2 = new Dog("Sharik");
        dog2.run(600);
        dog2.swim(10);

        System.out.println("Общее количество собак: " + count);

    }
}
/*
Вывод в консоль:
Количество животных: 1
Barsik пробежал 150 м.
Barsik мяу
Общее количество котов: 1
Количество животных: 2
Bobik проплыл 2 м.
Bobik гав!
Bobik пробежал 200 м.
Количество животных: 3
Sharik проплыл 10 м.
Общее количество собак: 2

Process finished with exit code 0

1. Создать классы Собака и Кот с наследованием от класса Животное.

2. Все животные могут бежать и плыть. В качестве параметра каждому методу передается длина препятствия.
Результатом выполнения действия будет печать в консоль.
(Например, dogBobik.run(150); -> 'Бобик пробежал 150 м.');

3. У каждого животного есть ограничения на действия (бег: кот 200 м., собака 500 м.; плавание: кот не умеет плавать,
 собака 10 м.).

4. * Добавить подсчет созданных котов, собак и животных.
 */