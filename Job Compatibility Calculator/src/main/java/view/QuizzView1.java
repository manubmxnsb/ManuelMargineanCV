package view;

import peopleInfo.Human;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class QuizzView1 {

    public JFrame frame;
    private String ageArray[]
            = {"16","17","18","19","20","21","22","23","24","25","26","27","28","29","30"};

    private String nationalityArray[]
            = {"Romanian","British","American","German","French","Bulgarian","Serbian","Hungarian","Chinese"};

    public QuizzView1() {

        Color buttColor = new Color(97, 103, 113);
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

        JLabel firstname = new JLabel("FIRST NAME*");
        firstname.setFont(new Font(firstname.getFont().getFontName(), Font.PLAIN, 15));
        firstname.setBounds(80, 50, 600, 50);
        panel.add(firstname);

        JTextField nameField = new JTextField();
        nameField.setFont(new Font("Arial", Font.PLAIN, 15));
        nameField.setSize(150, 20);
        nameField.setLocation(190, 65);
        panel.add(nameField);

        JLabel surname = new JLabel("SURNAME*");
        surname.setFont(new Font(surname.getFont().getFontName(), Font.PLAIN, 15));
        surname.setBounds(95, 90, 600, 50);
        panel.add(surname);

        JTextField surnameField = new JTextField();
        surnameField.setFont(new Font("Arial", Font.PLAIN, 15));
        surnameField.setSize(150, 20);
        surnameField.setLocation(190, 105);
        panel.add(surnameField);

        JLabel gender = new JLabel("GENDER*");
        gender.setFont(new Font(gender.getFont().getFontName(), Font.PLAIN, 15));
        gender.setBounds(105, 133, 600, 50);
        panel.add(gender);

        JRadioButton male = new JRadioButton("Male");
        male.setFont(new Font("Arial", Font.PLAIN, 15));
        male.setSelected(true);
        male.setSize(65, 20);
        male.setLocation(190, 150);
        panel.add(male);

        JRadioButton female = new JRadioButton("Female");
        female.setFont(new Font("Arial", Font.PLAIN, 15));
        female.setSelected(false);
        female.setSize(83, 20);
        female.setLocation(255, 150);
        panel.add(female);

        ButtonGroup gengp = new ButtonGroup();
        gengp.add(male);
        gengp.add(female);

        JLabel age = new JLabel("AGE*");
        age.setFont(new Font(age.getFont().getFontName(), Font.PLAIN, 15));
        age.setBounds(135, 185, 600, 50);
        panel.add(age);

        JComboBox year = new JComboBox(ageArray);
        year.setFont(new Font("Arial", Font.PLAIN, 15));
        year.setSize(60, 20);
        year.setLocation(190, 200);
        panel.add(year);

        JLabel nationality = new JLabel("NATIONALITY*");
        nationality.setFont(new Font(nationality.getFont().getFontName(), Font.PLAIN, 15));
        nationality.setBounds(67, 220, 600, 50);
        panel.add(nationality);

        JComboBox nation = new JComboBox(nationalityArray);
        nation.setFont(new Font("Arial", Font.PLAIN, 15));
        nation.setSize(100, 20);
        nation.setLocation(190, 235);
        panel.add(nation);

        JLabel interests = new JLabel("INTERESTS");
        interests.setFont(new Font(interests.getFont().getFontName(), Font.PLAIN, 15));
        interests.setBounds(80, 260, 600, 50);
        panel.add(interests);

        JTextArea textArea = new JTextArea(" Enter the interests here, separated\n by a comma");
        textArea.setFont(new Font(interests.getFont().getFontName(), Font.PLAIN, 15));
        textArea.setBorder(new LineBorder(buttColor, 1));
        textArea.setBounds(185,275,300,100);
        panel.add(textArea);

        JLabel textAreaExample = new JLabel("Ex: Basketball, Football, Music");
        textAreaExample.setFont(new Font(textAreaExample.getFont().getFontName(), Font.PLAIN, 11));
        textAreaExample.setBounds(190, 360, 600, 50);
        panel.add(textAreaExample);

        ImageIcon icon = new ImageIcon("src/main/resources/Test.png");
        Image image = icon.getImage();
        Image newImage = image.getScaledInstance(197, 112, Image.SCALE_SMOOTH);
        icon.setImage(newImage);
        JLabel label = new JLabel(icon);
        label.setBounds(650, 350, 197, 112);
        panel.add(label);

        JButton buttNext = new JButton("Next");
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
                String hNationality = nation.getSelectedItem().toString();
                String hName = nameField.getText() + " " + surnameField.getText();
                String hAge =  year.getSelectedItem().toString();
                String hGender;
                if(gengp.getSelection().getActionCommand() == "Male")
                {
                    hGender = "Male";
                }
                else
                {
                    hGender = "Female";
                }
                Human thisHuman = new Human(hName,hGender,hNationality,hAge);
                frame.setVisible(false);
                QuizzView2 view = new QuizzView2(thisHuman);
                view.frame.setVisible(true);
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
