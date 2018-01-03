package com.mygdx.game.Score;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Characters.Interactable;
import com.mygdx.game.Utility.ScoreConverter;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.TreeSet;

public class ScoreBoard {


    //private BufferedReader bufferedReader;
    private BufferedWriter bufferedWriter;
    private ScoreConverter scoreConverter;
    private double score;
    private String scoreDisplay;
    TreeSet<Double> TopScores;
    BitmapFont display;
    public ScoreBoard(){
scoreConverter = new ScoreConverter();

     create();



    }


    public void create(){
       score = 0;
        scoreDisplay = "score: "+ score;
        display = new BitmapFont();
        TopScores = new TreeSet<>();
        TopScores = scoreConverter.getScores();


    }

    public void updateScore(){
        score += Gdx.graphics.getDeltaTime();
        scoreDisplay = "score: "+ score;
    }


    public void updateScoreFile(){

        double  y = ((int) ((score * 100.0) + ((score < 0.0) ? -0.5 : 0.5))) / 100.0;
            TopScores.add(y);
            if(TopScores.size()> 10){
                TopScores.remove(TopScores.first());
                scoreConverter.renewFile(TopScores);

            }else{
                System.out.println("first thing: "+TopScores.first());
                scoreConverter.writeScores(score);
            }



    }

public void resetScore(){

    double  y = ((int) ((score * 100.0) + ((score < 0.0) ? -0.5 : 0.5))) / 100.0;
    TopScores.add(y);
    if(TopScores.size()> 10){
        TopScores.remove(TopScores.first());
        scoreConverter.renewFile(TopScores);

    }
        score = 0;
        scoreDisplay = "score: "+ score;
}


    public void drawScoreBoard(SpriteBatch batch){

        display.setColor(1.0f, 1.0f, 1.0f, 1.0f);
        display.draw(batch, scoreDisplay, 850, 450);

    }
    public void drawHighScores(SpriteBatch batch){
        display.setColor(1.0f, 1.0f, 1.0f, 1.0f);
        int count = 0;
for(Double f: TopScores) {
        display.draw(batch, f.toString(), 500, 150 + (count * 20));
    count ++;
}

    }
    public void checkHighScore(){
        for(Double f: TopScores){
            if(score > f){
                TopScores.add(score);
                break;
            }

        }

    }
public void showAllTop(){
        for(Double f: TopScores){
            System.out.println("TopScore:" + f);
        }
}

}
