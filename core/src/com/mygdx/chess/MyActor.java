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
    private String piece;
    private String color;
    private String chessPosition;

    // Constructor
    MyActor(String texture, int xPos, int yPos, String piece, String color, String chessPosition) {
        this.texture = new Texture(Gdx.files.internal(texture));
        this.sprite = new Sprite(this.texture);

        this.xPos = xPos;
        this.yPos = yPos;
        this.piece = piece;
        this.color = color;
        this.chessPosition = chessPosition;
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

    public String getPiece() {
        return this.piece;
    }

    public String getChessPosition() {
        return this.chessPosition;
    }

    public Texture texture() {
        return this.texture;
    }

    // Setters

    public void setxPos(int xPos) {
        this.xPos = xPos;
    }

    public void setyPos(int yPos) {
        this.yPos = yPos;
    }

    public void setChessPosition(String chessPosition) {
        this.chessPosition = chessPosition;
    }

    public void setPiece(String piece, Texture texture) {
        this.piece = piece;
        this.texture = texture;

        sprite.setTexture(this.texture);
    }
}
