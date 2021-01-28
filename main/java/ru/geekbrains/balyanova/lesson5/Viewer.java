package ru.geekbrains.balyanova.lesson5;

public class Viewer {
    private int age;

    private boolean withAdult;

    public Viewer(int age, boolean withAdult){
        this.age = age;
        this.withAdult = true;
    }
    public Viewer(int age){
        this.age = age;
    }
    int getAge(){
        return age;
    }
    boolean getWithAdult() {
        return withAdult;
    }

    public void faceControlYes(){
        System.out.println("Вы можете купить билет, т.к. вы совершеннолетний или с вами взрослый");
    }
    public void faceControlNo(){
        System.out.println("Вы не можете купить билет. Вам еще только " + age);
    }

    public void popCorn(){
        System.out.println("Вы так же можете купить снеки на выбор");

    }

}
