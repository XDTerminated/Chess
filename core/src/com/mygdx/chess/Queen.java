package com.mygdx.chess;

public class Queen extends MyActor {

    private int value = 9;

    public Queen(String texture, int xPos, int yPos, String color, String position) {
        super(texture, xPos, yPos, color, position);
    }

    // Accessors
    public int getValue() {
        return this.value;
    }

}
