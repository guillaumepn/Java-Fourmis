package com.company;

import java.awt.*;



/**
 * Created by Mawel on 28/06/17.
 */
public class Obstacle {

    private int posX;
    private int posY;
    private int width;


    public Obstacle(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
        this.width = 50 + (int)(Math.random() * 100);
        this.getCenter();
    }

    public int getX() {
        return posX;
    }

    public int getY() {
        return posY;
    }

    public Point getCenter(){
        return new Point( (posX + width)  /2,  (posY + width) /2);
    }

    public int getWidth() {
        return width;
    }

}
