package ru.geekbrains.balyanova.lesson3HW;

import java.util.Random;
import java.util.Scanner;

public class ArrayOfWords {
    public static void main(String[] args) {
        startGuessWord();

    }
    public static void startGuessWord() {
        String[] words =   {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry",
                "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear",
                "pepper", "pineapple", "pumpkin", "potato"};
        System.out.println("The computer gave you one of these words:" +
                "\napple, orange, lemon, banana, apricot, avocado, " +
                "\nbroccoli, carrot, cherry, garlic, grape, melon, leak, " +
                "\nkiwi, mango, mushroom, nut, olive, pea, peanut, pear, " +
                "\npepper, pineapple, pumpkin, potato. " +
                "\nGuess what word the computer was guessing. Use only lowercase letters:");

        Random random = new Random();
        int index = random.nextInt(words.length);

        String randWord = words[index];
        String guessWord;

        do{
            Scanner scanner = new Scanner(System.in);
            guessWord = scanner.nextLine();
            if(guessWord.equals(randWord)) {
                System.out.println("Congratulations!");
                System.out.println("This is: " + randWord + " \nYou win!");
                break;
            }
            String str = "";
            for (int i = 0; i < guessWord.length(); i++) {
                if (i < randWord.length() && guessWord.charAt(i) == randWord.charAt(i)) {
                    str += guessWord.charAt(i);
                } else {
                    str += "#";
                }
            }
                str += "###############";
            System.out.println(str);
        }while (true);
    }
}
