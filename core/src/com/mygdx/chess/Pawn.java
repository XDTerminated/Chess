package com.mygdx.chess;

public class Pawn extends MyActor {
    private boolean enPassant = false;
    private int counter = 0;

    public Pawn(String texture, int xPos, int yPos, String color, String position) {
        super(texture, xPos, yPos, color, position);
    }

    public String getName() {
        return "Pawn";
    }

    public boolean getEnPassant() {
        return this.enPassant;
    }

    public int getCounter() {
        return this.counter;
    }

    public void setEnPassant(boolean enPassant) {
        this.enPassant = enPassant;
    }

    // Other Methods

    public void increaseCounter() {
        counter++;
    }

}
