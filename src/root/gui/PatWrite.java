package root.gui;

import root.app.Main;
import root.dep.Department;
import root.var.Patient;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

public class PatWrite extends JFrame{
    private JPanel contentPane;
    private JButton submit;
    private JButton back;
    private JComboBox<String> deptList;
    private JButton clearAllButton;
    private JCheckBox emergencyCheckBox;
    private JComboBox<String> genderList;
    private JLabel gLabel;
    private JTextField ctNum;
    private JComboBox<String> bloodGroupList;
    private JTextField nameText;
    private JTextField dobText;
    private JLabel newpatTitle;
    private JLabel nameLabel;
    private JLabel dobLabel;
    private JLabel ctnLabel;
    private JLabel bgLabel;
    private JLabel deptLabel;
    private JPanel mainPanel;
    private JPanel bottomPanel;
    private JPanel buttonPanel;
    private JPanel namePanel;
    private JPanel gPanel;
    private JPanel dobPanel;
    private JPanel ctnPanel;
    private JPanel bgPanel;
    private JPanel deptPanel;
    private final Object Exception = new Exception("Bad Input");

    public PatWrite(Main obj) {
        setTitle("HMS");
        newpatTitle.setFont(new Font("Times New Roman",Font.BOLD,20));
        nameLabel.setFont(new Font("Arial",Font.PLAIN,16));
        dobLabel.setFont(new Font("Arial",Font.PLAIN,16));
        gLabel.setFont(new Font("Arial",Font.PLAIN,16));
        ctnLabel.setFont(new Font("Arial",Font.PLAIN,16));
        bgLabel.setFont(new Font("Arial",Font.PLAIN,16));
        deptLabel.setFont(new Font("Arial",Font.PLAIN,16));
        emergencyCheckBox.setFont(new Font("Arial",Font.PLAIN,14));
        submit.setFont(new Font("Arial",Font.PLAIN,14));
        clearAllButton.setFont(new Font("Arial",Font.PLAIN,14));
        back.setFont(new Font("Arial",Font.PLAIN,14));
        setContentPane(contentPane);

        deptList.addItem("Choose");
        String[] genderS = {"Choose", "Male", "Female", "Other"};
        for(String item : genderS){
            genderList.addItem(item);
        }
        String[] bgS = {"Choose", "A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-"};
        for (String item : bgS){
            bloodGroupList.addItem(item);
        }
        for(String item : Department.list){
            deptList.addItem(item);
        }

        submit.addActionListener(actionEvent -> {
            try {
                onOK(obj);
            } catch (Throwable e) {
                clear();
                new Error();
            }
        });

        back.addActionListener(actionEvent -> {
            dispose();
            new PatGui(obj);
        });

        clearAllButton.addActionListener(actionEvent -> clear());

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        pack();
        setSize(500,400);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new java.awt.Color(69, 94, 199, 226));
        mainPanel.setOpaque(false);
        namePanel.setOpaque(false);
        gPanel.setOpaque(false);
        dobPanel.setOpaque(false);
        bgPanel.setOpaque(false);
        ctnPanel.setOpaque(false);
        deptPanel.setOpaque(false);
        emergencyCheckBox.setOpaque(false);
        buttonPanel.setOpaque(false);
        bottomPanel.setOpaque(false);
        setVisible(true);
    }

    private void onOK(Main obj) throws Throwable {
        if(genderList.getSelectedIndex()==0 || bloodGroupList.getSelectedIndex() == 0 || deptList.getSelectedIndex() == 0){
            throw (Throwable) Exception;
        }
        if(nameText.getText().isBlank() || dobText.getText().isBlank() || ctNum.getText().isBlank()){
            throw (Throwable) Exception;
        }
        Patient p = new Patient(
                nameText.getText(), genderList.getItemAt(genderList.getSelectedIndex()),
                dobText.getText(),
                ctNum.getText(), bloodGroupList.getItemAt(bloodGroupList.getSelectedIndex()),
                deptList.getItemAt(deptList.getSelectedIndex()),
                emergencyCheckBox.isSelected()
        );
        p = obj.patDB.add(p);
        dispose();
        new PatInfo(obj, p);
    }

    private void clear(){
        emergencyCheckBox.setSelected(false);
        nameText.setText("");
        ctNum.setText("");
        dobText.setText("");
        genderList.setSelectedIndex(0);
        bloodGroupList.setSelectedIndex(0);
        deptList.setSelectedIndex(0);
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }
}
