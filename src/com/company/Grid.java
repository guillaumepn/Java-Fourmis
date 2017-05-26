package com.company;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Guillaume on 26/05/2017.
 */
public class Grid extends JPanel {

    private int[][] grid;
    private int cellSize;

    public Grid(int xCases, int yCases, int cellSize) {
        this.grid = new int[xCases][yCases];
        this.cellSize = cellSize;
    }

    public void paint(Graphics g) {
        g.setColor(Color.red);
        for (int i = 0; i < 15; i++) {
            g.drawLine(0, i * cellSize, 640, i * cellSize);
        }
        for (int j = 0; j < 20; j++) {
            g.drawLine(j * cellSize, 0, j * cellSize, 480);
        }
    }

}
