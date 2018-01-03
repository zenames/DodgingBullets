package com.mygdx.game.Utility;

public class testing {
    public static void main(String[] args) {



        int []f = ArrayCreator.getTrajectory("LinePathing.txt");
        for(int i = 0; i < 20; i ++){
            System.out.println((int)(Math.random()* 4)+ 1);
        }
    }
}
