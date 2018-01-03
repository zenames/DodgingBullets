package com.mygdx.game.Utility;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;

public class ScoreConverter {
    Scanner sc;
    Path path;
    File file;
    private PrintWriter printWriter;
    ArrayList<Double> scores;

    public ScoreConverter(){
        try{
            file = new File("C:\\Users\\user\\Desktop\\GameOne\\android\\assets\\HighScore.txt");
            printWriter = new PrintWriter(new FileWriter(file, true));
            scores = new ArrayList<>();
            path = Paths.get("C:\\Users\\user\\Desktop\\GameOne\\android\\assets\\HighScore.txt");
            sc = new Scanner(path);
            System.out.println("File absolute path: "+ file.getAbsolutePath());
            while(sc.hasNext()) {
                System.out.println("adding scores to array");

                scores.add(sc.nextDouble());
            }
            System.out.println("just checking "+scores.toString());
        }catch(IOException ioe){
            ioe.printStackTrace();
        }

            //scores.add(sc.nextDouble());

        }




    public TreeSet<Double> getScores(){
        TreeSet<Double> allScores = new TreeSet<>();
        for(int i = 0; i < scores.size(); i ++){
            System.out.println("all current scores" + scores.get(i));
            allScores.add(scores.get(i));
        }

        return allScores;
    }

public void writeScores(Double scores){




               double  y = ((int) ((scores * 100.0) + ((scores < 0.0) ? -0.5 : 0.5))) / 100.0;
                printWriter.write(y+ " ");
                printWriter.flush();




}



public void renewFile(TreeSet<Double> scores){

    try{

        PrintWriter writer = new PrintWriter(file);
        writer.print("");
        writer.flush();
        writer.close();
        for(Double d: scores){
            System.out.println("printing shit ");
            printWriter.write(d.toString()+ " ");
            printWriter.flush();

        }

    }catch(FileNotFoundException fnf){
        fnf.printStackTrace();
    }

}
}
