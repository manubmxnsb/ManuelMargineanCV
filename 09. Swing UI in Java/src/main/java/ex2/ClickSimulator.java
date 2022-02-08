package ex2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClickSimulator {
    private JPanel Mainscreen;
    private JButton button1;
    private JTextField textField1;

    public ClickSimulator() {
        button1.addActionListener(new ActionListener() {
            int clicks = 0;
            @Override
            public void actionPerformed(ActionEvent e) {
                clicks++;
                textField1.setText("Clicks counted : " + clicks);
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("ClickSimulator");
        frame.setContentPane(new ClickSimulator().Mainscreen);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }
}
