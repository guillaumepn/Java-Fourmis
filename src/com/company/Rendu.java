package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.Rectangle;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;
import java.util.ArrayList;
import java.util.Random;


/**
 * Created by Guillaume on 26/05/2017.
 */
public class Rendu extends JPanel {


    JFrame f = new JFrame();
    //JPanel c = new JPanel();
    int widthFrame, heightFrame;
    Simulation sim;

    public Rendu(int widthFrame, int heightFrame, Simulation sim) {
        this.widthFrame = widthFrame;
        this.heightFrame = heightFrame;
        this.sim = sim;

        f.setSize(widthFrame, heightFrame);
        f.setTitle("Simulation de fourmilière");
        f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);
        f.getContentPane().add(this);

        f.setVisible(true);
    }

    public void paint(Simulation sim) {
        this.sim = sim;
        repaint();
    }

    int width;
    int height;
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.black);
        for (Ant ant : sim.getAnts()) {
            g.setColor(ant.getColor());
            g.fillRect(ant.getPosX(), ant.getPosY(), 5, 5);
        }
        for(Food food : sim.getFoods()){
            g.setColor(food.getColor());
            width = food.getQuantity() * 2;
            height = food.getQuantity() * 2;
            g.fillRect(food.getPosX(), food.getPosY(), width, height);
        }
        g.setColor(Color.green);
        g.fillRect(sim.getAnthill().getPosX(), sim.getAnthill().getPosY(), 10, 10);
    }

}
