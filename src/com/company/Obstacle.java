package com.company;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Mawel on 28/06/17.
 */
public class Obstacle {

    private ArrayList<Point> points = new ArrayList<>();

    public Obstacle(ArrayList<Point> points) {
        this.points = points;
    }

    public void setPoints(ArrayList<Point> points){
        
    }

    public ArrayList<Point> getPoints(){
        return points;
    }

}
