package ru.geekbrains.balyanova.lesson5;
//решение доп странных самовыдуманных задач

public class ViewerMain {
    public static void main(String[] args) {

        Viewer[] viewersArray = new Viewer[5];

        viewersArray[0] = new Viewer(15);
        viewersArray[1] = new Viewer(16, true);
        viewersArray[2] = new Viewer(21);
        viewersArray[3] = new Viewer(12);
        viewersArray[4] = new Viewer(30);

        System.out.println("Вы покупаете билет в кино с рейтингом 18+");
        for(Viewer item : viewersArray) {
            if (item.getAge() >= 18 || item.getWithAdult()) {item.faceControlYes(); item.popCorn();}
            else {
                item.faceControlNo();
            }
        }
    }
}
/*создала класс зритель. По условию, если зрителю 18+ или с ним взрослый,
сообщить, что он может купить билет. Если зритель без сопровождения, то
сообщить, что он не может купить билет.
Если faceControlYes ->> предложить попкорн покупателю
 */