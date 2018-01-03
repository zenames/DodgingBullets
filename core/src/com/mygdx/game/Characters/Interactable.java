package com.mygdx.game.Characters;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.Collision.HitBox;
import com.mygdx.game.Score.ScoreBoard;

public abstract class Interactable {
    Vector3 position;
    HitBox hitBox;
    Texture texture;
public Interactable(){

}

public void noHit(){

}


public  void Action(){

};
public void addHitBox(HitBox hitBox){
    this.hitBox = hitBox;

}
public void setPosition(int x, int y){
    if (position == null){
        position = new Vector3(x, y, 0);

    }else{
        position.set(x, y, 0);
    }
}
public void setPosition(Vector3 vector3){
    position = vector3;
}

public Vector3 getPosition(){
    return position;
}
    public void setTexture(String textureURL){

        texture = new Texture(textureURL);


    }
    public void setTexture(Texture texture){
        this.texture = texture;
    }

    public Texture getTexture(){
        return texture;
    }

public HitBox getHitBox(){
        return hitBox;
}

}
