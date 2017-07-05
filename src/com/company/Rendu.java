package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.Rectangle;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;


/**
 * Created by Guillaume on 26/05/2017.
 */
public class Rendu extends JPanel {

    private JFrame f = new JFrame();
    private int widthFrame, heightFrame;
    private Simulation sim;
    private int width;
    private int height;
    private Map<Point, Integer> Foods = new HashMap<Point, Integer>();

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

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.black);
        for (Ant ant : sim.getAnts()) {
            g.setColor(ant.getColor());
            g.fillRect(ant.getPosX(), ant.getPosY(), 5, 5);
        }
        for (Food food : sim.getFoods()){
            g.setColor(food.getColor());
            width = food.getQuantity() * 2;
            height = food.getQuantity() * 2;
            g.fillRect(food.getPosX(), food.getPosY(), width, height);
            Foods.put(food.getPos(), food.getQuantity());
        }
        for (Pheromone pheromone : sim.getPheromones()) {
            g.setColor(pheromone.getColor());
            g.fillRect(pheromone.getPosX(), pheromone.getPosY(), 2, 2);
        }

        for(Obstacle obstacle : sim.getObstacles()){
            g.setColor(Color.GRAY);
            g.drawOval(obstacle.getRandomX(), obstacle.getRandomY(), obstacle.getRandomWidth(), obstacle.getRandomHeight());
            g.fillOval(obstacle.getRandomX(), obstacle.getRandomY(), obstacle.getRandomWidth(), obstacle.getRandomHeight());
        }

        g.setColor(Color.green);
        g.fillRect(sim.getAnthill().getPosX(), sim.getAnthill().getPosY(), 10, 10);
    }

}
