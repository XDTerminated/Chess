package com.mygdx.chess;

public class Bishop extends MyActor {
    private int value;

    public Bishop(String texture, int xPos, int yPos, String color, String position) {
        super(texture, xPos, yPos, color, position);
    }

    // Accessors
    public int getValue() {
        return this.value;
    }

}
