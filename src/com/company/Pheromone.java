package com.company;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Guillaume on 14/06/2017.
 */
public class Pheromone extends JPanel {
    private int posX;
    private int posY;
    private int duration;

    public Pheromone(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
        // this.duration = 10
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

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
