package root.gui;

import root.app.Main;
import root.db.DocDB;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Entry extends JFrame{
    private JPanel contentPane;
    private JButton Admin;
    private JButton patientButton;
    private JButton doctorButton;
    private JButton staffButton;
    private JPanel mainPanel;
    private JPanel bottomPanel;
    private JLabel titleLabel;

    public Entry(Main obj) {
        setTitle("HMS");
        titleLabel.setFont(new Font("Times New Roman",Font.BOLD,25));
        patientButton.setFont(new Font("Arial",Font.BOLD,16));
        doctorButton.setFont(new Font("Arial",Font.BOLD,16));
        staffButton.setFont(new Font("Arial",Font.BOLD,16));
        Admin.setFont(new Font("Arial",Font.BOLD,16));
        setContentPane(contentPane);

        patientButton.addActionListener(actionEvent -> {
            dispose();
            new PatGui(obj);
        });

        doctorButton.addActionListener(actionEvent -> {
            dispose();
            new DocRead(obj);
        });

        staffButton.addActionListener(actionEvent -> {
            dispose();
            new StaffInfo(obj);
        });

        Admin.addActionListener(actionEvent -> {
            dispose();
            new AdminGui(obj);
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);

        pack();
        setSize(500,400);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new java.awt.Color(69, 94, 199, 226));
        mainPanel.setOpaque(false);
        bottomPanel.setOpaque(false);
        setVisible(true);
    }

    private void onOK() {
        // add your code here
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }
}
