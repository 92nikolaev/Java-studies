package com.gmail.slshukevitch.nedra.postprocessing;

import java.io.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Grid {
    private List<Double> OX = new ArrayList<>();
    private List<Double> OY = new ArrayList<>();
    private List<Double> OZ = new ArrayList<>();

    //List for keeping points "as is" - every element is 3-component Array of X,Y and Z coordinates
    public List<Double[]> points = new ArrayList<>();

    //some separation values for grid just for test
    int Xsep = 3;
    int Ysep = 3;
    //List for keeping grid elements
    List<Double[]> grid = new ArrayList<>();
    //list for keeping elements which are closest to the grid - the result set
    List<Double[]> elements = new ArrayList<>();

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

        //copy values from OX, OY, OZ to points list
        for(int j=0; j<OX.size();j++){
            Double[] coord = new Double[3];
            coord[0]=OX.get(j);
            coord[1]=OY.get(j);
            coord[2]=OZ.get(j);
            points.add(coord);
        }

        OX.clear();
        OY.clear();
        OZ.clear();
    }


    private void fitToMesh() {
        //iterate through all grid, use the simplest linear search

        //https://en.wikipedia.org/wiki/Closest_pair_of_points_problem +
        //https://en.wikipedia.org/wiki/Nearest_neighbor_search

        Double[] a = new Double[2];
        double distance = 100.0;  //some big value
        for (int k = 0; k < 5; k++) {  //grid.size()
            System.out.println("This is Grid element #"+(k+1)+": "+grid.get(k)[0]+"@"+grid.get(k)[1]);
            for (int i = 0; i < points.size(); i++) {
                    System.out.println("Node: "+points.get(i)[0]+"@"+points.get(i)[1]);
                    System.out.println("Distance between this Node and "+(k+1)+"st element: "+
                    dist(grid.get(k)[0], points.get(i)[0], grid.get(k)[1], points.get(i)[1]));

                }
            }
            //elements.add(a);
        }


    private double dist(double x1, double x2, double y1, double y2) {
        return Math.sqrt(((x2 - x1) * (x2 - x1)) + ((y2 - y1) * (y2 - y1)));
    }


    public static void main(String[] args) {

        Grid grid = new Grid("D:/mesh_auto_lin_2TEST.txt");  //any path to file
        grid.createGrid();
/*
        for (int i = 0; i < 5; i++) {
            System.out.println(grid.grid.get(i)[0] + " @@ " + grid.grid.get(i)[1]);
        }
*/

        grid.fitToMesh();

        for (Double[] el : grid.elements) {
            System.out.println(el[0] + "@" + el[1]);
        }


    }
}
