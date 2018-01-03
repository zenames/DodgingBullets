package com.mygdx.game.Collision;

import com.mygdx.game.Characters.Interactable;
import com.badlogic.gdx.math.Rectangle;

public class HitBox implements HitBoxFrame{
        private Interactable interactable;
        private Rectangle hitBoxArea = new Rectangle();
        private CollisionDetection collisionDetection = CollisionDetection.getInstance() ;

        public HitBox(){

            collisionDetection.addHitBox(this);
            System.out.println(this.hitBoxArea.x);
            System.out.println(this.hitBoxArea.y);
        }

    @Override
    public void hitBoxSetup(Interactable interactable) {
        this.interactable = interactable;
        try{

            hitBoxArea.set(interactable.getPosition().x, interactable.getPosition().y,
                    interactable.getTexture().getWidth(), interactable.getTexture().getHeight());
        }catch(NullPointerException positionNotSetup){
            System.out.println("didn't setup Position of interactable... " + interactable +
                    "setting up a default position of x: 0 , y: 0, z: 0 for the interactable assigned" );
            interactable.setPosition(0, 0);
        }
    }

    @Override
    public void setHitBoxPosition(float x, float y) {
        hitBoxArea.setPosition(x, y);
    }

    @Override
    public void setHitBoxSize(float h, float w) {
        hitBoxArea.setWidth(w);
        hitBoxArea.setHeight(h);
    }

    @Override
    public void updatePosition() {
        setHitBoxPosition(interactable.getPosition().x, interactable.getPosition().y);
    }

    public void checkCollision(HitBox hitBox){
        // System.out.println("checking");
        if (this.hitBoxArea.overlaps(hitBox.hitBoxArea)||hitBox.hitBoxArea.overlaps(this.hitBoxArea)){

            interactable.Action();

        }else{

            interactable.noHit();

        }


        //need to write a program to check collision. maybe not on this class though
    }

    public Rectangle getHitboxArea() {
        return hitBoxArea;
    }
public void setHitBoxArea(float x, float y, float width, float height){
        hitBoxArea.set(x, y , width, height);

}


}
