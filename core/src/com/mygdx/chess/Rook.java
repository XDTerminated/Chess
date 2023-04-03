package com.mygdx.chess;

public class Rook extends MyActor {
    private int value = 5;
    public Rook(String texture, int xPos, int yPos, String color, String position) {
        super(texture, xPos, yPos, color, position);
    }

    // Accessors
    public int getValue() {
        return this.value;
    }
    public String getName() {
        return "Rook";
    }
}
