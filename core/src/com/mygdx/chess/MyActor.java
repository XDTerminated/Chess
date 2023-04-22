package com.mygdx.chess;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
public class MyActor extends Actor {

    // Creates Variables
    private boolean hasMoved = false;
    private final Texture texture;
    private final Sprite sprite;
    private int xPos;
    private int yPos;
    private final String color;
    String position;
    // Constructor
    MyActor(String texture, int xPos, int yPos, String color, String position) {
        this.texture = new Texture(Gdx.files.internal(texture));
        this.sprite = new Sprite(this.texture);

        this.xPos = xPos;
        this.yPos = yPos;
        this.color = color;

        this.position = position;
    }


    // Override Functions
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


    // Getters
    public int getXPOS() {
        return this.xPos;
    }

    public int getYPOS() {
        return this.yPos;
    }

    public String color() {
        return this.color;
    }

    public Texture texture() {
        return this.texture;
    }

    public String getPosition() {
        return this.position;
    }

    public boolean getHasMoved() {
        return this.hasMoved;
    }

    // Setters
    public void setXPos(int xPos) {
        this.xPos = xPos;
    }

    public void setYPos(int yPos) {
        this.yPos = yPos;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setHasMoved() {
        this.hasMoved = true;
    }

    // Other methods - Overridden methods in other classes
    public void setEnPassant(boolean enPassant) {

    }

    public boolean getEnPassant() {
        return false;
    }

    public void increaseCounter() {

    }

    public int getCounter() {
        return -1;
    }
}
