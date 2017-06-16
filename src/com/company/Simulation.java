package com.company;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Guillaume on 26/05/2017.
 */
public class Simulation {

    private int nbFourmis;
    private int nbNourritures;
    private int vitesseEvap;
    private ArrayList<Ant> ants;
    private ArrayList<Food> foods;
    private ArrayList<Pheromone> pheromones;
    private Anthill anthill;
    private int destX = 50, destY = 50;
    private int cpt = 0;

    public Simulation(int nbFourmis, int nbNourritures, int vitesseEvap) {
        this.nbFourmis = nbFourmis;
        this.nbNourritures = nbNourritures;
        this.vitesseEvap = vitesseEvap;
        this.ants = new ArrayList<Ant>();
        this.foods = new ArrayList<Food>();
        this.pheromones = new ArrayList<Pheromone>();
        this.anthill = new Anthill(50, 50);
        this.createAnts();
        this.createFoods();
    }

    public void nextStep() {
        cpt++;
        for (Ant ant : ants) {
            if (cpt%50 == 0) {
                ant.getRandomPoint();
                cpt = 0;
            }
            int x = ant.getPosX();
            int y = ant.getPosY();
            if (x < ant.getDestX())
                x++;
            else
                x--;
            if (y < ant.getDestY())
                y++;
            else
                y--;
            ant.setPosX(x);
            ant.setPosY(y);
        }
    }

    public void createAnts() {
        for (int i = 0; i < this.nbFourmis; i++) {
            Ant ant = new Ant(this.anthill.getPosX(), this.anthill.getPosY());
            this.ants.add(ant);
        }
    }

    public void createFoods() {
        for (int i = 0; i < this.nbNourritures; i++) {
            Food food = new Food(this.getRandomX(), this.getRandomY());
            this.foods.add(food);
        }
    }

    public ArrayList<Ant> getAnts() {
        return ants;
    }

    public void setAnts(ArrayList<Ant> ants) {
        this.ants = ants;
    }

    public ArrayList<Food> getFoods() {
        return foods;
    }

    public void setFoods(ArrayList<Food> foods) {
        this.foods = foods;
    }

    public ArrayList<Pheromone> getPheromones() {
        return pheromones;
    }

    public void setPheromones(ArrayList<Pheromone> pheromones) {
        this.pheromones = pheromones;
    }

    public Anthill getAnthill() {
        return anthill;
    }

    public void setAnthill(Anthill anthill) {
        this.anthill = anthill;
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

    public int getRandomX() {
        int posX;
        Random rand = new Random();
        posX = rand.nextInt(640);
        return posX;
    }

    public int getRandomY() {
        int posY;
        Random rand = new Random();
        posY = rand.nextInt(480);
        return posY;
    }

}
