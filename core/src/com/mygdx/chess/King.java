package com.mygdx.chess;

public class King extends MyActor {

    private int value = Integer.MAX_VALUE;

    public King(String texture, int xPos, int yPos, String color, String position) {
        super(texture, xPos, yPos, color, position);
    }

    // Accessors
    public int getValue() {
        return this.value;
    }
}
