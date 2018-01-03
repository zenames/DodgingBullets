package com.mygdx.game.Characters;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.Collision.CollisionDetection;
import com.mygdx.game.Collision.HitBox;
import com.mygdx.game.GameState.GameStateManager;
import com.mygdx.game.GameState.PlayState;
import com.mygdx.game.Score.ScoreBoard;

import java.security.Key;

public class Alien extends Interactable{

//Texture texture = new Texture("ufo.png");
//Texture collisionTexture = new Texture("badlogic.jpg");
ScoreBoard scoreBoard;
GameStateManager gsm;
public Alien(){
    super.setPosition(500, 250);
    super.setTexture("ufo.png");
    super.addHitBox(new HitBox());
    super.getHitBox().hitBoxSetup(this);
    System.out.println(this.getHitBox().getHitboxArea());
}

public void move(){
    if (Gdx.input.isKeyPressed(Input.Keys.UP)){
        super.setPosition((int)super.getPosition().x , (int)super.getPosition().y+4);
    }
    if (Gdx.input.isKeyPressed(Input.Keys.DOWN)){
        super.setPosition((int)super.getPosition().x, (int)super.getPosition().y -4);
    }
    if (Gdx.input.isKeyPressed(Input.Keys.LEFT)){
        super.setPosition((int)super.getPosition().x -4, (int)super.getPosition().y);
    }
    if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
        super.setPosition((int)super.getPosition().x +4, (int)super.getPosition().y);
    }
   this.getHitBox().updatePosition();

}


    @Override
   public void Action() {

        System.out.println("hit");
scoreBoard.updateScore();


       gsm.setCurrentState("MenuState");


        setPosition(10000, 10000);
    }

    @Override
    public void noHit(){


    }
    public void getScoreBoard(ScoreBoard scoreBoard){
        this.scoreBoard = scoreBoard;
    }
public void setGsm(GameStateManager gsm){
        this.gsm = gsm;
}
}
