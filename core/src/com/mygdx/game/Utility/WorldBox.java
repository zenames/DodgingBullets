package com.mygdx.game.Utility;

import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.Characters.Interactable;
import com.mygdx.game.Projectiles.LittleBullet;

import java.awt.*;

public class WorldBox extends Interactable{

    private Vector3 bulletTracjectory;
    private LittleBullet littleBullet;
    private Rectangle gunning = new Rectangle(1500, 1000);
    public WorldBox(){
        this.littleBullet = littleBullet;
    }

    public void Action(){

    }

public Vector3 getSide(){
        switch ((int)(Math.random()* 4)+ 1){
            case 1:
            return new Vector3(0, (int)(Math.random()* 500), 0);

            case 2:
                return new Vector3((int)(Math.random()* 1000), 0, 0);

            case 3:
                return new Vector3(1000,(int)(Math.random()* 500 ), 0 );

            case 4:
                return new Vector3((int)(Math.random()* 1000), 500, 0);

            default: throw new RuntimeException("something is wrong in the WorldBox class");

        }

}

    public Rectangle getBoundaries() {
        return gunning;
    }

    public void getSideNoNew(LittleBullet littleBullet){

        switch ((int)(Math.random()* 4)+ 1){
            case 1:
                littleBullet.setPosition(0, (int)(Math.random()* 500));
break;
            case 2:
                littleBullet.setPosition((int)(Math.random()* 1000), 0);
                break;
            case 3:
                littleBullet.setPosition(1000,(int)(Math.random()* 500 ));
                break;
            case 4:
                littleBullet.setPosition((int)(Math.random()* 1000), 500);
                break;
            default: throw new RuntimeException("something is wrong in the WorldBox class");

        }
    }
}
