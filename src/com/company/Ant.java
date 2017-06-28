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
    private Color color;

    public Ant(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
        this.hasFood = false;
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
            this.color = Color.RED;
        } else {
            this.color = Color.BLUE;
        }
    }

    public Color getColor(){ return color; }

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

    public Point getPos(){
        return new Point(posX,posY);
    }

    public void getRandomPoint() {
        Random rand = new Random();
        destX = rand.nextInt(640);
        destY = rand.nextInt(480);
    }

}
