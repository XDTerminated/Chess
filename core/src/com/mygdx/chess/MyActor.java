package com.mygdx.chess;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class MyActor extends Actor {
    private Texture texture;
    private Sprite sprite;
    private int xPos;
    private int yPos;

    MyActor(String texture, int xPos, int yPos) {
        this.texture = new Texture(Gdx.files.internal(texture));
        this.sprite = new Sprite(this.texture);

        this.xPos = xPos;
        this.yPos = yPos;
    }

    @Override
    public void draw(Batch batch, float alphaParent) {
        batch.draw(sprite, xPos, yPos, 100, 100);
    }

    public Rectangle getBounds() {
        float x = xPos;
        float y = yPos;
        float width = getWidth();
        float height = getHeight();
        return new Rectangle(x, y, width + xPos, height + yPos);
    }

    public int getXPOS() {
        return this.xPos;
    }

    public int getYPOS() {
        return this.yPos;
    }

    public Texture texture() {
        return this.texture;
    }

    public void setxPos(int xPos) {
        this.xPos = xPos;
    }

    public void setyPos(int yPos) {
        this.yPos = yPos;
    }


}
