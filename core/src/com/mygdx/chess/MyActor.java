package com.mygdx.chess;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class MyActor extends Actor {
    Texture texture;
    Sprite sprite;
    int xPos;
    int yPos;

    MyActor(String texture, int xPos, int yPos) {
        this.texture = new Texture(texture);
        this.sprite = new Sprite(new Texture(texture));
        this.xPos = xPos;
        this.yPos = yPos;
    }

    @Override
    public void draw(Batch batch, float alphaParent) {
        batch.draw(sprite, xPos, yPos, 100, 100);
    }

    public int getXPOS() {
        return this.xPos;
    }

    public int getYPOS() {
        return this.yPos;
    }

}
