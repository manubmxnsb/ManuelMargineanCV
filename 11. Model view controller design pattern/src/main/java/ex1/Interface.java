package exercises.ex1;

import javax.swing.*;

public class Interface extends JFrame implements Observer {
    private JTextField textField = new JTextField("");
    public Interface(){
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(300, 100);
        this.setVisible(true);
        this.add(textField);
    }

    @Override
    public void update(Object event) {
        textField.setText("Temperature from sensor is: " + event.toString());
    }
}
