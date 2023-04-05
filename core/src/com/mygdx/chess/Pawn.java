package com.mygdx.chess;

import java.util.ArrayList;

public class Pawn extends MyActor {
    private int pieceValue = 1;
    private boolean canPromote = false;
    private String promoteTo = "";
    private boolean enPassant = false;

    public Pawn(String texture, int xPos, int yPos, String color, String position) {
        super(texture, xPos, yPos, color, position);
    }

    // Accessors
    public boolean getCanPromote() {
        return this.canPromote;
    }

    public String getName() {
        return "Pawn";
    }

    public int getPieceValue() {
        return this.pieceValue;
    }
    public boolean getEnPassant() {
        return this.enPassant;
    }

    // Mutators
    public void setCanPromote(String promoteTo) {
        this.promoteTo = promoteTo;
    }
    public void setEnPassant(boolean enPassant) {
        this.enPassant = enPassant;
    }
    // Other Methods

}
