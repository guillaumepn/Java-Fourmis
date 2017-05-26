package com.company;

import javax.swing.*;

/**
 * Created by Guillaume on 26/05/2017.
 */
public class Rendu {

    public Rendu(int widthFrame, int heightFrame) {
        JFrame f = new JFrame();
        f.setSize(widthFrame, heightFrame);
        f.setTitle("Simulation de fourmilière");
        f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);

        f.setVisible(true);
    }
}
