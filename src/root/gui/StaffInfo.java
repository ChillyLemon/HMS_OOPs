package root.gui;

import root.app.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;

public class StaffInfo extends JFrame {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonBack;
    private JTextField staffID;
    private JLabel staffName;
    private JLabel staffGen;
    private JLabel staffDOB;
    private JLabel staffBG;
    private JLabel staffCN;
    private JLabel staffTitle;
    private JLabel staffidLabel;
    private JLabel nameLabel;
    private JLabel gLabel;
    private JLabel dobLabel;
    private JLabel bgLabel;
    private JLabel ctnLabel;
    private JPanel buttonPanel;
    private JPanel bottomPanel;
    private JPanel mainPanel;
    private JPanel idPanel;
    private JPanel namePanel;
    private JPanel gPanel;
    private JPanel dobPanel;
    private JPanel bgPanel;
    private JPanel ctnPanel;
    private final Object Exception = new Exception("Bad Input");

    public StaffInfo(Main obj) {
        setTitle("HMS");
        staffTitle.setFont(new Font("Times New Roman",Font.BOLD,20));
        staffidLabel.setFont(new Font("Arial",Font.PLAIN,16));
        nameLabel.setFont(new Font("Arial",Font.PLAIN,16));
        dobLabel.setFont(new Font("Arial",Font.PLAIN,16));
        gLabel.setFont(new Font("Arial",Font.PLAIN,16));
        ctnLabel.setFont(new Font("Arial",Font.PLAIN,16));
        bgLabel.setFont(new Font("Arial",Font.PLAIN,16));
        buttonOK.setFont(new Font("Arial",Font.PLAIN,14));
        buttonBack.setFont(new Font("Arial",Font.PLAIN,14));
        setContentPane(contentPane);

        buttonBack.addActionListener(e -> {
            dispose();
            new Entry(obj);
        });

        buttonOK.addActionListener(actionEvent -> {
            try {
                ok();
            } catch (Throwable throwable) {
                staffID.setText("");
                staffName.setText("");
                staffGen.setText("");
                staffDOB.setText("");
                staffCN.setText("");
                staffBG.setText("");
                new Error();
            }
        });

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        pack();
        setSize(500,400);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new java.awt.Color(69, 94, 199, 226));
        mainPanel.setOpaque(false);
        idPanel.setOpaque(false);
        namePanel.setOpaque(false);
        dobPanel.setOpaque(false);
        gPanel.setOpaque(false);
        ctnPanel.setOpaque(false);
        bgPanel.setOpaque(false);
        bottomPanel.setOpaque(false);
        buttonPanel.setOpaque(false);
        setVisible(true);
    }

    private void ok() throws Throwable {
        int i = Integer.parseInt(staffID.getText());
        if(i <= 12000 || i >= 13000){
            throw (Throwable) Exception;
        }
        i %= 1000;
        BufferedReader reader = new BufferedReader(new FileReader("src/root/db/staff.txt"));
        for(int k = 0; k < i; k++){
            reader.readLine();
        }
        StringTokenizer st = new StringTokenizer(reader.readLine());
        st.nextToken();
        staffName.setText(st.nextToken());
        staffGen.setText(st.nextToken());
        staffDOB.setText(st.nextToken());
        staffCN.setText(st.nextToken());
        staffBG.setText(st.nextToken());
    }
}
