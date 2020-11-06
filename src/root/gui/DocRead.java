package root.gui;

import root.app.Main;
import root.var.Doctor;

import javax.swing.*;
import java.awt.*;

public class DocRead extends JFrame {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonBack;
    private JTextField docIdInpt;
    private JPanel bottomPanel;
    private JPanel mainPanel;
    private JPanel buttonPanel;
    private JLabel docTitle;
    private JLabel docIdLabel;
    private final Object Exception = new Exception("Bad Input");

    public DocRead(Main obj) {
        setTitle("HMS");
        docTitle.setFont(new Font("Times New Roman",Font.BOLD,20));
        docIdLabel.setFont(new Font("Arial",Font.PLAIN,16));
        buttonOK.setFont(new Font("Arial",Font.PLAIN,14));
        buttonBack.setFont(new Font("Arial",Font.PLAIN,14));
        setContentPane(contentPane);

        buttonBack.addActionListener(e -> {
            dispose();
            new Entry(obj);
        });

        buttonOK.addActionListener(e -> {
            try {
                onOK(obj);
            } catch (Throwable throwable) {
                docIdInpt.setText("");
                new Error();
            }
        });

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        pack();
        setSize(500,400);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new java.awt.Color(69, 94, 199, 226));
        mainPanel.setOpaque(false);
        bottomPanel.setOpaque(false);
        buttonPanel.setOpaque(false);
        setVisible(true);
    }

    private void onOK(Main obj) throws Throwable {
        String str = docIdInpt.getText();
        if(str.length() != 6){
            throw (Throwable) Exception;
        }
        int l = Integer.parseInt(str.substring(2));
        if(l < 1000 || l > 2000) {
            throw (Throwable) Exception;
        }
        Doctor d = obj.docDB.master.get(l-1000);
        if(d.dept.toUpperCase().substring(0,2).equals(str.substring(0,2).toUpperCase())) {
            dispose();
            new DocInfo(obj, d);
        } else throw (Throwable) Exception;
    }
}
