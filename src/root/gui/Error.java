package root.gui;

import javax.swing.*;
import java.awt.*;

public class Error extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JPanel mainPanel;
    private JPanel bottomPanel;
    private JLabel errTitle;
    private JLabel errLabel;

    public Error() {
        setTitle("ERROR");
        errTitle.setFont(new Font("Times New Roman",Font.BOLD,20));
        errLabel.setFont(new Font("Arial",Font.BOLD,16));
        buttonOK.setFont(new Font("Arial",Font.PLAIN,14));
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        buttonOK.addActionListener(e -> dispose());
        pack();
        setSize(400,200);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new java.awt.Color(69, 94, 199, 226));
        mainPanel.setOpaque(false);
        bottomPanel.setOpaque(false);
        setVisible(true);
    }

}
