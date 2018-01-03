package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Collision.CollisionDetection;
import com.mygdx.game.GameState.GameStateManager;
import com.mygdx.game.GameState.States;

public class FirstSeriousGame extends ApplicationAdapter {
	private  static SpriteBatch batch;
	Texture img;
CollisionDetection collisionDetection;
	States currentGameState;
	GameStateManager gsm;
	@Override
	public void create () {
		collisionDetection = CollisionDetection.getInstance();
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");

		gsm = GameStateManager.getInstance();
		gsm.setBatch(batch);
		currentGameState = gsm.getCurrentState();
		//currentGameState.setBatch(batch);

		currentGameState.create();
		gsm.setCurrentState("PlayState");

	}

	@Override
	public void render () {

		currentGameState = gsm.getCurrentState();
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		collisionDetection.check();

		batch.begin();

		currentGameState.render();
		batch.end();

	}
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}

	public static SpriteBatch getBatch(){
		return batch;
	}
}
