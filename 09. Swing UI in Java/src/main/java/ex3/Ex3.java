package ex3;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;


public class Ex3 {
    private JTextField textField1;
    private JPanel Mainscreen;
    private JButton button1;
    private JTextArea textArea1;

    public Ex3() {

        textField1.setText("src/main/resources/ex3text.txt");

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Scanner scanner = null;
                try {
                    scanner = new Scanner(new File(textField1.getText()));
                } catch (FileNotFoundException fileNotFoundException) {
                    fileNotFoundException.printStackTrace();
                }
                String textToDisplay = "";
                    while (scanner.hasNextLine())
                        textToDisplay = textToDisplay + scanner.nextLine();
                    final String displayedText = textToDisplay;
                    textArea1.setText(displayedText);
                }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Ex3");
        frame.setContentPane(new Ex3().Mainscreen);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
