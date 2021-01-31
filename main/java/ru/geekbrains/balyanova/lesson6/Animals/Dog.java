package ru.geekbrains.balyanova.lesson6.Animals;

public class Dog extends Animal{

    public Dog(String name){
        this.name = name;
    }

    public void voice(){
        System.out.println(name + " гав!");
    }

    public void swim(int distanceSwim) {
        if ((distanceSwim <= 10) && (distanceSwim >= 0)) {
            System.out.println(name + " проплыл " + distanceSwim + " м.");}
    }

    public void run(int distanceRun){
        if((distanceRun <= 500) && (distanceRun >= 0)){
            System.out.println(name + " пробежал " + distanceRun + " м.");}
//        else{
//            System.out.println(name + " не пробежит " + distanceRun + " м.");} //вместо false
    }
}
