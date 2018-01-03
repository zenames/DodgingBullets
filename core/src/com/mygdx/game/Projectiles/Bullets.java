package com.mygdx.game.Projectiles;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.Characters.*;
import com.mygdx.game.Collision.HitBox;
import com.mygdx.game.Utility.*;
public class Bullets extends Interactable {
    int [] linePath;




private int x = 0;
private int y = 1;
private int xCoord;
private int yCoord;
    public Bullets(String s){
        linePath= ArrayCreator.getTrajectory("C:\\Users\\user\\Desktop\\GameOne\\LinePathing"+s+ ".txt");
        xCoord =linePath[x];
        yCoord= linePath[y];
        super.setPosition(xCoord, yCoord);
        super.setTexture("dodgeball.png");

        super.addHitBox(new HitBox());
        super.getHitBox().hitBoxSetup(this);


    }


public void move(){


    x+= 2;
    y+=2;
    if(x == linePath.length||y == linePath.length){
        x = 0;
        y  = 1;
    }

    super.setPosition(xCoord, yCoord);
    //System.out.println(xCoord+ " " + yCoord + " ");
    xCoord = linePath[x]- 50;
    yCoord = linePath[y]- 50;

    this.getHitBox().updatePosition();
    }





}
