package com.mygdx.game.Collision;
import com.mygdx.game.Characters.*;
public interface HitBoxFrame {
    void hitBoxSetup(Interactable interactable);
    void setHitBoxPosition(float x, float y);
    void setHitBoxSize(float h, float w);
    void updatePosition();
}
