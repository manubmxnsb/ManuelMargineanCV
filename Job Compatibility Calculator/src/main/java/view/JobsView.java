package view;

import peopleInfo.Human;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class JobsView {
    public boolean[][] moral = new boolean[5][5];
    public JFrame frame;

    public JobsView(List<String> availableJobs) {

        Color buttColor = new Color(97,103,113);
        Color buttHover = new Color(66, 103, 179);
        Color bgColor = new Color(223, 227, 238);
        Font buttFont = new Font("Arial",Font.PLAIN, 20);

        frame = new JFrame();
        frame.setTitle("JOB FOR LAZY PEOPLE");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(800, 500);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(bgColor);

        JTextArea textArea = new JTextArea();
        textArea.setFont(new Font("Bahnschrift SemiBold", Font.PLAIN, 15));
        textArea.setBorder(new LineBorder(buttColor, 2));
        textArea.setBounds(250, 98, 300, 200);
        for(String jobs : availableJobs){
            textArea.setText(textArea.getText() + "\n" + jobs);
        }
        panel.add(textArea);

        ImageIcon icon = new ImageIcon("src/main/resources/Test.png");
        Image image = icon.getImage();
        Image newImage = image.getScaledInstance(394,224,Image.SCALE_SMOOTH);
        icon.setImage(newImage);
        JLabel label = new JLabel(icon);
        label.setBounds(200,0,394,224);
        panel.add(label);

        JButton buttNext = new JButton("Exit");
        JButton buttBack = new JButton("Back");

        buttNext.setBounds(620, 385, 100, 50);
        buttNext.setContentAreaFilled(false);
        buttNext.setFont(buttFont);
        buttNext.setBorder(new LineBorder(buttColor, 4));
        buttNext.setForeground(buttColor);

        buttBack.setBounds(500, 385, 100, 50);
        buttBack.setContentAreaFilled(false);
        buttBack.setFont(buttFont);
        buttBack.setBorder(new LineBorder(buttColor, 4));
        buttBack.setForeground(buttColor);

        panel.add(buttNext);
        panel.add(buttBack);

        buttBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                View view = new View();
                view.frame.setVisible(true);
            }
        });

        buttNext.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                System.exit(0);
            }
        });

        buttBack.addMouseListener(new MouseAdapter() {
            Color color = buttBack.getForeground();

            public void mouseEntered(MouseEvent me) {
                color = buttBack.getForeground();
                buttBack.setForeground(buttHover);
                buttBack.setBorder(new LineBorder(buttHover, 4));
            }

            public void mouseExited(MouseEvent me) {
                buttBack.setForeground(color);
                buttBack.setBorder(new LineBorder(buttColor, 4));
            }
        });

        buttNext.addMouseListener(new MouseAdapter() {
            Color color = buttNext.getForeground();

            public void mouseEntered(MouseEvent me) {
                color = buttNext.getForeground();
                buttNext.setForeground(buttHover);
                buttNext.setBorder(new LineBorder(buttHover, 4));
            }

            public void mouseExited(MouseEvent me) {
                buttNext.setForeground(color);
                buttNext.setBorder(new LineBorder(buttColor, 4));
            }
        });

        frame.add(panel);
        frame.setContentPane(panel);
        frame.setVisible(true);

    }

}
