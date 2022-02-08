package ex1;

import javax.swing.JFrame;

public class SimpleApp extends JFrame{

    SimpleApp(){
        setTitle("Exercitiul 1");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400,500);
        setVisible(true);
    }

    public static void main(String[] args) {
        SimpleApp a = new SimpleApp();
    }

}