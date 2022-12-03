package com.mygdx.chess;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Pieces {

    // PawnsId: 0,1,2,3,4,5...7
    // Rook Id: 8, 15
    // Knight Id: 9, 14
    // Bishop Id: 10, 13
    // Queen Id: 11
    // King Id: 12

    Sprite piece;
    private String pieceName;
    private String color;
    private String piecePosition;
    private int pieceId;
    private int pieceValue;

    Pieces(Sprite piece, String pieceName, String color, String piecePosition, int pieceId, int pieceValue) {
        this.piece = piece;
        this.pieceName = pieceName;
        this.color = color;
        this.piecePosition = piecePosition;
        this.pieceId = pieceId;
        this.pieceValue = pieceValue;
    }

    public void pieceMovement(String[][] position, Pieces piece) {

    }

    // Getters
    public String getPieceName() {
        return this.pieceName;
    }

    public String getColor() {
        return this.color;
    }

    public String getPiecePosition() {
        return this.piecePosition;
    }

    public int getPieceId() {
        return this.pieceId;
    }

    public int getPieceValue() {
        return this.pieceValue;
    }

}
