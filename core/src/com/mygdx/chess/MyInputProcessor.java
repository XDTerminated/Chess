package com.mygdx.chess;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MyInputProcessor implements InputProcessor {


    private ArrayList<MyActor> actors;
    private MyActor touched;
    private boolean isDragging;
    private Stage stage;

    public MyInputProcessor(ArrayList<MyActor> actors, Stage stage) {
        this.actors = actors;
        this.stage = stage;
        touched = actors.get(0);

    }
    public boolean keyDown(int keycode) {
        // Handle a key press event
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {

        Vector2 stageCoordinates = stage.screenToStageCoordinates(new Vector2((float) screenX, (float) screenY));

        if (touched.getBounds().contains(stageCoordinates) || isDragging) {

            isDragging = true;
            return true;
        }
        return false;


    }


    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {

        isDragging = false;
        return true;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {


            if (isDragging) {
                touched.setxPos(Gdx.input.getX() - touched.texture().getWidth() / 2);
                touched.setyPos(800 - Gdx.input.getY() - touched.texture().getHeight() / 2);
                return true;

            }

            return false;

    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(float amountX, float amountY) {
        return false;
    }
}
