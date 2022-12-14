package com.mygdx.chess;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;
import java.util.ArrayList;
import com.badlogic.gdx.audio.Sound;

public class MyInputProcessor implements InputProcessor {

    // Creates variables
    private ArrayList<MyActor> actors;
    private MyActor touched = new MyActor();
    private boolean isDragging = false;
    final private Stage stage;
    private int touchedIndexX;
    private int touchedIndexY;
    Sound move = Gdx.audio.newSound(Gdx.files.internal("move.mp3"));

    // Constructor
    public MyInputProcessor(ArrayList<MyActor> actors, Stage stage) {
        this.actors = actors;
        this.stage = stage;
    }

    // Override Functions
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


        for (MyActor a : actors) {
            if ((a.getBounds().getX() <= stageCoordinates.x && a.getBounds().getWidth() >= stageCoordinates.x && a.getBounds().getY() <= stageCoordinates.y && a.getBounds().getHeight() >= stageCoordinates.y) || isDragging) {

                touched = a;
                touched.toFront();

                if (!isDragging) {
                    touchedIndexX = (int) (touched.getYPOS() / 100);
                    touchedIndexY = (int) (touched.getXPOS() / 100);
                }

                isDragging = true;

                return true;

            } else {
                isDragging = false;
            }

        }

        return false;


    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {

        if (isDragging == false) {
            touchedIndexX = 1000;
            touchedIndexY = 1000;
        }

        if (!(touchedIndexX == 1000)) {
            move.play();
        }

        touched.setxPos(Math.round((int) (Math.round(touched.getXPOS() / 100.0) * 100)));
        touched.setyPos(Math.round((int) (Math.round(touched.getYPOS() / 100.0) * 100)));


        touched.setHasMoved(true);

        for (int i = 0; i < actors.toArray().length; i++) {
            if (touched.getXPOS() == actors.get(i).getXPOS() && touched.getYPOS() == actors.get(i).getYPOS()) {
                if (!actors.get(i).equals(touched)) {
                    actors.get(i).remove();
                    actors.remove(i);
                    break;
                }

            }
        }

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
