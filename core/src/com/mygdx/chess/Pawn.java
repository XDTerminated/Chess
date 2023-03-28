package com.mygdx.chess;

import java.util.ArrayList;

public class Pawn extends MyActor {
    private int pieceValue = 1;
    private boolean hasMoved = false;
    private boolean canPromote = false;
    private String promoteTo = "";

    public Pawn(String texture, int xPos, int yPos, String color, String position) {
        super(texture, xPos, yPos, color, position);
    }

    // Accessors
    public boolean getHasMoved() {
        return this.hasMoved;
    }

    public boolean getCanPromote() {
        return this.canPromote;
    }

    public int getPieceValue() {
        return this.pieceValue;
    }

    // Mutators
    public void setHasMoved() {
        this.hasMoved = true;
    }

    public void setCanPromote(String promoteTo) {
        this.promoteTo = promoteTo;
    }

    // Other Methods

}
