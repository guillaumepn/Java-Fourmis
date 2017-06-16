package com.company;

import javax.swing.*;
import java.awt.event.*;

public class Menu extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;

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

    public int getTextField1() {
        return Integer.parseInt(textField1.getText());
    }

    public int getTextField2() {
        return Integer.parseInt(textField2.getText());
    }

    public int getTextField3() {
        return Integer.parseInt(textField3.getText());
    }

    private void onOK() {
        if (textField1.getText().equals("") || textField2.getText().equals("") || textField3.getText().equals("") ) {
            JOptionPane.showMessageDialog(null, "Veuillez remplir tous les champs", "Erreur",
                    JOptionPane.ERROR_MESSAGE);
        } else if(!isNumeric(textField1.getText()) || !isNumeric(textField2.getText()) || !isNumeric(textField3.getText())) {
            JOptionPane.showMessageDialog(null, "Chiffres uniquement", "Erreur",
                    JOptionPane.ERROR_MESSAGE);
        }
        else {
            setVisible(false);
            dispose();
        }
    }

    public MenuInfo getValue() {
        MenuInfo menuInfo = new MenuInfo(getTextField1(), getTextField2(), getTextField3());
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
