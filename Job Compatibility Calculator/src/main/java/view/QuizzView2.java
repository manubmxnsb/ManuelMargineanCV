package view;

import model.Job;
import model.WantedJob;
import peopleInfo.Human;
import peopleInfo.curiculumInfo.PersonalProject;
import peopleInfo.curiculumInfo.WorkExperience;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.text.BadLocationException;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.List;

public class QuizzView2 {
    public JFrame frame;
    private String workExpArray[]
            = {"Web Programmer", "Game Programmer", "System Programmer",
            "App Programmer", "Software Engineer", "Family Physician", "Surgeon",
            "Peditrician", "Physician", "Internal Medicine Physician"};


    public QuizzView2(Human human) {

        Color buttColor = new Color(97, 103, 113);
        Color buttHover = new Color(66, 103, 179);
        Color bgColor = new Color(223, 227, 238);
        Font buttFont = new Font("Arial", Font.PLAIN, 20);
        Font buttFont2 = new Font("Arial", Font.PLAIN, 14);

        frame = new JFrame();
        frame.setTitle("JOB FOR LAZY PEOPLE");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(800, 500);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(bgColor);

        JLabel nationality = new JLabel("WORK EXPERIENCE*");
        nationality.setFont(new Font(nationality.getFont().getFontName(), Font.PLAIN, 15));
        nationality.setBounds(90, 50, 600, 50);
        panel.add(nationality);

        JComboBox workExp = new JComboBox(workExpArray);
        workExp.setFont(new Font("Arial", Font.PLAIN, 15));
        workExp.setSize(200, 20);
        workExp.setLocation(270, 67);
        panel.add(workExp);

        JLabel interests = new JLabel("PERSONAL PROJECTS");
        interests.setFont(new Font(interests.getFont().getFontName(), Font.PLAIN, 15));
        interests.setBounds(70, 230, 600, 50);
        panel.add(interests);

        JTextArea textArea = new JTextArea(" Enter relevant projects here, separated\n by a comma");
        textArea.setFont(new Font(interests.getFont().getFontName(), Font.PLAIN, 15));
        textArea.setBorder(new LineBorder(buttColor, 1));
        textArea.setBounds(260, 245, 300, 100);
        panel.add(textArea);

        JTextArea textArea2 = new JTextArea();
        textArea2.setFont(new Font(interests.getFont().getFontName(), Font.PLAIN, 15));
        textArea2.setBorder(new LineBorder(buttColor, 1));
        textArea2.setEditable(false);
        textArea2.setBounds(260, 100, 300, 140);
        panel.add(textArea2);

        JLabel textAreaExample = new JLabel("Ex: Snake Game, A Database, ISP Project ");
        textAreaExample.setFont(new Font(textAreaExample.getFont().getFontName(), Font.PLAIN, 11));
        textAreaExample.setBounds(270, 330, 600, 50);
        panel.add(textAreaExample);

        ImageIcon icon = new ImageIcon("src/main/resources/Test.png");
        Image image = icon.getImage();
        Image newImage = image.getScaledInstance(197, 112, Image.SCALE_SMOOTH);
        icon.setImage(newImage);
        JLabel label = new JLabel(icon);
        label.setBounds(650, 350, 197, 112);
        panel.add(label);

        JButton buttFinish = new JButton("Finish");
        JButton buttBack = new JButton("Back");
        JButton buttAdd = new JButton("Add");
        JButton buttRemove = new JButton("Remove");

        buttAdd.setBounds(500, 65, 60, 30);
        buttAdd.setContentAreaFilled(false);
        buttAdd.setFont(buttFont2);
        buttAdd.setBorder(new LineBorder(buttColor, 4));
        buttAdd.setForeground(buttColor);

        buttRemove.setBounds(570, 65, 70, 30);
        buttRemove.setContentAreaFilled(false);
        buttRemove.setFont(buttFont2);
        buttRemove.setBorder(new LineBorder(buttColor, 4));
        buttRemove.setForeground(buttColor);

        buttFinish.setBounds(620, 385, 100, 50);
        buttFinish.setContentAreaFilled(false);
        buttFinish.setFont(buttFont);
        buttFinish.setBorder(new LineBorder(buttColor, 4));
        buttFinish.setForeground(buttColor);

        buttBack.setBounds(500, 385, 100, 50);
        buttBack.setContentAreaFilled(false);
        buttBack.setFont(buttFont);
        buttBack.setBorder(new LineBorder(buttColor, 4));
        buttBack.setForeground(buttColor);

        panel.add(buttFinish);
        panel.add(buttBack);
        panel.add(buttAdd);
        panel.add(buttRemove);

        textArea2.append("\n");
        buttAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea2.append(workExp.getSelectedItem().toString() + "\n");
            }
        });

        buttRemove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String content = null;
                content = textArea2.getText();
                int lastLineBreak = content.lastIndexOf('\n');
                try {
                    textArea2.getDocument().remove(lastLineBreak, textArea2.getDocument().getLength() - lastLineBreak);
                } catch (BadLocationException badLocationException) {
                    badLocationException.printStackTrace();
                }
            }
        });

        buttBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                QuizzView1 view = new QuizzView1();
                view.frame.setVisible(true);
            }
        });

        buttFinish.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                WantedJob wantedJob = new WantedJob();
                List<WorkExperience> workExperience = new ArrayList<>();
                for (String name : textArea2.getText().split("\n")) {
                    if (!name.isEmpty()) {
                        workExperience.add(new WorkExperience(name));
                        wantedJob.setWorkExperienceList(workExperience);
                    }
                }
                List<PersonalProject> personalProject = new ArrayList<>();
                for (String nameP : textArea.getText().split(",")) {
                    if (!nameP.isEmpty()) {
                        personalProject.add(new PersonalProject(nameP));
                        wantedJob.setPersonalProjectList(personalProject);
                    }
                }

                List<Job> jobs = new ArrayList<>();
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
                                    newJob.setName(jobsName);
                                }
                                if (j == 1) {
                                    List<String> workExp = Arrays.asList(myReader.nextLine().split(","));
                                    List<WorkExperience> myWorkExp = new ArrayList<>();
                                    for (String exp : workExp) {
                                        myWorkExp.add(new WorkExperience(exp));
                                    }
                                    newJob.setWorkExperience(myWorkExp);
                                }
                                if (j == 2) {
                                    List<String> persProj = Arrays.asList(myReader.nextLine().split(","));
                                    List<PersonalProject> myPersProj = new ArrayList<>();
                                    for (String pers : persProj) {
                                        myPersProj.add(new PersonalProject(pers));
                                    }
                                    newJob.setPersonalProjects(myPersProj);
                                }
                            }
                            jobs.add(newJob);
                        }
                    }
                    myReader.close();
                } catch (FileNotFoundException exception) {
                    System.out.println("An error occurred.");
                    exception.printStackTrace();
                }

                for (Job job : jobs) {
                    int matchingValue = 0;

                    for (WorkExperience workExperience1 : wantedJob.getWorkExperienceList()) {
                        if (job.getWorkExperience().contains(workExperience1)) {
                            matchingValue++;
                        }
                    }
                    for (PersonalProject personalProject1 : wantedJob.getPersonalProjectList()) {
                        if (job.getPersonalProjects().contains(personalProject1)) {
                            matchingValue++;
                        }
                    }

                    job.setMatchingValue(matchingValue);
                }

                Job matchedJob = jobs.stream()
                        .max(Comparator.comparingInt(Job::getMatchingValue))
                        .orElse(null);


                frame.setVisible(false);
                ResultsView view = new ResultsView(matchedJob,human);
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

        buttFinish.addMouseListener(new MouseAdapter() {
            Color color = buttFinish.getForeground();

            public void mouseEntered(MouseEvent me) {
                color = buttFinish.getForeground();
                buttFinish.setForeground(buttHover);
                buttFinish.setBorder(new LineBorder(buttHover, 4));
            }

            public void mouseExited(MouseEvent me) {
                buttFinish.setForeground(color);
                buttFinish.setBorder(new LineBorder(buttColor, 4));
            }
        });

        frame.add(panel);
        frame.setContentPane(panel);
        frame.setVisible(true);

    }

}
