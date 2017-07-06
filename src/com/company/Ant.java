package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;
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
    private boolean followPheromone;
    private Pheromone currentPheromone;
    private Pheromone lastPheromone;
    private Shape shape;

    public Ant(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
        this.hasFood = false;
        this.detectFood = false;
        this.followPheromone = false;
        this.lastPheromone = null;
        this.color = Color.BLACK;
        this.shape = new Rectangle2D.Double(this.posX, this.posY, 5, 5);
        this.getRandomPoint();
        this.getShape();
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
    }

    public Shape getShape(){ return shape; }

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
        if(destX == posX || destY == posY){
            getRandomPoint();
        }
    }

    public Color getColor() {
        return color;
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

    public Pheromone getCurrentPheromone() {
        return currentPheromone;
    }

    public void setCurrentPheromone(Pheromone currentPheromone) {
        this.currentPheromone = currentPheromone;
    }

    public boolean isFollowPheromone() {
        return followPheromone;
    }

    public void setFollowPheromone(boolean followPheromone) {
        this.followPheromone = followPheromone;
    }

    public Pheromone getLastPheromone() {
        return lastPheromone;
    }

    public void setLastPheromone(Pheromone lastPheromone) {
        this.lastPheromone = lastPheromone;
    }
}
