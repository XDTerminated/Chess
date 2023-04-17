package com.mygdx.chess;

public class Rook extends MyActor {
    public Rook(String texture, int xPos, int yPos, String color, String position) {
        super(texture, xPos, yPos, color, position);
    }

    public String getName() {
        return "Rook";
    }
}
