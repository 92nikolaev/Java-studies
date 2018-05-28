package com.gmail.slshukevitch.nedra.postprocessing;

import java.io.*;

import java.util.*;

class Grid {
    private List<Double> OX = new ArrayList<>();
    private List<Double> OY = new ArrayList<>();
    private List<Double> OZ = new ArrayList<>();
    //List for keeping points "as is" - every element is 3-component Array of X,Y and Z coordinates
    public List<Double[]> points = new ArrayList<>();
    //some separation values for grid just for test
    private int Xsep = 25;
    private int Ysep = 25;
    //List for keeping grid elements
    List<Double[]> grid = new ArrayList<>();
    Map<Integer, HashMap> pointsTree = new HashMap<>();

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

        for (int j = 0; j < OX.size(); j++) {
            Double[] coord = new Double[3];
            coord[0] = OX.get(j);
            coord[1] = OY.get(j);
            coord[2] = OZ.get(j);
            points.add(coord);
        }
        OX.clear();
        OY.clear();
        OZ.clear();
    }

    private void fitToMesh() {

        //iterate through all grid, use the simplest bruteforce search
        //!this may cause performance issue, i.e. for every grid point we iterate through ALL nodes!
        //possible solution is https://en.wikipedia.org/wiki/Closest_pair_of_points_problem divide&conquer approach

        for (int k = 0; k < grid.size(); k++) {
            HashMap<Integer, Double> nodeDistance = new HashMap<>();
            for (int i = 0; i < points.size(); i++) {
                double temp = dist(grid.get(k)[0], points.get(i)[0], grid.get(k)[1], points.get(i)[1]);
                nodeDistance.put((i + 1), temp);
                pointsTree.put(k + 1, (nodeDistance));
            }
        }



        for (int i = 1; i < grid.size() + 1; i++) {  //iterate via Keys aka Point number to get grid points
            HashMap<Integer, Double> map = pointsTree.get(i);
            List<Double> lengthSet = new ArrayList<>();
            //for every point we obtain set of nodes and their distance to grid point
            for (Double value : map.values()) {
                lengthSet.add(value);    //copy all values in some List
            }
            Collections.sort(lengthSet);
            double minLength = lengthSet.get(0);  //minimum length to nearest node for current grid point
            lengthSet.clear();
            int nodeNumber = getNumber(map, minLength);  //node number
            //TODO write to collection, file, etc.
            System.out.println(nodeNumber+"@"+minLength);

        }

    }

    private double dist(double x1, double x2, double y1, double y2) {
        return Math.sqrt(((x2 - x1) * (x2 - x1)) + ((y2 - y1) * (y2 - y1)));
    }

    private int getNumber(Map<Integer, Double> map, Double value) {
        int key=0;
        for (Map.Entry<Integer, Double> entry : map.entrySet()) {
            if (value.equals(entry.getValue())) {
                key = entry.getKey();
                return key;
            }
        }
        return key;
    }

    public static void main(String[] args) {
        Grid grid = new Grid("D:/mesh_auto_lin_2TEST.txt");  //any path to file
        grid.createGrid();
        grid.fitToMesh();

    }
}
