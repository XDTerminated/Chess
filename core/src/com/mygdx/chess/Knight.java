package com.mygdx.chess;

public class Knight extends MyActor {
    private int value = 3;
    public Knight(String texture, int xPos, int yPos, String color, String position) {
        super(texture, xPos, yPos, color, position);
    }

    // Accessors
    public int getValue() {
        return this.value;
    }

    // Other methods


}