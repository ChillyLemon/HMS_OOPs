package root.gui;

import root.app.Main;
import root.var.Doctor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DocInfo extends JFrame {
    private JPanel contentPane;
    private JButton buttonMainMenu;
    private JLabel docName;
    private JLabel docG;
    private JLabel docDOB;
    private JLabel docCN;
    private JLabel docDpt;
    private JLabel docBG;
    private JLabel docTitle;
    private JLabel nameLabel;
    private JLabel gLabel;
    private JLabel dobLabel;
    private JLabel ctnLabel;
    private JLabel deptLabel;
    private JLabel bgLabel;
    private JPanel mainPanel;
    private JPanel bottomPanel;
    private JPanel namePanel;
    private JPanel gPanel;
    private JPanel dobPanel;
    private JPanel ctnPanel;
    private JPanel deptPanel;
    private JPanel bgPanel;
    private JPanel idPanel;
    private JLabel idLabel;
    private JLabel docID;

    public DocInfo(Main obj, Doctor d) {
        setTitle("HMS");
        docTitle.setFont(new Font("Times New Roman",Font.BOLD,20));
        nameLabel.setFont(new Font("Arial",Font.PLAIN,16));
        dobLabel.setFont(new Font("Arial",Font.PLAIN,16));
        gLabel.setFont(new Font("Arial",Font.PLAIN,16));
        ctnLabel.setFont(new Font("Arial",Font.PLAIN,16));
        bgLabel.setFont(new Font("Arial",Font.PLAIN,16));
        deptLabel.setFont(new Font("Arial",Font.PLAIN,16));
        buttonMainMenu.setFont(new Font("Arial",Font.PLAIN,14));
        setContentPane(contentPane);

        buttonMainMenu.addActionListener(e -> {
            dispose();
            new Entry(obj);
        });

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        docID.setText(d.id);
        docName.setText(d.name);
        docG.setText(d.gender);
        docDOB.setText(d.dob);
        docCN.setText(d.ct_num);
        docDpt.setText(d.dept);
        docBG.setText(d.blood_Group);


        pack();
        setSize(600,400);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new java.awt.Color(69, 94, 199, 226));
        mainPanel.setOpaque(false);
        idPanel.setOpaque(false);
        namePanel.setOpaque(false);
        dobPanel.setOpaque(false);
        gPanel.setOpaque(false);
        ctnPanel.setOpaque(false);
        bgPanel.setOpaque(false);
        deptPanel.setOpaque(false);
        bottomPanel.setOpaque(false);
        setVisible(true);
    }


}
