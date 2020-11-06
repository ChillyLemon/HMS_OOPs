package root.gui;

import root.app.Main;
import root.dep.Department;
import root.var.Doctor;
import root.var.Patient;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DocAdd extends JFrame {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonMainMenu;
    private JTextField docNamein;
    private JTextField docDOBin;
    private JTextField docCNin;
    private JButton clearAllButton;
    private JComboBox<String> genderList;
    private JComboBox<String> bgList;
    private JComboBox<String> deptList;
    private JPanel bottomPanel;
    private JPanel buttonPanel;
    private JPanel mainPanel;
    private JPanel namePanel;
    private JPanel dobPanel;
    private JPanel gPanel;
    private JPanel ctnPanel;
    private JPanel bgPanel;
    private JPanel deptPanel;
    private JLabel adddocTitle;
    private JLabel nameLable;
    private JLabel dobLabel;
    private JLabel gLabel;
    private JLabel ctnLabel;
    private JLabel bgLabel;
    private JLabel deptLabel;
    private final Object Exception = new Exception("Bad Input");

    public DocAdd(Main obj) {
        setTitle("HMS");
        adddocTitle.setFont(new Font("Times New Roman",Font.BOLD,20));
        nameLable.setFont(new Font("Arial",Font.PLAIN,16));
        dobLabel.setFont(new Font("Arial",Font.PLAIN,16));
        gLabel.setFont(new Font("Arial",Font.PLAIN,16));
        ctnLabel.setFont(new Font("Arial",Font.PLAIN,16));
        bgLabel.setFont(new Font("Arial",Font.PLAIN,16));
        deptLabel.setFont(new Font("Arial",Font.PLAIN,16));
        buttonOK.setFont(new Font("Arial",Font.PLAIN,14));
        clearAllButton.setFont(new Font("Arial",Font.PLAIN,14));
        buttonMainMenu.setFont(new Font("Arial",Font.PLAIN,14));
        setContentPane(contentPane);
        getRootPane().setDefaultButton(buttonOK);

        deptList.addItem("Choose");
        String[] genderS = {"Choose", "Male", "Female", "Other"};
        for(String item : genderS){
            genderList.addItem(item);
        }
        String[] bgS = {"Choose", "A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-"};
        for (String item : bgS){
            bgList.addItem(item);
        }
        for(String item : Department.list){
            deptList.addItem(item);
        }

        buttonMainMenu.addActionListener(actionEvent -> {
            dispose();
            new Entry(obj);
        });

        buttonOK.addActionListener(e -> {
            try {
                onOK(obj);
            } catch (Throwable throwable) {
                clear();
                new Error();
            }
        });

        clearAllButton.addActionListener(actionEvent -> clear());

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        pack();
        setSize(600,400);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new java.awt.Color(69, 94, 199, 226));
        mainPanel.setOpaque(false);
        namePanel.setOpaque(false);
        dobPanel.setOpaque(false);
        gPanel.setOpaque(false);
        ctnPanel.setOpaque(false);
        bgPanel.setOpaque(false);
         deptPanel.setOpaque(false);
        bottomPanel.setOpaque(false);
        buttonPanel.setOpaque(false);
        setVisible(true);
    }

    void clear(){
        docNamein.setText("");
        docCNin.setText("");
        docDOBin.setText("");
        genderList.setSelectedIndex(0);
        bgList.setSelectedIndex(0);
        deptList.setSelectedIndex(0);
    }

    private void onOK(Main obj) throws Throwable {
        if(genderList.getSelectedIndex()==0 || bgList.getSelectedIndex() == 0 || deptList.getSelectedIndex() == 0){
            throw (Throwable) Exception;
        }
        if(docNamein.getText().isBlank() || docDOBin.getText().isBlank() || docCNin.getText().isBlank()){
            throw (Throwable) Exception;
        }
        Doctor d = new Doctor(
                docNamein.getText(), genderList.getItemAt(genderList.getSelectedIndex()),
                docDOBin.getText(),
                docCNin.getText(), bgList.getItemAt(bgList.getSelectedIndex()),
                deptList.getItemAt(deptList.getSelectedIndex())
        );
        d = obj.docDB.add(d);
        dispose();
        new DocInfo(obj, d);
    }
}
