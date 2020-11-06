package root.gui;

import root.app.Main;
import root.var.Patient;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

public class PatRead extends JFrame{
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonBack;
    private JTextField patIdInpt;
    private JLabel patreadTitle;
    private JLabel patIdLabel;
    private JPanel mainPanel;
    private JPanel bottomPanel;
    private JPanel buttonPanel;
    private final Object Exception = new Exception("Bad Input");

    public PatRead(Main obj) {
        setTitle("HMS");
        patreadTitle.setFont(new Font("Times New Roman",Font.BOLD,20));
        patIdLabel.setFont(new Font("Arial",Font.PLAIN,16));
        buttonOK.setFont(new Font("Arial",Font.PLAIN,14));
        buttonBack.setFont(new Font("Arial",Font.PLAIN,14));
        setContentPane(contentPane);

        buttonOK.addActionListener(e -> {
            try {
                onOK(obj);
            } catch (Throwable throwable) {
                patIdInpt.setText("");
                new Error();
            }
        });

        buttonBack.addActionListener(e -> {
            dispose();
            new PatGui(obj);
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);

        pack();
        setSize(450,220);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new java.awt.Color(69, 94, 199, 226));
        mainPanel.setOpaque(false);
        bottomPanel.setOpaque(false);
        buttonPanel.setOpaque(false);
        setVisible(true);
    }


    private void onOK(Main obj) throws Throwable {
        int i = Integer.parseInt(patIdInpt.getText().substring(1));
        int m = (i/1000) - 1, c = i%1000;
        if(i < 1000){
            throw (Throwable) Exception;
        } else if(m > obj.patDB.getIDM()){
            throw (Throwable) Exception;
        } else if((m == obj.patDB.getIDM() && c > obj.patDB.getIDC())){
            throw (Throwable) Exception;
        } else {
            dispose();
            new PatInfo(obj, obj.patDB.master.get(m).get(c));
        }
    }


    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

}
