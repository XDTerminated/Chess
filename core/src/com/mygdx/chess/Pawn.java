package com.mygdx.chess;

public class Pawn extends MyActor {
    private boolean enPassant = false;

    public Pawn(String texture, int xPos, int yPos, String color, String position) {
        super(texture, xPos, yPos, color, position);
    }

    public String getName() {
        return "Pawn";
    }

    public boolean getEnPassant() {
        return this.enPassant;
    }

    public void setEnPassant(boolean enPassant) {
        this.enPassant = enPassant;
    }
    // Other Methods

}
