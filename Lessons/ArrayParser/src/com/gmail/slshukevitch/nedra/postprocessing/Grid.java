package com.gmail.slshukevitch.nedra.postprocessing;

import java.io.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Grid {
    public List<Double> OX = new ArrayList<>();
    public List<Double> OY = new ArrayList<>();
    public List<Double> OZ = new ArrayList<>();

    //some separation values just for test
    int Xsep = 3;
    int Ysep = 3;
    //List for keeping grid elements
    List<Double[]> grid = new ArrayList<>();
    //list for keeping elements which are closest to the grid
    List<List> elements = new ArrayList<>();

    private Grid(String filename) {
        try {
            File sourceData = new File(filename);
            BufferedReader bufferedReader = new BufferedReader(new FileReader(sourceData));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] temp = line.split(" ");

                OX.add(Double.valueOf(temp[1]));
                OY.add(Double.valueOf(temp[2]));
                OZ.add(Double.valueOf(temp[3]));
                //if any int appears it means that rows with coordinates are over
                try {
                    Integer.parseInt(temp[1]);
                    break;
                } catch (NumberFormatException e) {
                    continue;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createGrid() {

        double Xmax = Collections.max(OX);
        double Xmin = Collections.min(OX);
        double Ymax = Collections.max(OY);
        double Ymin = Collections.min(OY);

        double Xcoord = Xmin;
        double Ycoord = Ymin;

        //steps for X and Y lateral coordinates
        double Xstep;
        double Ystep;

        //works only for rectangular grid with sides parallel with X/Y axis!

        for (int i = 0; i <= Xsep; i++) {
            //grid should be filled from the very beginning (x0_grid=xmin_mesh) of the mesh, so the first step is 0
            if (i == 0) {
                Xstep = 0;
            } else {
                Xstep = Math.abs((Xmax - Xmin) / Xsep);
            }
            Xcoord = Xcoord + Xstep;
            Ycoord = Ymin;  //reset in outer loop
            for (int j = 0; j <= Ysep; j++) {
                if (j == 0) {
                    Ystep = 0;
                } else {
                    Ystep = Math.abs((Ymax - Ymin) / Ysep);
                }
                Ycoord = Ycoord + Ystep;
                Double[] temp = new Double[]{Xcoord, Ycoord};
                grid.add(temp);

            }
        }

    }

    //TODO dist() method - to find distance betweeen points on 2d plane

    private void fitToMesh() {
        //initial values for comparison
        double minX = 1.0;
        double minY = 1.0;

        //every element in "elements" list is a couple of coordinates X and Y
        List<Double> couple = new ArrayList<>();

        //iterate through all grid, use the simplest linear search

        //https://en.wikipedia.org/wiki/Closest_pair_of_points_problem +
        //https://en.wikipedia.org/wiki/Nearest_neighbor_search

        for (Double[] el : grid) {


        }

    }

    public static void main(String[] args) {

        Grid grid = new Grid("D:/mesh_auto_lin_2TEST.dat");  //any path to file
        grid.createGrid();

        for (Double[] el : grid.grid) {
            System.out.println(el[0] + " @ " + el[1]);
        }

        grid.fitToMesh();

        for (List el : grid.elements) {
            System.out.println(el+"@");
        }



    }
}
