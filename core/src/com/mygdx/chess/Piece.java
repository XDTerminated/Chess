package com.mygdx.chess;

import com.badlogic.gdx.Gdx;

public class Piece {

    // Variables
    private String PIECE_NAME;
    final private String PIECE_COLOR;
    private String boardPosition;
    private int xPos;
    private int yPos;
    private int PIECE_VALUE;
    private boolean taken = false;
    private MyActor PIECE;

    // Constructor
    Piece(String PIECE_NAME, String PIECE_COLOR, String boardPosition, int xPos, int yPos, int PIECE_VALUE, MyActor PIECE) {
        this.PIECE_NAME = PIECE_NAME;
        this.PIECE_COLOR = PIECE_COLOR;
        this.boardPosition = boardPosition;
        this.xPos = xPos;
        this.yPos = yPos;
        this.PIECE_VALUE = PIECE_VALUE;
        this.PIECE = PIECE;
    }

    // Movement
    public int[][] calculateMoves(int[][] position) {
        return position;
    }


    // Setters
    public void setPIECE_NAME(String PIECE_NAME) {
        this.PIECE_NAME = PIECE_NAME;
    }

    public void setBoardPosition(String boardPosition) {
        this.boardPosition = boardPosition;
    }

    public void setXPOS(int xPos) {
        this.xPos = xPos;
    }

    public void setYPOS(int yPos) {
        this.yPos = yPos;
    }

    public void setPIECE_VALUE(int PIECE_VALUE) {
        this.PIECE_VALUE = PIECE_VALUE;
    }

    public void setTaken(boolean taken) {
        this.taken = taken;
    }

    public void setPIECE(MyActor PIECE) {
        this.PIECE = PIECE;
    }

    // Getters
    public String getPIECE_NAME() {
        return this.PIECE_NAME;
    }

    public String getPIECE_COLOR() {
        return this.PIECE_COLOR;
    }

    public String getBoardPosition() {
        return this.boardPosition;
    }

    public int getXPOS() {
        return this.xPos;
    }

    public int getYPOS() {
        return this.yPos;
    }

    public int getPIECE_VALUE() {
        return this.PIECE_VALUE;
    }

    public boolean getTaken() {
        return this.taken;
    }

    public MyActor getPIECE() {
        return this.PIECE;
    }



}
