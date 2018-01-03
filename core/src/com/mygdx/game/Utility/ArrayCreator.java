package com.mygdx.game.Utility;



import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class ArrayCreator {

   Scanner sc = new Scanner(System.in);

public static int[] getTrajectory(String fileName){
    Path path = Paths.get(fileName);
    ArrayList<Integer>  bulletTrajectory= new ArrayList<>();
    try(Scanner sc = new Scanner(path)){
        while(sc.hasNextInt()){
            bulletTrajectory.add(sc.nextInt());
        }
    }catch(IOException ioe){
        ioe.printStackTrace();
    }

int [] f = new int[bulletTrajectory.size()];
    for(int i = 0; i < bulletTrajectory.size(); i ++){
        f[i]= bulletTrajectory.get(i);
    }
return f;
}


}
