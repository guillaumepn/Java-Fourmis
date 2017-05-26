package com.company;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Guillaume on 26/05/2017.
 */
public class Rectangle extends JPanel {

    private int posX;
    private int posY;

    public Rectangle(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
    }

    public void paint(Graphics g) {
        g.setColor(Color.BLACK);
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
}
