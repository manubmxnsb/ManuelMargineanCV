package ex4;

import javax.swing.*;
import java.awt.event.*;

public class Ex4 extends JFrame implements ActionListener {
    private JPanel Mainscreen;
    private JTextField winnerText;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JButton button7;
    private JButton button8;
    private JButton button9;
    private JButton resetButton;
    private JTextField whosTurn;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    static int playersTurn = 0;
    static boolean winner = false;
    static int xScore = 0;
    static int yScore = 0;

    public Ex4() {
        setTitle("TicTacToe");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        whosTurn.setText("Player 1's turn");
        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);
        button4.addActionListener(this);
        button5.addActionListener(this);
        button6.addActionListener(this);
        button7.addActionListener(this);
        button8.addActionListener(this);
        button9.addActionListener(this);
        resetButton.addActionListener(this);
        whosTurn.addActionListener(this);
        winnerText.addActionListener(this);
        textField3.setText(" TicTacToe ");
        textField1.setText(" X score : " + xScore);
        textField2.setText(" 0 score : " + yScore);
    }

    public void actionPerformed(ActionEvent e) {
        boolean[] clickedButtons = new boolean[9];
        if (!winner) {
            if (playersTurn % 2 == 0) {
                whosTurn.setText("Player 1's turn");
            } else {
                whosTurn.setText("Player 2's turn");
            }
            if (button1 == e.getSource()) {
                if ((playersTurn % 2 == 0) && (!clickedButtons[0])) {
                    button1.setText("X");
                } else {
                    button1.setText("0");
                }
                clickedButtons[0] = true;
                playersTurn++;
            } else if (button2 == e.getSource()) {
                if ((playersTurn % 2 == 0) && (!clickedButtons[1])) {
                    button2.setText("X");
                } else {
                    button2.setText("0");
                }
                clickedButtons[1] = true;
                playersTurn++;
            } else if (button3 == e.getSource()) {
                if ((playersTurn % 2 == 0) && (!clickedButtons[2])) {
                    button3.setText("X");
                } else {
                    button3.setText("0");
                }
                clickedButtons[2] = true;
                playersTurn++;
            } else if (button4 == e.getSource()) {
                if ((playersTurn % 2 == 0) && (!clickedButtons[3])) {
                    button4.setText("X");
                } else {
                    button4.setText("0");
                }
                clickedButtons[3] = true;
                playersTurn++;
            } else if (button5 == e.getSource()) {
                if ((playersTurn % 2 == 0) && (!clickedButtons[4])) {
                    button5.setText("X");
                } else {
                    button5.setText("0");
                }
                clickedButtons[4] = true;
                playersTurn++;
            } else if (button6 == e.getSource()) {
                if ((playersTurn % 2 == 0) && (!clickedButtons[5])) {
                    button6.setText("X");
                } else {
                    button6.setText("0");
                }
                clickedButtons[5] = true;
                playersTurn++;
            } else if (button7 == e.getSource()) {
                if ((playersTurn % 2 == 0) && (!clickedButtons[6])) {
                    button7.setText("X");
                } else {
                    button7.setText("0");
                }
                clickedButtons[6] = true;
                playersTurn++;
            } else if (button8 == e.getSource()) {
                if ((playersTurn % 2 == 0) && (!clickedButtons[7])) {
                    button8.setText("X");
                } else {
                    button8.setText("0");
                }
                clickedButtons[7] = true;
                playersTurn++;
            } else if (button9 == e.getSource()) {
                if ((playersTurn % 2 == 0) && (!clickedButtons[8])) {
                    button9.setText("X");
                } else {
                    button9.setText("0");
                }
                clickedButtons[8] = true;
                playersTurn++;
            }
        }
        if (resetButton == e.getSource()) {
            button1.setText("Button");
            button2.setText("Button");
            button3.setText("Button");
            button4.setText("Button");
            button5.setText("Button");
            button6.setText("Button");
            button7.setText("Button");
            button8.setText("Button");
            button9.setText("Button");
            playersTurn = 0;
            winnerText.setText(" ");
            winner = false;
        }
        //winning condition rand 1
        if (!winner) {
            if (((button1.getText().equals(button2.getText())) && (button2.getText().equals(button3.getText())))) {
                if (button1.getText().equals("X")) {
                    winnerText.setText("X wins!");
                    winner = true;
                    xScore++;
                    textField1.setText(" X score : " + xScore);
                } else if (button1.getText().equals("0")) {
                    winnerText.setText("0 wins!");
                    winner = true;
                    yScore++;
                    textField2.setText(" 0 score : " + yScore);
                }
            }
            //winning condition rand 2
            if (((button4.getText().equals(button5.getText())) && (button5.getText().equals(button6.getText())))) {
                if (button4.getText().equals("X")) {
                    winnerText.setText("X wins!");
                    winner = true;
                    xScore++;
                    textField1.setText(" X score : " + xScore);
                } else if (button4.getText().equals("0")) {
                    winnerText.setText("0 wins!");
                    winner = true;
                    yScore++;
                    textField2.setText(" 0 score : " + yScore);
                }
            }
            //winning condition rand 3
            if (((button7.getText().equals(button8.getText())) && (button8.getText().equals(button9.getText())))) {
                if (button7.getText().equals("X")) {
                    winnerText.setText("X wins!");
                    winner = true;
                    xScore++;
                    textField1.setText(" X score : " + xScore);
                } else if (button7.getText().equals("0")) {
                    winnerText.setText("0 wins!");
                    winner = true;
                    yScore++;
                    textField2.setText(" 0 score : " + yScore);
                }
            }
            //winning condition diagonala 1
            if (((button1.getText().equals(button5.getText())) && (button5.getText().equals(button9.getText())))) {
                if (button1.getText().equals("X")) {
                    winnerText.setText("X wins!");
                    winner = true;
                    xScore++;
                    textField1.setText(" X score : " + xScore);
                } else if (button1.getText().equals("0")) {
                    winnerText.setText("0 wins!");
                    winner = true;
                    yScore++;
                    textField2.setText(" 0 score : " + yScore);
                }
            }
            //winning condition diagonala 2
            if (((button3.getText().equals(button5.getText())) && (button5.getText().equals(button7.getText())))) {
                if (button3.getText() == "X") {
                    winnerText.setText("X wins!");
                    winner = true;
                    xScore++;
                    textField1.setText(" X score : " + xScore);
                } else if (button3.getText().equals("0")) {
                    winnerText.setText("0 wins!");
                    winner = true;
                    yScore++;
                    textField2.setText(" 0 score : " + yScore);
                }
            }
            //winning condition coloana 1
            if (((button1.getText().equals(button4.getText())) && (button4.getText().equals(button7.getText())))) {
                if (button1.getText() == "X") {
                    winnerText.setText("X wins!");
                    winner = true;
                    xScore++;
                    textField1.setText(" X score : " + xScore);
                } else if (button1.getText().equals("0")) {
                    winnerText.setText("0 wins!");
                    winner = true;
                    yScore++;
                    textField2.setText(" 0 score : " + yScore);
                }
            }
            //winning condition coloana 2
            if (((button2.getText().equals(button5.getText())) && (button5.getText().equals(button8.getText())))) {
                if (button2.getText() == "X") {
                    winnerText.setText("X wins!");
                    winner = true;
                    xScore++;
                    textField1.setText(" X score : " + xScore);
                } else if (button2.getText().equals("0")) {
                    winnerText.setText("0 wins!");
                    winner = true;
                    yScore++;
                    textField2.setText(" 0 score : " + yScore);
                }
            }
            //winning condition coloana 3
            if (((button3.getText().equals(button6.getText())) && (button6.getText().equals(button9.getText())))) {
                if (button3.getText() == "X") {
                    winnerText.setText("X wins!");
                    winner = true;
                    xScore++;
                    textField1.setText(" X score : " + xScore);
                } else if (button3.getText().equals("0")) {
                    winnerText.setText("O wins!");
                    winner = true;
                    yScore++;
                    textField2.setText(" 0 score : " + yScore);
                }
            }
        }

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Ex4");
        frame.setContentPane(new Ex4().Mainscreen);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}

