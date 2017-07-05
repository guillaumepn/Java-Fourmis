package com.company;

import javax.xml.bind.annotation.XmlType;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

/**
 * Created by Guillaume on 26/05/2017.
 */
public class Simulation {

    private int nbFourmis;
    private int nbNourritures;
    private int vitesseEvap;
    private ArrayList<Ant> ants;
    private ArrayList<Shape> antsShape;
    private ArrayList<Obstacle> obstacles;
    private ArrayList<Shape> obstaclesShape;
    private HashSet<Food> foods;
    private ArrayList<Pheromone> pheromones;
    private Anthill anthill;
    private int destX = 50, destY = 50;
    private int cpt = 0;

    public Simulation(int nbFourmis, int nbNourritures, int vitesseEvap) {
        this.nbFourmis = nbFourmis;
        this.nbNourritures = nbNourritures;
        this.vitesseEvap = vitesseEvap;
        this.ants = new ArrayList<>();
        this.foods = new HashSet<>();
        this.obstacles = new ArrayList<>();
        this.obstaclesShape = new ArrayList<>();
        this.pheromones = new ArrayList<>();
        this.anthill = new Anthill(50, 50);
        this.createAnts();
        this.createFoods();
        this.createObstacles();
    }

    public void nextStep() {
        cpt++;
        for (Ant ant : ants) {
            //Collision
            Shape rect = new Rectangle2D.Double(ant.getPosX(), ant.getPosY(), 5, 5);
            for (Shape obstacle : obstaclesShape) {
                if(obstacle.intersects(rect.getBounds())){
                    System.out.println("Boom");
                }
            }


            // La fourmi n'a pas encore vu de nourriture
            if (!ant.hasDetectFood() && !ant.isFollowPheromone()) {
                if (cpt % 50 == 0) {
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
                for (Food food : foods) {
                    if (
                            Math.abs(ant.getPosX() - food.getPosX()) <= 20 &&
                                    Math.abs(ant.getPosY() - food.getPosY()) <= 20 &&
                                    food.getQuantity() > 0
                            ) {
                        ant.setDetectFood(true);
                        ant.setTargetFood(food);
                        break;
                    }
                }
                for (Pheromone pheromone : pheromones) {
                    if (
                            (ant.getPosX() == pheromone.getPosX() ||
                             ant.getPosX() == pheromone.getPosX()-1) &&
                            (ant.getPosY() == pheromone.getPosY() ||
                             ant.getPosY() == pheromone.getPosY()-1) &&
                             pheromone.getDuration() >= 1 &&
                             pheromone.getPreviousPheromone() != null
                        ) {
                        ant.setFollowPheromone(true);
                        ant.setCurrentPheromone(pheromone);
                        break;
                    }
                }
            } // La fourmi a aperçu de la nourriture
            else if (ant.hasDetectFood() && !ant.getHasFood()) {
                ant.setDestX(ant.getTargetFood().getPosX());
                ant.setDestY(ant.getTargetFood().getPosY());
                int x = ant.getPosX();
                int y = ant.getPosY();
                if (x < ant.getDestX())
                    x++;
                else if (x > ant.getDestX())
                    x--;
                if (y < ant.getDestY())
                    y++;
                else if (y > ant.getDestY())
                    y--;
                ant.setPosX(x);
                ant.setPosY(y);
                if (
                        ant.getPosX() == ant.getTargetFood().getPosX() &&
                                ant.getPosY() == ant.getTargetFood().getPosY() &&
                                ant.getTargetFood().getQuantity() > 0
                        ) {
                    ant.setHasFood(true);
                    int foodQty = ant.getTargetFood().getQuantity();
                    foodQty--;
                    ant.getTargetFood().setQuantity(foodQty);
                    if (ant.getTargetFood().getQuantity() < 1) {
                        ant.getTargetFood().setColor(Color.white);
                    }
                }
            } // La fourmi a ramassé la nourriture et retourne à la maison
            else if (ant.getHasFood()) {
                ant.setDestX(anthill.getPosX());
                ant.setDestY(anthill.getPosY());
                int x = ant.getPosX();
                int y = ant.getPosY();
                Pheromone pheromone = new Pheromone(x, y);
                if (ant.getLastPheromone() != null)
                    pheromone.setPreviousPheromone(ant.getLastPheromone());
                this.pheromones.add(pheromone);
                if (x < ant.getDestX())
                    x++;
                else if (x > ant.getDestX())
                    x--;
                if (y < ant.getDestY())
                    y++;
                else if (y > ant.getDestY())
                    y--;
                ant.setPosX(x);
                ant.setPosY(y);
                ant.setLastPheromone(pheromone);
                if (
                        ant.getPosX() == anthill.getPosX() &&
                        ant.getPosY() == anthill.getPosY()
                        ) {
                    ant.setHasFood(false);
                    ant.setDetectFood(false);
                }
            } // La fourmi sans nourriture a croisé un chemin de phéromones
            else if (!ant.hasDetectFood() && !ant.getHasFood() && ant.isFollowPheromone()) {
                if (
                        ant.getCurrentPheromone().getDuration() >= 1 &&
                        ant.getCurrentPheromone().getPreviousPheromone() != null
                    ) {
                    Pheromone previousPheromone = ant.getCurrentPheromone().getPreviousPheromone();
                    ant.setPosX(previousPheromone.getPosX());
                    ant.setPosY(previousPheromone.getPosY());
                    ant.setCurrentPheromone(previousPheromone);
                } else {
                    ant.setFollowPheromone(false);
                }
            }

        }

        for (Pheromone pheromone : pheromones) {
            if (cpt%50 == 0) {
                int duration = pheromone.getDuration();
                pheromone.setDuration(duration - 1);
            }
            if (pheromone.getDuration() < 1) {
                pheromone.setColor(Color.white);
            }
        }
    }

    public void createObstacles(){
        for (int i = 0; i < 3; i++){
            Obstacle obstacle = new Obstacle(getRandomX(), getRandomY());
            this.obstacles.add(obstacle);

            Shape oval = new Ellipse2D.Double(getRandomX(), getRandomY(), obstacle.getRandomWidth(), obstacle.getRandomHeight());
            this.obstaclesShape.add(oval);
        }
    }

    public void createAnts() {
        int diffX;
        int diffY;
        Random rand = new Random();
        for (int i = 0; i < this.nbFourmis; i++) {
            diffX = rand.nextInt(30);
            diffX -= 15;
            diffY = rand.nextInt(30);
            diffY -= 15;
            Ant ant = new Ant(this.anthill.getPosX()+diffX, this.anthill.getPosY()+diffY);
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

    public HashSet<Food> getFoods() {
        return foods;
    }

    public ArrayList<Obstacle> getObstacles() { return obstacles; }

    public void setFoods(HashSet<Food> foods) {
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
