package com.mygdx.game.GameState;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.FirstSeriousGame;
import com.mygdx.game.Score.ScoreBoard;

import javax.swing.plaf.nimbus.State;
import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

public class GameStateManager {

    SpriteBatch batch;
    OrthographicCamera cam;
    States currentState;
    ScoreBoard scoreBoard;
    private  GameStateManager(){
        cam = new OrthographicCamera();
        scoreBoard = new ScoreBoard();
        setup();
        currentState = allStates.get("com.mygdx.game.GameState.PlayState");



    }
HashMap<String, States> allStates = new HashMap<>();





    private static GameStateManager ourInstance = new GameStateManager();

private void setup(){
    String readState = null;
    BufferedReader createStates;
batch = FirstSeriousGame.getBatch();
    try{
        createStates = new BufferedReader(new FileReader("C:\\Users\\user\\Desktop\\GameOne\\core\\src\\com\\mygdx\\game\\GameState\\GameStates"));

        while((readState = createStates.readLine())!= null){
            readState = "com.mygdx.game.GameState."+ readState;
            Class createState = Class.forName(readState);
            Constructor finale = createState.getConstructor(new Class[]{GameStateManager.class, OrthographicCamera.class, ScoreBoard.class, SpriteBatch.class});

            allStates.put(readState,(States)finale.newInstance(this, cam, this.scoreBoard, batch));
            System.out.println("this is scoreboard: " +scoreBoard);
            System.out.println(readState+ " created");
        }
    }catch (FileNotFoundException a){
        a.printStackTrace();
    }catch (IOException d){
        d.printStackTrace();
    }catch (IllegalAccessException a){
        a.printStackTrace();
    }catch(InstantiationException instanc){
        instanc.printStackTrace();

    }catch(ClassNotFoundException classNotfound){
        System.out.println("class not found exception");

    }catch(NoSuchMethodException nsm){
        nsm.printStackTrace();
    }catch (InvocationTargetException ite){
        ite.printStackTrace();
    }

}


    public static GameStateManager getInstance() {
        return ourInstance;
    }


    public void store(String stateName, States state){
        allStates.put(stateName, state);
    }

    public void setCurrentState(String state){

        currentState = allStates.get("com.mygdx.game.GameState." + state);
        //currentState.setBatch(batch);

    }
    public States getCurrentState(){
        return currentState;
    }

public void setBatch(SpriteBatch batch){
        this.batch = batch;
}
public States getState(String state){
    return allStates.get("com.mygdx.game.GameState."+state);
}

    public OrthographicCamera getCam() {
        return cam;
    }
    public HashMap<String, States> getAllStates(){
    return allStates;}

    }

