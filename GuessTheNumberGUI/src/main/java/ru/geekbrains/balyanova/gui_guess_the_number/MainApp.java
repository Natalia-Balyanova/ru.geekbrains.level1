package ru.geekbrains.balyanova.gui_guess_the_number;

import javax.swing.*;

public class MainApp extends JFrame {
    private GuessingGame theGame;

    public MainApp() {
        GuessingGame theGame = new GuessingGame();
        theGame.newGame();
        theGame.setBounds(500, 300, 378, 400);
        theGame.setVisible(true);
    }

    public static void main(String[] args) {
        new MainApp();
    }
}
