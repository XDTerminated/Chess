package com.mygdx.chess;

public class Queen extends MyActor {

    public Queen(String texture, int xPos, int yPos, String color, String position) {
        super(texture, xPos, yPos, color, position);
    }

    public String getName() {
        return "Queen";
    }

}
