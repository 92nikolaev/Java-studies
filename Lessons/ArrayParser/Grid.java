package com.gmail.slshukevitch.nedra.postprocessing;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Grid {
    public List<Double> OX = new ArrayList<>();
    public List<Double> OY = new ArrayList<>();
    public List<Double> OZ = new ArrayList<>();
    public List<Integer> N = new ArrayList<>();  //node number

    //some separation values just for test
    int Xsep=300;
    int Ysep=300;
    Array[][] grid=new Array[Xsep][Ysep];

    private Grid(String filename) {
        try {
            File sourceData = new File(filename);
            BufferedReader bufferedReader = new BufferedReader(new FileReader(sourceData));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] temp = line.split(" ");
                N.add(Integer.parseInt(temp[0]));  //always comes first
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

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void createGrid() {
        double Xmax = Collections.max(OX);
        double Xmin = Collections.min(OX);
        double Ymax = Collections.max(OY);
        double Ymin = Collections.min(OY);
        //steps for X and Y lateral coordinates
        double Xstep=Math.abs((Xmax-Xmin)/Xsep);
        double Ystep=Math.abs((Ymax-Ymin)/Xsep);

        for(int i=0; i<=Xsep;i++){
            for(int j=0; j<=Ysep;j++){
                //grid[i][j]=
                //TODO fill the grid with values in nested loop
            }
        }

//TODO implement method which finds nearest node number to the grid point



    }


    public static void main(String[] args) {

        Grid grid = new Grid("D:/mesh_auto_lin_1TEST.dat");  //any path to file


    }
}
