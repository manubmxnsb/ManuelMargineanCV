package view;

import model.Job;
import peopleInfo.curiculumInfo.PersonalProject;
import peopleInfo.curiculumInfo.WorkExperience;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class View {

    public JFrame frame;

    public View() {

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

        ImageIcon icon = new ImageIcon("src/main/resources/Test.png");
        Image image = icon.getImage();
        Image newImage = image.getScaledInstance(394,224,Image.SCALE_SMOOTH);
        icon.setImage(newImage);
        JLabel label = new JLabel(icon);
        label.setBounds(200,0,394,224);
        panel.add(label);

        JButton buttQuizz = new JButton("Start Quizz");
        String twoLines = "Available Jobs";
        JButton buttAvailableJobs = new JButton("<html>" + twoLines.replaceAll("\\n", "<br>") + "</html>");

        buttQuizz.setBounds(325, 200, 150, 75);
        buttQuizz.setContentAreaFilled(false);
        buttQuizz.setFont(buttFont);
        buttQuizz.setBorder(new LineBorder(buttColor,4));
        buttQuizz.setForeground(buttColor);

        buttAvailableJobs.setBounds(325, 300, 150, 75);
        buttAvailableJobs.setContentAreaFilled(false);
        buttAvailableJobs.setFont(buttFont);
        buttAvailableJobs.setHorizontalAlignment(SwingConstants.CENTER);
        buttAvailableJobs.setBorder(new LineBorder(buttColor,4));
        buttAvailableJobs.setForeground(buttColor);

        panel.add(buttQuizz);
        panel.add(buttAvailableJobs);
        List<String> availableJobs = new ArrayList<String>();
        buttAvailableJobs.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int jobsNum = 0;
                    File myJobs = new File("src/main/resources/Jobs.txt");
                    Scanner myReader = new Scanner(myJobs);
                    jobsNum = myReader.nextInt();
                    myReader.nextLine();

                    while (myReader.hasNextLine()) {
                        for (int i = 0; i < jobsNum; i++) {
                            Job newJob = new Job();
                            for (int j = 0; j < 3; j++) {
                                if (j == 0) {
                                    String jobsName = myReader.nextLine();
                                    availableJobs.add(jobsName);
                                }
                                if (j == 1) {
                                    myReader.nextLine();
                                }
                                if (j == 2) {
                                    myReader.nextLine();
                                }
                            }

                        }
                    }
                    myReader.close();
                } catch (FileNotFoundException exception) {
                    System.out.println("An error occurred.");
                    exception.printStackTrace();
                }
                frame.setVisible(false);
                JobsView view = new JobsView(availableJobs);
                view.frame.setVisible(true);
            }
        });

        buttQuizz.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                QuizzView1 view = new QuizzView1();
                view.frame.setVisible(true);
            }
        });

        buttAvailableJobs.addMouseListener(new MouseAdapter() {
            Color color = buttAvailableJobs.getForeground();
            public void mouseEntered(MouseEvent me) {
                color = buttAvailableJobs.getForeground();
                buttAvailableJobs.setForeground(buttHover);
                buttAvailableJobs.setBorder(new LineBorder(buttHover,4));
            }
            public void mouseExited(MouseEvent me) {
                buttAvailableJobs.setForeground(color);
                buttAvailableJobs.setBorder(new LineBorder(buttColor,4));
            }
        });

        buttQuizz.addMouseListener(new MouseAdapter() {
            Color color = buttQuizz.getForeground();
            public void mouseEntered(MouseEvent me) {
                color = buttQuizz.getForeground();
                buttQuizz.setForeground(buttHover);
                buttQuizz.setBorder(new LineBorder(buttHover,4));
            }
            public void mouseExited(MouseEvent me) {
                buttQuizz.setForeground(color);
                buttQuizz.setBorder(new LineBorder(buttColor,4));
            }
        });

        frame.add(panel);
        frame.setContentPane(panel);
        frame.setVisible(true);

    }

}
