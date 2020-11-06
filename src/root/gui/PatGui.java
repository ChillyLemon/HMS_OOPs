package root.gui;

import root.app.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PatGui extends JFrame{
    private JPanel contentPane;
    private JButton back;
    private JButton accessPatientFilesButton;
    private JButton newPatientEntryButton;
    private JPanel mainPanel;
    private JPanel bottomPanel;
    private JLabel patTitle;

    public PatGui(Main obj) {
        setTitle("HMS");
        patTitle.setFont(new Font("Times New Roman",Font.BOLD,20));
        back.setFont(new Font("Arial",Font.PLAIN,14));
        newPatientEntryButton.setFont(new Font("Arial",Font.PLAIN,14));
        accessPatientFilesButton.setFont(new Font("Arial",Font.PLAIN,14));
        setContentPane(contentPane);

        accessPatientFilesButton.addActionListener(actionEvent -> {
            dispose();
            new PatRead(obj);
        });

        newPatientEntryButton.addActionListener(actionEvent -> {
            dispose();
            new PatWrite(obj);
        });

        back.addActionListener(actionEvent -> {
            dispose();
            new Entry(obj);
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
        setSize(500,300);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new java.awt.Color(69, 94, 199, 226));
        mainPanel.setOpaque(false);
        bottomPanel.setOpaque(false);
        setVisible(true);
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

}
