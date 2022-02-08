package ex5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import ex5.Controler;

public class ex5 extends JFrame implements ItemListener {
    private JPanel panel1;
    private JTextField traseuText;
    private JComboBox statie1;
    private JComboBox statie2;
    private JTextArea textArea1;
    private JTextArea textArea2;

    public ex5() {
        traseuText.setText(" Pick your interested stations : ");
        setTitle("Train Trips");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        statie1 = new JComboBox();
        statie1.addItem("Cluj Napoca");
        statie1.addItem("Beclean");
        statie1.addItem("Bucuresti");
        statie1.setSelectedIndex(0);

        statie2 = new JComboBox();
        statie2.addItem("Cluj Napoca");
        statie2.addItem("Beclean");
        statie2.addItem("Bucuresti");
        statie2.setSelectedIndex(0);

        add(statie1);
        add(statie2);
        pack();
        statie1.addItemListener(this);
        statie2.addItemListener(this);
        setSize(500, 500);
    }

    public void itemStateChanged(ItemEvent e) {
        Controler c1 = new Controler("Cluj-Napoca");

        Segment s1 = new Segment(1);
        Segment s2 = new Segment(2);
        Segment s3 = new Segment(3);

        c1.addControlledSegment(s1);
        c1.addControlledSegment(s2);
        c1.addControlledSegment(s3);

        //build station Bucuresti
        Controler c2 = new Controler("Bucuresti");

        Segment s4 = new Segment(4);
        Segment s5 = new Segment(5);
        Segment s6 = new Segment(6);

        c2.addControlledSegment(s4);
        c2.addControlledSegment(s5);
        c2.addControlledSegment(s6);

        Controler c3 = new Controler("Beclean");

        Segment s7 = new Segment(7);
        Segment s8 = new Segment(8);
        Segment s9 = new Segment(9);

        c3.addControlledSegment(s7);
        c3.addControlledSegment(s8);
        c3.addControlledSegment(s9);

        //connect the 2 controllers

        c1.addToNeighbourControllerList(c2);
        c1.addToNeighbourControllerList(c3);
        c2.addToNeighbourControllerList(c1);
        c2.addToNeighbourControllerList(c3);
        c3.addToNeighbourControllerList(c1);
        c3.addToNeighbourControllerList(c2);

        //testing

        Train t1 = new Train("Bucuresti", "IC-001");
        s1.arriveTrain(t1);

        Train t2 = new Train("Cluj-Napoca", "R-002");
        s5.arriveTrain(t2);

        Train t3 = new Train("Beclean", "C-69");
        switch (statie1.getSelectedIndex()) {
            case 0: {
                textArea1.setText(c1.displayStationState());
                break;
            }
            case 1: {
                textArea1.setText(c2.displayStationState());
                break;
            }
            case 2: {
                textArea1.setText(c3.displayStationState());
                break;
            }
        }
        switch (statie2.getSelectedIndex()) {
            case 0: {
                textArea2.setText(c1.displayStationState());
                break;
            }
            case 1: {
                textArea2.setText(c2.displayStationState());
                break;
            }
            case 2: {
                textArea2.setText(c3.displayStationState());
                break;
            }
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("ex5");
        frame.setContentPane(new ex5().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }
}
