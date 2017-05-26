package com.company;

/**
 * Created by Guillaume on 26/05/2017.
 */
public class Simulation {
    private int nbFourmis;
    private int nbNourritures;
    private int vitesseEvap;

    public Simulation(int nbFourmis, int nbNourritures, int vitesseEvap) {
        this.nbFourmis = nbFourmis;
        this.nbNourritures = nbNourritures;
        this.vitesseEvap = vitesseEvap;
    }

    public int getNbFourmis() {
        return nbFourmis;
    }

    public void setNbFourmis(int nbFourmis) {
        this.nbFourmis = nbFourmis;
    }

    public int getNbNourritures() {
        return nbNourritures;
    }

    public void setNbNourritures(int nbNourritures) {
        this.nbNourritures = nbNourritures;
    }

    public int getVitesseEvap() {
        return vitesseEvap;
    }

    public void setVitesseEvap(int vitesseEvap) {
        this.vitesseEvap = vitesseEvap;
    }
}
