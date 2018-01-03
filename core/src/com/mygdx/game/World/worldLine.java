package com.mygdx.game.World;
 import com.mygdx.game.*;
 import com.mygdx.game.Characters.Interactable;
 import com.mygdx.game.Collision.HitBox;

public class worldLine extends Interactable{
    public worldLine(){

        super.addHitBox(new HitBox());
        super.setPosition(0, 0);
        super.setTexture("Line.png");
        super.getHitBox().hitBoxSetup(this);
        System.out.println(this.getHitBox().getHitboxArea());
    }

    @Override
    public void Action() {



        System.out.println("line hit");

    }

}
