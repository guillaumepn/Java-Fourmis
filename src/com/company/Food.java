package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

/**
 * Created by Guillaume on 14/06/2017.
 */
public class Food {

    private int posX;
    private int posY;
    private int quantity;
    private Color color;

    Random random = new Random();

    public Food(int posX, int posY) {
        this.quantity = random.nextInt(5) + 2;
        this.posX = posX;
        this.posY = posY;
        this.color = Color.red;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
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

    public Point getPos() { return new Point(posX, posY); }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
