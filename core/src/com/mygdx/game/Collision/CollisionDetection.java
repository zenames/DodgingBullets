package com.mygdx.game.Collision;

import java.util.ArrayList;

public class CollisionDetection {
    private static CollisionDetection ourInstance = new CollisionDetection();




    public static CollisionDetection getInstance() {
        return ourInstance;
    }


    ArrayList<HitBox> hitBoxChecker = new ArrayList<HitBox>();






    private CollisionDetection() {
    }



    public void check(){

        for (int i = 0; i < hitBoxChecker.size(); i ++){
            HitBox currentCheck = hitBoxChecker.get(i);
            for (int j = i+1; j< hitBoxChecker.size(); j ++){

                currentCheck.checkCollision(hitBoxChecker.get(j));
                hitBoxChecker.get(j).checkCollision(hitBoxChecker.get(i));

            }
            if (i == hitBoxChecker.size())
                i = 0;
        }
    }

    public void addHitBox(HitBox hitBox){
        hitBoxChecker.add(hitBox);
    }

public int checkSize(){
        return hitBoxChecker.size();
}


}
