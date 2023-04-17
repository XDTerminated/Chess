package com.mygdx.chess;

public class King extends MyActor {

    public King(String texture, int xPos, int yPos, String color, String position) {
        super(texture, xPos, yPos, color, position);
    }

    public String getName() {
        return "King";
    }
}
