package view;

import model.Job;
import peopleInfo.Human;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ResultsView {

    public JFrame frame;
    private Job matchedJob;
    private int age[]
            = {16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30};

    public ResultsView(Job matchedJob, Human thisHuman) {

        this.matchedJob = matchedJob;
        Color buttColor = new Color(97, 103, 113);
        Color buttHover = new Color(66, 103, 179);
        Color bgColor = new Color(223, 227, 238);
        Font buttFont = new Font("Arial", Font.PLAIN, 20);

        frame = new JFrame();
        frame.setTitle("JOB FOR LAZY PEOPLE");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(800, 500);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(bgColor);

        JTextArea textArea = new JTextArea(thisHuman.getName() + ",\n your job compatibility is completed!" + "\n" + "Personal Info : "
        + "\nAge: " + thisHuman.getAge() + "\nGender: " + thisHuman.getGender() + "\nNationality: " + thisHuman.getNationality());
        textArea.setFont(new Font("Bahnschrift SemiBold", Font.PLAIN, 15));
        textArea.setBorder(new LineBorder(buttColor, 1));
        textArea.setBounds(250, 50, 300, 130);
        panel.add(textArea);

        JTextField jobField = new JTextField();
        jobField.setFont(new Font("Bahnschrift SemiBold", Font.PLAIN, 25));
        jobField.setSize(300, 100);
        jobField.setLocation(250, 200);
        jobField.setEditable(false);
        jobField.setHorizontalAlignment(JTextField.CENTER);
        panel.add(jobField);
        if (matchedJob.getMatchingValue() != 0) {
            jobField.setText(matchedJob.getName());
        }
        else
        {
            jobField.setText("NO MATCHING JOBS");
        }

        ImageIcon icon = new ImageIcon("src/main/resources/Test.png");
        Image image = icon.getImage();
        Image newImage = image.getScaledInstance(197, 112, Image.SCALE_SMOOTH);
        icon.setImage(newImage);
        JLabel label = new JLabel(icon);
        label.setBounds(650, 350, 197, 112);
        panel.add(label);

        ImageIcon icon2 = new ImageIcon("src/main/resources/done.png");
        Image image2 = icon2.getImage();
        Image newImage2 = image2.getScaledInstance(90, 80, Image.SCALE_SMOOTH);
        icon2.setImage(newImage2);
        JLabel label2 = new JLabel(icon2);
        label2.setBounds(600, 70, 90, 80);
        panel.add(label2);

        JButton buttExit = new JButton("Exit");
        JButton buttHome = new JButton("Home");

        buttExit.setBounds(620, 385, 100, 50);
        buttExit.setContentAreaFilled(false);
        buttExit.setFont(buttFont);
        buttExit.setBorder(new LineBorder(buttColor, 4));
        buttExit.setForeground(buttColor);

        buttHome.setBounds(500, 385, 100, 50);
        buttHome.setContentAreaFilled(false);
        buttHome.setFont(buttFont);
        buttHome.setBorder(new LineBorder(buttColor, 4));
        buttHome.setForeground(buttColor);

        panel.add(buttExit);
        panel.add(buttHome);

        buttHome.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                View view = new View();
                view.frame.setVisible(true);
            }
        });

        buttExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                System.exit(0);
            }
        });

        buttHome.addMouseListener(new MouseAdapter() {
            Color color = buttHome.getForeground();

            public void mouseEntered(MouseEvent me) {
                color = buttHome.getForeground();
                buttHome.setForeground(buttHover);
                buttHome.setBorder(new LineBorder(buttHover, 4));
            }

            public void mouseExited(MouseEvent me) {
                buttHome.setForeground(color);
                buttHome.setBorder(new LineBorder(buttColor, 4));
            }
        });

        buttExit.addMouseListener(new MouseAdapter() {
            Color color = buttExit.getForeground();

            public void mouseEntered(MouseEvent me) {
                color = buttExit.getForeground();
                buttExit.setForeground(buttHover);
                buttExit.setBorder(new LineBorder(buttHover, 4));
            }

            public void mouseExited(MouseEvent me) {
                buttExit.setForeground(color);
                buttExit.setBorder(new LineBorder(buttColor, 4));
            }
        });

        frame.add(panel);
        frame.setContentPane(panel);
        frame.setVisible(true);

    }

}
