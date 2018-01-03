package com.mygdx.game.GameState;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Score.ScoreBoard;

public class MenuState extends States {


    public MenuState(GameStateManager gsm, OrthographicCamera cam, ScoreBoard scoreBoard, SpriteBatch batch){
        super(gsm, cam, scoreBoard, batch);

    }

    public void create(){

    }
public void render(){
    if(Gdx.input.isKeyPressed(Input.Keys.D)){
        System.out.println("changing state");
        System.out.println(gsm.getCurrentState());
        System.out.println("gsm getting reset state of playsatesfdsdfsdfsdf"+ gsm.getState("PlayState"));
        gsm.getState("PlayState").reset();
        gsm.setCurrentState("PlayState");



    }

    scoreBoard.drawHighScores(batch);
        }
public void update(){

        }

    @Override
    void reset() {

    }

    public void setBatch(SpriteBatch batch){
        this.batch = batch;
        }


        }

