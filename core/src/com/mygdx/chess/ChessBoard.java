package com.mygdx.chess;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.utils.ScreenUtils;

public class ChessBoard {

    // Variables
    private static MyActor[] whitePieces = new MyActor[16];
    private static MyActor[] blackPieces = new MyActor[16];
    private static MyActor[][] chessBoard = new MyActor[8][8];
    private static String turn = "White";


    static ShapeRenderer shapeRenderer = new ShapeRenderer();

    // Creates Chess Board
    public static void createChessBoard() {
        final Color WHITE = new Color(0x9c9c9c);
        final Color BLACK = new Color(0x595959);
        ScreenUtils.clear(252, 252, 252, 252);
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 16; j++) {
                shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
                if ((j + i) % 2 == 1) {
                    shapeRenderer.setColor(WHITE);
                } else {
                    shapeRenderer.setColor(BLACK);
                }

                shapeRenderer.rect(j * 100, i * 100, 100, 100);
                shapeRenderer.end();
            }
        }
    }

    public static void createPieces() {
        // White Pawns
        MyActor wPawn1 = new Pawn("wPawn.png", 0, 100, "W", "a2");
        MyActor wPawn2 = new Pawn("wPawn.png", 100, 100, "W", "b2");
        MyActor wPawn3 = new Pawn("wPawn.png", 200, 100, "W", "c2");
        MyActor wPawn4 = new Pawn("wPawn.png", 300, 100, "W", "d2");
        MyActor wPawn5 = new Pawn("wPawn.png", 400, 100, "W", "e2");
        MyActor wPawn6 = new Pawn("wPawn.png", 500, 100, "W", "f2");
        MyActor wPawn7 = new Pawn("wPawn.png", 600, 100, "W", "g2");
        MyActor wPawn8 = new Pawn("wPawn.png", 700, 100, "W", "h2");
        // Black Pawns
        MyActor bPawn1 = new Pawn("wPawn.png", 0, 600, "B", "a7");
        MyActor bPawn2 = new Pawn("wPawn.png", 100, 600, "B", "b7");
        MyActor bPawn3 = new Pawn("wPawn.png", 200, 600, "B", "c7");
        MyActor bPawn4 = new Pawn("wPawn.png", 300, 600, "B", "d7");
        MyActor bPawn5 = new Pawn("wPawn.png", 400, 600, "B", "e7");
        MyActor bPawn6 = new Pawn("wPawn.png", 500, 600, "B", "f7");
        MyActor bPawn7 = new Pawn("wPawn.png", 600, 600, "B", "g7");
        MyActor bPawn8 = new Pawn("wPawn.png", 700, 600, "B", "h7");
        // White Pieces
        MyActor wRook1 = new Rook("wRook.png", 0, 0, "W", "a1");
        MyActor wRook2 = new Rook("wRook.png", 0, 700, "W", "h1");

        MyActor wBishop1 = new Bishop("wBishop.png", 0, 200, "W", "c1");
        MyActor wBishop2 = new Bishop("wBishop.png", 0, 500, "W", "f1");

        MyActor wKnight1 = new Knight("wKnight.png", 0, 100, "W", "b1");
        MyActor wKnight2 = new Knight("wKnight.png", 0, 600, "W", "g1");

        MyActor wQueen = new Queen("wQueen.png", 0, 300, "W", "d1");
        MyActor wKing = new King("wKing.png", 0, 400, "W", "e1");
        // Black Pieces
        MyActor bRook1 = new Rook("bRook.png", 0, 700, "B", "a8");
        MyActor bRook2 = new Rook("bRook.png", 700, 700, "B", "h8");

        MyActor bBishop1 = new Bishop("bBishop.png", 200, 700, "B", "c8");
        MyActor bBishop2 = new Bishop("bBishop.png", 500, 700, "B", "f8");

        MyActor bKnight1 = new Knight("bKnight.png", 100, 700, "B", "b8");
        MyActor bKnight2 = new Knight("bKnight.png", 600, 700, "B", "g8");

        MyActor bQueen = new Queen("bQueen.png", 300, 700, "B", "d8");
        MyActor bKing = new King("bKing.png", 400, 700, "B", "e8");

        // Store white pieces in array
        whitePieces[0] = wPawn1; whitePieces[1] = wPawn2; whitePieces[2] = wPawn3; whitePieces[3] = wPawn4; whitePieces[4] = wPawn5; whitePieces[5] = wPawn6; whitePieces[6] = wPawn7; whitePieces[7] = wPawn8;
        whitePieces[8] = wRook1; whitePieces[9] = wKnight1; whitePieces[10] = wBishop1; whitePieces[11] = wQueen; whitePieces[12] = wKing; whitePieces[13] = wBishop2; whitePieces[14] = wKnight2; whitePieces[15] = wRook2;
        // Store white pieces on chess board
        chessBoard[1][0] = wPawn1; chessBoard[1][1] = wPawn2; chessBoard[1][2] = wPawn3; chessBoard[1][3] = wPawn4; chessBoard[1][4] = wPawn5; chessBoard[1][5] = wPawn6; chessBoard[1][6] = wPawn7; chessBoard[1][7] = wPawn8;
        chessBoard[0][0] = wRook1; chessBoard[0][1] = wKnight1; chessBoard[0][2] = wBishop1; chessBoard[0][3] = wQueen; chessBoard[0][4] = wKing; chessBoard[0][5] = wBishop2; chessBoard[0][6] = wKnight2; chessBoard[0][7] = wRook2;

        // Store black pieces in array
        blackPieces[0] = bPawn1; blackPieces[1] = bPawn2; blackPieces[2] = bPawn3; blackPieces[3] = bPawn4; blackPieces[4] = bPawn5; blackPieces[5] = bPawn6; blackPieces[6] = bPawn7; blackPieces[7] = bPawn8;
        blackPieces[8] = bRook1; blackPieces[9] = bKnight1; blackPieces[10] = bBishop1; blackPieces[11] = bQueen; blackPieces[12] = bKing; blackPieces[13] = bBishop2; blackPieces[14] = bKnight2; blackPieces[15] = bRook2;

        // Store black pieces in chessboard
        chessBoard[6][0] = bPawn1; chessBoard[6][1] = bPawn2; chessBoard[6][2] = bPawn3; chessBoard[6][3] = bPawn4; chessBoard[6][4] = bPawn5; chessBoard[6][5] = bPawn6; chessBoard[6][6] = bPawn7; chessBoard[6][7] = bPawn8;
        chessBoard[7][0] = bRook1; chessBoard[7][1] = bKnight1; chessBoard[7][2] = bBishop1; chessBoard[7][3] = bQueen; chessBoard[7][4] = bKing; chessBoard[7][5] = bBishop2; chessBoard[7][6] = bKnight2; chessBoard[7][7] = bRook1;


        for (MyActor a: whitePieces) {
            a.setBounds(0, 0, a.texture().getWidth(), a.texture().getHeight());
            a.setTouchable(Touchable.enabled);
        }


        for (MyActor a: blackPieces) {
            a.setBounds(0, 0, a.texture().getWidth(), a.texture().getHeight());
            a.setTouchable(Touchable.enabled);
        }
    }

    // Accessors
    public static MyActor[] getWhitePieces() {
        return whitePieces;
    }

    public static MyActor[] getBlackPieces() {
        return blackPieces;
    }

    public static String getTurn() {
        return turn;
    }

    public static MyActor[][] getChessBoard() {
        return chessBoard;
    }

    // Modifiers
    public static void setTurn(String t) {
        turn = t;
    }
}
