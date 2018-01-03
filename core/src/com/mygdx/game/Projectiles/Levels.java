package com.mygdx.game.Projectiles;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Utility.WorldBox;

import java.util.ArrayList;

public class Levels {
    int count = 0;
    WorldBox worldBox = new WorldBox();
    LittleBullet[][] littleBullets = new LittleBullet[100][3];

    public Levels(){
     for (int i = 0; i < 10; i ++){
         for(int y = 0; y < 3; y ++){
             littleBullets [i][y] = new LittleBullet(worldBox);

         }
     }


    }

    public void burst(SpriteBatch batch){
        for(int i = 0; i < 3; i ++){
            littleBullets[count][i].shoot();
            batch.draw(littleBullets[count][i].getTexture(), littleBullets[count][i].position.x, littleBullets[count][i].position.y);
        }
        if(System.currentTimeMillis() % 300 == 0){
            System.out.println(System.currentTimeMillis()+":current time");
            count++;
        }

    }


}
