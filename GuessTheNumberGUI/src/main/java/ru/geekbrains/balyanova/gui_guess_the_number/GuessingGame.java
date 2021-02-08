package ru.geekbrains.balyanova.gui_guess_the_number;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GuessingGame extends JFrame {

    private final JTextField txtGuess;
    private final JLabel lblOutput;
    private int theNumber;
    private int numberOfTries;
    JButton btnPlayAgain;
    JButton btnExit;
    public void checkGuess() {
        String guessText = txtGuess.getText();
        String message = "";

            try {
                int guess = Integer.parseInt(guessText);
                numberOfTries++;
                if (guess < theNumber && numberOfTries <= 3)
                    message = guess + " is too low. Try again.";
                else if (guess > theNumber && numberOfTries <= 3)
                    message = guess + " is too high. Try again.";
                else if (numberOfTries >= 3) { //если превысили количество попыток
                    message = "too high tries";
                    btnPlayAgain.setVisible(true);
                    btnExit.setVisible(true);}
                else if (guess == theNumber && numberOfTries <= 3){
                    message = guess + " is correct. You win after " + numberOfTries + " tries!";
                    btnPlayAgain.setVisible(true);
                    btnExit.setVisible(true);
                }
            } finally {
                lblOutput.setText(message);
                txtGuess.requestFocus();
                txtGuess.selectAll();
            }
        }

    public void newGame() {
        theNumber = (int) (Math.random() * 10);
        numberOfTries = 0;
        lblOutput.setVisible(true);
        btnPlayAgain.setVisible(false);
        btnExit.setVisible(false);
    }
    public GuessingGame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Guess The Number Game");
        getContentPane().setLayout(null);

        JLabel lblNataliHiLo = new JLabel("Let`s play the Guessing Game");
        lblNataliHiLo.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblNataliHiLo.setHorizontalAlignment(SwingConstants.CENTER);
        lblNataliHiLo.setBounds(20, 43, 330, 32);
        getContentPane().add(lblNataliHiLo);

        JLabel lblGuessANumber = new JLabel("Guess the number from 0 to 9 for 3 tries");
        lblGuessANumber.setHorizontalAlignment(SwingConstants.RIGHT);
        lblGuessANumber.setBounds(30, 102, 234, 32);
        getContentPane().add(lblGuessANumber);
        lblGuessANumber.setFont(new Font("Tahoma", Font.PLAIN, 13));

        txtGuess = new JTextField();
        txtGuess.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                checkGuess();
            }
        });
        txtGuess.setBounds(280, 102, 55, 32);
        getContentPane().add(txtGuess);
        txtGuess.setColumns(10);

        txtGuess.setFont(new Font("Tahoma", Font.PLAIN, 13));
        txtGuess.setHorizontalAlignment(SwingConstants.RIGHT);

        JButton btnGuess = new JButton("Guess!");
        btnGuess.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                checkGuess();
            }
        });
        btnGuess.setBounds(140, 159, 89, 23);
        getContentPane().add(btnGuess);

        lblOutput = new JLabel("Enter a number and click Guess!");
        lblOutput.setHorizontalAlignment(SwingConstants.CENTER);
        lblOutput.setBounds(-10, 200, 400, 23);
        getContentPane().add(lblOutput);


        lblOutput.setFont(new Font("Tahoma", Font.PLAIN, 13));

        btnExit = new JButton("Exit");
        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        btnExit.setFont(new Font("Tahoma", Font.PLAIN, 13));
        btnExit.setBounds(200, 250, 115, 23);
        getContentPane().add(btnExit);

        btnPlayAgain = new JButton("Play Again!");
        btnPlayAgain.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                newGame();
            }
        });
        btnPlayAgain.setFont(new Font("Tahoma", Font.PLAIN, 13));
        btnPlayAgain.setBounds(50, 250, 115, 23);
        getContentPane().add(btnPlayAgain);
    }
}

