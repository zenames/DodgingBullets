package com.mygdx.game.GameState;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.GameState.GameStateManager;
import com.mygdx.game.Score.ScoreBoard;

public abstract class States {
    OrthographicCamera cam;
    SpriteBatch batch;
    GameStateManager gsm;
    ScoreBoard scoreBoard;

    public States(GameStateManager gsm, OrthographicCamera cam, ScoreBoard scoreBoard, SpriteBatch batch){
this.gsm = gsm;
this.cam = cam;
this.batch = batch;
this.scoreBoard = scoreBoard;
    }
    public void create(){

    }
    public void render(){

    }
    public void update(){

    }
    abstract void reset();
    public void setBatch(SpriteBatch batch){
        this.batch = batch;
    };
}
