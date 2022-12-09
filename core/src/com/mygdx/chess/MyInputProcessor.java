package com.mygdx.chess;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.math.Vector2;

public class MyInputProcessor implements InputProcessor {


    private MyActor actor;

    // Store the initial position of the actor and touch event
    private Vector2 initialActorPosition;
    private Vector2 initialTouchPosition = new Vector2(Gdx.input.getX(), Gdx.input.getY());

    public MyInputProcessor(MyActor actor) {
        this.actor = actor;
        initialActorPosition = new Vector2(actor.getXPOS(), actor.getYPOS());
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
//        System.out.println("Hello");
        return false;

    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
//        System.out.println("Hello");
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        System.out.println("Hello");
        actor.setPosition(
                initialActorPosition.x + screenX - initialTouchPosition.x,
                initialActorPosition.y + screenY - initialTouchPosition.y
        );
        return true;
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
