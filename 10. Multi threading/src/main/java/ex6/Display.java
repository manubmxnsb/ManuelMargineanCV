package ex6;

import ex4.SetterThread;
import ex4.VerifyThread;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Display extends JFrame implements ActionListener {
    private JButton startButton;
    private JButton stopButton;
    private JTextField textField1;
    private JTextField textField2;
    private JPanel MyDisplay;
    private static Chronometer chronometer = new Chronometer(System.currentTimeMillis());

    public Display() {
        setTitle("Display Time");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        startButton.addActionListener(this);
        stopButton.addActionListener(this);
        textField2.setText("Displaying current Time");
        textField1.setText("00:00");
    }

    @Override
    public void update(Graphics g) {
        super.update(g);
    }

    public void actionPerformed(ActionEvent e) {
        textField1.setText(chronometer.toString());
        if(stopButton == e.getSource()) {
            chronometer.runTimer = false;
        }else if (startButton == e.getSource()) {
            chronometer.resetTimer = true;
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Display");
        frame.setContentPane(new Display().MyDisplay);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        chronometer.updateTime(System.currentTimeMillis());
        SetterThread2 setterThread2 = new SetterThread2(chronometer);
        VerifyThread2 verifyThread2 = new VerifyThread2(chronometer);
        setterThread2.start();
        verifyThread2.start();
    }
}
