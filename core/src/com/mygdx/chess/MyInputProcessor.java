package com.mygdx.chess;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.math.Vector2;

public class MyInputProcessor implements InputProcessor {


    private MyActor actor;

    public MyInputProcessor(MyActor actor) {
        this.actor = actor;
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

        actor.setxPos(Gdx.input.getX() - actor.texture.getWidth()/2);
        actor.setyPos(800 - Gdx.input.getY() - actor.texture.getHeight()/2);
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
