package com.mygdx.game.Projectiles;

import com.badlogic.gdx.math.Vector;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.Characters.Interactable;
import com.mygdx.game.Collision.HitBox;
import com.mygdx.game.Utility.WorldBox;

public class LittleBullet extends Interactable{
WorldBox worldBox;
Vector3 position;
private static int count = 0;
private int incrementX;
private int incrementY;
private int speed = 4;
    public LittleBullet(WorldBox worldBox){
        this.worldBox = worldBox;
        super.addHitBox(new HitBox());
        position = worldBox.getSide();
        super.setPosition((int)( position).x, (int)(position).y);
        super.setTexture("dots.png");
        super.getHitBox().hitBoxSetup(this);
        getHitBox().setHitBoxArea(5, 0, 17,21 );
giveRandomSpeed();


    }
    public void shoot(){

        super.setPosition((int)super.getPosition().x, (int)super.getPosition().y);
        super.getPosition().x += incrementX;
        super.getPosition().y += incrementY;
        super.getHitBox().updatePosition();
        if(super.getPosition().x > 1100 || super.getPosition().y > 600 || super.getPosition().x < - 100|| super.getPosition().y < -100){
            //setPosition((int)position.x, (int) position.y);
            worldBox.getSideNoNew(this);
            giveRandomSpeed();


this.getHitBox().updatePosition();
        }

    }
    @Override
public void Action(){



    }

    private void giveRandomSpeed(){



        if ((int)super.getPosition().x ==0){
            incrementX = (int)(Math.random()* speed) + 1;
            incrementY = (int)(Math.random()* speed *2) -speed;



        }else if((int)super.getPosition().y == 0){
            incrementX =(int)(Math.random()* speed *2) -speed;
            incrementY = (int)(Math.random()* speed)+ 1;
        }else if( super.getPosition().x == 1000){
            incrementX =(int)(-Math.random()* speed);
            incrementY = (int)((Math.random()* speed *2) -speed);
        }else if(super.getPosition().y == 500){
            incrementX =(int)(Math.random()* speed *2) -speed;
            incrementY = (int)(-Math.random()* speed);
        }
    }

    @Override
    public void setPosition(int x, int y) {
        super.getPosition().set(x, y, 0);
    }
    public int getIncrementX(){
        return incrementX;
    }
    public int getIncrementY(){
        return incrementY;
    }

}
