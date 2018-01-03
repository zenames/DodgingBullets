package com.mygdx.game.Utility;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.Characters.Interactable;
import com.mygdx.game.Collision.HitBox;
import com.mygdx.game.GameState.GameStateManager;

public class Menu extends Interactable{

    public Menu(){
        super.setPosition(350, 100);
        super.setTexture("menu.png");
        super.addHitBox(new HitBox());
        super.getHitBox().hitBoxSetup(this);

    }

}
