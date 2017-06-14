package com.company;

/**
 * Created by robilol on 14/06/17.
 */
public class MenuInfo {
    private int nbAnt;
    private int nbFood;
    private int expiPheromone;

    public MenuInfo(int nbAnt, int nbFood, int expiPheromone) {
        this.nbAnt = nbAnt;
        this.nbFood = nbFood;
        this.expiPheromone = expiPheromone;
    }

    public int getNbAnt() {
        return nbAnt;
    }

    public void setNbAnt(int nbAnt) {
        this.nbAnt = nbAnt;
    }

    public int getNbFood() {
        return nbFood;
    }

    public void setNbFood(int nbFood) {
        this.nbFood = nbFood;
    }

    public int getExpiPheromone() {
        return expiPheromone;
    }

    public void setExpiPheromone(int expiPheromone) {
        this.expiPheromone = expiPheromone;
    }
}
