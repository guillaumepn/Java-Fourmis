package com.company;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

/**
 * Created by Mawel on 28/06/17.
 */
public class Obstacle {

    private int randomX;
    private int randomY;
    private int randomWidth;
    private int randomHeight;


    public Obstacle(int randomX, int randomY) {
        this.randomX = randomX;
        this.randomY = randomY;
        this.randomWidth = 50 + (int)(Math.random() * 200);
        this.randomHeight = 50 + (int)(Math.random() * 200);
    }

    public int getRandomX() {
        return randomX;
    }

    public void setRandomX(int randomX) {
        this.randomX = randomX;
    }

    public int getRandomY() {
        return randomY;
    }

    public void setRandomY(int randomY) {
        this.randomY = randomY;
    }

    public int getRandomWidth() {
        return randomWidth;
    }

    public void setRandomWidth(int randomWidth) {
        this.randomWidth = randomWidth;
    }

    public int getRandomHeight() {
        return randomHeight;
    }

    public void setRandomHeight(int randomHeight) {
        this.randomHeight = randomHeight;
    }

}
