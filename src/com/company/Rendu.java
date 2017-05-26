package com.company;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Guillaume on 26/05/2017.
 */
public class Rendu extends JFrame {

    JFrame f = new JFrame();
    Grid grid = new Grid(15, 20, 32);
    Rectangle r = new Rectangle(30, 30);

    public Rendu(int widthFrame, int heightFrame) {

        f.setSize(widthFrame, heightFrame);
        f.setTitle("Simulation de fourmilière");
        f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);

        f.add(grid, BorderLayout.CENTER);

        f.add(r);

        f.setVisible(true);

        grid.repaint();
        r.repaint();
        f.repaint();

        anim();
    }

    public void anim() {
        for (int i = 0; i < 500 ; i++) {
            int x = r.getPosX();
            int y = r.getPosY();
            x++;
            y++;
            r.setPosX(x);
            r.setPosY(y);
//            pF.revalidate();
            f.repaint();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
