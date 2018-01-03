package com.mygdx.game.GameState;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Characters.Alien;
import com.mygdx.game.Projectiles.Bullets;
import com.mygdx.game.Projectiles.Levels;
import com.mygdx.game.Projectiles.LittleBullet;
import com.mygdx.game.Score.ScoreBoard;
import com.mygdx.game.Utility.WorldBox;
import com.mygdx.game.World.*;

import java.security.Key;
import java.util.Timer;

public class PlayState extends States{
   // worldLine line = new worldLine();
   // worldLine line2= new worldLine();
    float time;
    //worldhLine hline = new worldhLine();
    //worldhLine hline2 = new worldhLine();
private int score;

    private int count = 0;
    WorldBox worldBox = new WorldBox();
    LittleBullet[] littleBullet = new LittleBullet[300];
    Alien alien = new Alien();


    //Levels levels = new Levels();
    //Bullets bullets = new Bullets("");
    //Bullets bullets1 = new Bullets(("1"));
//Alien alien2 = new Alien();
    public PlayState(GameStateManager gsm, OrthographicCamera cam, ScoreBoard scoreBoard, SpriteBatch batch){
        super(gsm, cam, scoreBoard, batch);
        worldBox.getSide();
        createBullets();
    }
    public void createBullets(){
        for(int i = 0; i < 300; i ++){
            littleBullet[i] = new LittleBullet(worldBox);
            littleBullet[i].setPosition(-100, -100);
            littleBullet[i].getHitBox().updatePosition();
        }
    }
    public void create() {

        //line2.setPosition(745, 300);
       // line.setPosition(100, 300);
       // hline.setPosition(100, 280);
        //hline2.setPosition(100, 964);

       // hline.getHitBox().updatePosition();
       // hline2.getHitBox().updatePosition();
       // line2.getHitBox().updatePosition();
       // line.getHitBox().updatePosition();

        //alien2.setPosition(1000, 1000);
       // alien2.getHitBox().updatePosition();
        cam.setToOrtho(false, 1000, 500);
        cam.position.set(0, 0, 0);

        alien.getScoreBoard(scoreBoard);
        alien.setGsm(gsm);
    }
    public void render(){


        update();
scoreBoard.updateScore();

batch.setProjectionMatrix(cam.combined);
//        batch.setProjectionMatrix(cam.combined);
    time+= Gdx.graphics.getDeltaTime();
    score += Gdx.graphics.getDeltaTime() * 100;

        for(int i = 0; (i < count + 40)&& i< 300; i ++){
            littleBullet[i].shoot();
            batch.draw(littleBullet[i].getTexture(), littleBullet[i].getPosition().x, littleBullet[i].getPosition().y);
        }
        //bullets.move();
        //bullets1.move();
        alien.move();

        batch.draw(alien.getTexture(), alien.getPosition().x, alien.getPosition().y);
        scoreBoard.drawScoreBoard(batch);
        //batch.draw(line2.getTexture(), line2.getPosition().x, line2.getPosition().y);
       // batch.draw(line.getTexture(), line.gdetPosition().x, line.getPosition().y);
        //batch.draw(hline.getTexture(), hline.getPosition().x, hline.getPosition().y);
        //batch.draw(hline2.getTexture(), hline2.getPosition().x, hline2.getPosition().y);
       // batch.draw(bullets.getTexture(), bullets.getPosition().x, bullets.getPosition().y);
        //batch.draw(bullets1.getTexture(), bullets1.getPosition().x, bullets1.getPosition().y);
//batch.draw(alien2.getTexture(), 0, 0);
        if(time >= 3.0){
            count ++;
            System.out.println("leveling up");
            time = 0;
        }

        if(Gdx.input.isKeyPressed(Input.Keys.S)){
            System.out.println("changing state");
            System.out.println(gsm.getCurrentState());
            gsm.setCurrentState("MenuState");
            System.out.println(gsm.getCurrentState().getClass());

        }
    }
    public void update(){

    }
    public void reset(){
        alien.setPosition(500, 250);
        scoreBoard.resetScore();

        count = 0;

    }
    public void setBatch(SpriteBatch batch){
        this.batch = batch;
}}

