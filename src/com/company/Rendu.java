package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.Random;


/**
 * Created by Guillaume on 26/05/2017.
 */
public class Rendu extends JFrame {

    private Simulation simulation;
    private JFrame f = new JFrame();
    private JPanel c = new JPanel();
    private Grid grid = new Grid(15, 20, 32);
    private Ant r = new Ant(30, 30);
    private int widthFrame, heightFrame;
    private int destX = 30, destY = 30;

    public Rendu(int widthFrame, int heightFrame, Simulation simulation) {
        this.simulation = simulation;
        this.widthFrame = widthFrame;
        this.heightFrame = heightFrame;
        f.setSize(widthFrame, heightFrame);
        f.setTitle("Simulation de fourmilière");
        f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);

        f.add(c, BorderLayout.CENTER);

        f.add(r);

        f.setVisible(true);

        anim();
    }

    public void anim() {
        int cpt = 0;
        while (true) {
            cpt++;
            int x = r.getPosX();
            int y = r.getPosY();
            if (destX >= x)
                x++;
            else
                x--;
            if (destY >= y)
                y++;
            else
                y--;
            r.setPosX(x);
            r.setPosY(y);
            f.repaint();
            //System.out.println(cpt + " " + x + " " + y);
            if ((cpt % 50) == 0) {
                getRandomPoint();
                cpt = 0;
            }

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void getRandomPoint() {
        Random rand = new Random();
        destX = rand.nextInt(widthFrame);
        destY = rand.nextInt(heightFrame);
    }


}
