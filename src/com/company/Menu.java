package com.company;

import com.sun.xml.internal.ws.util.StringUtils;

import javax.swing.*;
import java.awt.event.*;

public class Menu extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JTextArea textArea1;
    private JTextArea textArea2;
    private JTextArea textArea3;

    public Menu() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

    }

    public int getTextArea1() {
        return Integer.parseInt(textArea1.getText());
    }

    public int getTextArea2() {
        return Integer.parseInt(textArea2.getText());
    }

    public int getTextArea3() {
        return Integer.parseInt(textArea3.getText());
    }

    private void onOK() {
        if (textArea1.getText().equals("") || textArea2.getText().equals("") || textArea3.getText().equals("") ) {
            JOptionPane.showMessageDialog(null, "Veuillez remplir tous les champs", "Erreur",
                    JOptionPane.ERROR_MESSAGE);
        } else if(!isNumeric(textArea1.getText()) || !isNumeric(textArea2.getText()) || !isNumeric(textArea3.getText())) {
            JOptionPane.showMessageDialog(null, "Chiffres uniquement", "Erreur",
                    JOptionPane.ERROR_MESSAGE);
        }
        else {
            setVisible(false);
            dispose();
        }
    }

    public MenuInfo getValue() {
        MenuInfo menuInfo = new MenuInfo(getTextArea1(), getTextArea2(), getTextArea3());
        return menuInfo;
    }

    public static boolean isNumeric(String str)
    {
        return str.matches("-?\\d+(\\.\\d+)?");  //match a number with optional '-' and decimal.
    }

    public static void main(String[] args) {
        Menu dialog = new Menu();
        dialog.pack();
        dialog.setVisible(true);
    }
}
