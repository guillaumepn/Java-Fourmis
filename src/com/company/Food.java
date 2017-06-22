package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

/**
 * Created by Guillaume on 14/06/2017.
 */
public class Food {

    private int quantity;
    private int posX;
    private int posY;

    Random random = new Random();

    public Food(int posX, int posY) {
        this.quantity = random.nextInt(5) + 2;
        this.posX = posX;
        this.posY = posY;
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
}
