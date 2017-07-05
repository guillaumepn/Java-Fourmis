package com.company;

import java.awt.*;

public class Main {

    public static void main(String[] args) {

        MenuInfo menuInfo;
        Menu menu = new Menu();

        menu.setSize(400, 250);
        menu.setUndecorated(true);
        menu.setLocationRelativeTo(null);
        menu.show();

        menuInfo = menu.getValue();

        Simulation sim = new Simulation(menuInfo.getNbAnt(), menuInfo.getNbFood(), menuInfo.getExpiPheromone());
        Rendu rendu = new Rendu(640, 480, sim);
        rendu.setBackground(Color.white);

        while (true) {
            sim.nextStep();
            rendu.paint(sim);
            try { Thread.sleep(menuInfo.getAnimationSpeed()); } catch (InterruptedException e) { e.printStackTrace(); }
        }

    }
}
