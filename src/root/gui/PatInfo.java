package root.gui;

import root.app.Main;
import root.var.Patient;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PatInfo extends JFrame {

    private JPanel contentPane;
    private JButton buttonMainMenu;
    private JLabel patId;
    private JLabel patName;
    private JLabel patG;
    private JLabel patDob;
    private JLabel patBG;
    private JLabel patCN;
    private JLabel dept;
    private JLabel toa;
    private JLabel emer;
    private JPanel mainPanel;
    private JPanel bottomPanel;
    private JLabel patinfoTitle;
    private JLabel patIdLabel;
    private JLabel nameLabel;
    private JLabel gLabel;
    private JLabel dobLabel;
    private JLabel bgLabel;
    private JLabel ctnLabel;
    private JLabel deptLabel;
    private JLabel toaLabel;
    private JLabel emerLabel;
    private JPanel idPanel;
    private JPanel namePanel;
    private JPanel gPanel;
    private JPanel dobPanel;
    private JPanel bgPanel;
    private JPanel ctnPanel;
    private JPanel deptPanel;
    private JPanel toaPanel;
    private JPanel emerPanel;

    public PatInfo(Main obj, Patient p) {
        setTitle("HMS");
        patinfoTitle.setFont(new Font("Times New Roman",Font.BOLD,20));
        patIdLabel.setFont(new Font("Arial",Font.PLAIN,16));
        nameLabel.setFont(new Font("Arial",Font.PLAIN,16));
        dobLabel.setFont(new Font("Arial",Font.PLAIN,16));
        gLabel.setFont(new Font("Arial",Font.PLAIN,16));
        ctnLabel.setFont(new Font("Arial",Font.PLAIN,16));
        bgLabel.setFont(new Font("Arial",Font.PLAIN,16));
        deptLabel.setFont(new Font("Arial",Font.PLAIN,16));
        toaLabel.setFont(new Font("Arial",Font.PLAIN,16));
        emerLabel.setFont(new Font("Arial",Font.PLAIN,16));
        buttonMainMenu.setFont(new Font("Arial",Font.PLAIN,14));
        setContentPane(contentPane);

        buttonMainMenu.addActionListener(e ->{
            dispose();
            new Entry(obj);
        });

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        patId.setText(p.id);
        patName.setText(p.name);
        patG.setText(p.gender);
        patDob.setText(p.dob);
        patBG.setText(p.blood_Group);
        patCN.setText(p.ct_num);
        dept.setText(p.dept);
        toa.setText(p.time.toString());
        emer.setText(p.emergency ? "YES" : "NO");
        
        pack();
        setSize(500,400);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new java.awt.Color(69, 94, 199, 226));
        mainPanel.setOpaque(false);
        idPanel.setOpaque(false);
        namePanel.setOpaque(false);
        gPanel.setOpaque(false);
        dobPanel.setOpaque(false);
        bgPanel.setOpaque(false);
        ctnPanel.setOpaque(false);
        deptPanel.setOpaque(false);
        toaPanel.setOpaque(false);
        emerPanel.setOpaque(false);
        bottomPanel.setOpaque(false);
        setVisible(true);
    }
}
