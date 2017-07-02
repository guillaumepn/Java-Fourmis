package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

/**
 * Created by Guillaume on 14/06/2017.
 */
public class Ant extends JComponent {
    private int posX;
    private int posY;
    private int destX;
    private int destY;
    private boolean hasFood;
    private boolean detectFood;
    private Color color;
    private Food targetFood;
    private int idPheromone;

    public Ant(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
        this.hasFood = false;
        this.detectFood = false;
        this.idPheromone = 0;
        this.color = Color.BLACK;
        this.getRandomPoint();
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public boolean getHasFood() {
        return hasFood;
    }

    public void setHasFood(boolean hasFood) {
        this.hasFood = hasFood;
        if (hasFood) {
            this.color = Color.GRAY;
        } else {
            this.color = Color.BLACK;
        }
    }

    public int getDestX() {
        return destX;
    }

    public void setDestX(int destX) {
        this.destX = destX;
    }

    public int getDestY() {
        return destY;
    }

    public void setDestY(int destY) {
        this.destY = destY;
    }

    public void getRandomPoint() {
        Random rand = new Random();
        destX = rand.nextInt(640);
        destY = rand.nextInt(480);
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public boolean hasDetectFood() {
        return detectFood;
    }

    public void setDetectFood(boolean detectFood) {
        this.detectFood = detectFood;
    }

    public void setTargetFood(Food food) {
        this.targetFood = food;
    }

    public Food getTargetFood() {
        return targetFood;
    }
}
