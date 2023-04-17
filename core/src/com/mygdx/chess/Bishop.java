package com.mygdx.chess;

public class Bishop extends MyActor {

    public Bishop(String texture, int xPos, int yPos, String color, String position) {
        super(texture, xPos, yPos, color, position);
    }

    public String getName() {
        return "Bishop";
    }

}
