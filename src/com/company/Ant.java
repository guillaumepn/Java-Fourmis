package com.company;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Guillaume on 14/06/2017.
 */
public class Ant extends JPanel {
    private int posX;
    private int posY;
    private boolean hasFood;
    private Color color;

    public Ant(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
        this.hasFood = false;
        this.color = Color.BLACK;
    }

    public void paintComponent(Graphics g) {
        g.setColor(this.color);
        g.fillRect(this.posX, this.posY, 5, 5);
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
            this.color = Color.BLACK;
        }
    }
}
