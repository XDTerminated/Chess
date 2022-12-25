package com.mygdx.chess;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;
import java.util.ArrayList;

public class MyInputProcessor implements InputProcessor {


    private ArrayList<MyActor> actors;
    private MyActor touched;
    private boolean isDragging = false;
    final private Stage stage;

    public MyInputProcessor(ArrayList<MyActor> actors, Stage stage) {
        this.actors = actors;
        this.stage = stage;

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

        for (MyActor a: actors){
            if ((a.getBounds().getX() <= stageCoordinates.x && a.getBounds().getWidth() >= stageCoordinates.x && a.getBounds().getY() <= stageCoordinates.y && a.getBounds().getHeight() >= stageCoordinates.y) || isDragging) {

                touched = a;
                touched.toFront();
                isDragging = true;
                return true;
            }
        }

        return false;


    }


    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {

        isDragging = false;
        touched.setxPos(Math.round((int) (Math.round(touched.getXPOS() / 100.0) * 100)));
        touched.setyPos(Math.round((int) (Math.round(touched.getYPOS() / 100.0) * 100)));

        for (int i = 0; i < actors.toArray().length; i++) {
            if (touched.getXPOS() == actors.get(i).getXPOS() && touched.getYPOS() == actors.get(i).getYPOS()) {
                if (!actors.get(i).equals(touched)) {
                    actors.get(i).remove();
                    actors.remove(i);
                    break;
                }

            }
        }

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
