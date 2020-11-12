package root.gui;

import root.app.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;

public class AdminGui extends JFrame {
    private final String userID = "redskull";
    private final String password = "hack374";
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField adminUser;
    private JPasswordField adminPass;
    private JPanel bottomPanel;
    private JPanel mainPanel;
    private JPanel userPanel;
    private JPanel passPanel;
    private JPanel buttonPanel;
    private JLabel adminTitle;
    private JLabel userLabel;
    private JLabel passLabel;
    private final Object Exception = new Exception("Bad Input");

    public AdminGui(Main obj) {

        setTitle("HMS");
        adminTitle.setFont(new Font("Times New Roman",Font.BOLD,20));
        userLabel.setFont(new Font("Arial",Font.PLAIN,16));
        passLabel.setFont(new Font("Arial",Font.PLAIN,16));
        buttonOK.setFont(new Font("Arial",Font.PLAIN,14));
        buttonCancel.setFont(new Font("Arial",Font.PLAIN,14));
        setContentPane(contentPane);
        getRootPane().setDefaultButton(buttonOK);

        buttonCancel.addActionListener(actionEvent -> {
            dispose();
            new Entry(obj);
        });

        buttonOK.addActionListener(actionEvent -> {
            try {
                check(obj);
            } catch (Throwable throwable) {
                adminUser.setText("");
                adminPass.setText("");
                new Error();
            }
        });

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        pack();
        setSize(400,300);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new java.awt.Color(69, 94, 199, 226));
        mainPanel.setOpaque(false);
        userPanel.setOpaque(false);
        passPanel.setOpaque(false);
        buttonPanel.setOpaque(false);
        bottomPanel.setOpaque(false);
        setVisible(true);
    }

   private void check(Main obj) throws Throwable {
        if(adminUser.getText().equals(userID) || Arrays.toString(adminPass.getPassword()).equals(password)){
            dispose();
            new DocAdd(obj);
        } else throw (Throwable) Exception;
   }
}
