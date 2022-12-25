package com.mygdx.chess;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.utils.ScreenUtils;

import java.util.ArrayList;


public class ChessBoard {

    // Variables
    private static int[][] chessBoard = new int[8][8];
    private static ArrayList<MyActor> pieces = new ArrayList<MyActor>();
    private static ArrayList<MyActor> whitePieces = new ArrayList<>();
    private static ArrayList<MyActor> darkPieces = new ArrayList<>();


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

    // Creates Pieces
    public static void createPieces() {
        // White Pieces
        MyActor wPawn1 = new MyActor("/Users/sgupta11/Desktop/Chess/Assets/wPawn.png", 0, 100, "Pawn", "White", "A2");
        wPawn1.setBounds(0, 0, wPawn1.texture().getWidth(), wPawn1.texture().getHeight());
        wPawn1.setTouchable(Touchable.enabled);

        MyActor wPawn2 = new MyActor("/Users/sgupta11/Desktop/Chess/Assets/wPawn.png", 100, 100, "Pawn", "White", "B2");
        wPawn2.setBounds(0, 0, wPawn2.texture().getWidth(), wPawn2.texture().getHeight());
        wPawn2.setTouchable(Touchable.enabled);

        MyActor wPawn3 = new MyActor("/Users/sgupta11/Desktop/Chess/Assets/wPawn.png", 200, 100, "Pawn", "White", "C2");
        wPawn3.setBounds(0, 0, wPawn3.texture().getWidth(), wPawn3.texture().getHeight());
        wPawn3.setTouchable(Touchable.enabled);

        MyActor wPawn4 = new MyActor("/Users/sgupta11/Desktop/Chess/Assets/wPawn.png", 300, 100, "Pawn", "White", "D2");
        wPawn4.setBounds(0, 0, wPawn4.texture().getWidth(), wPawn4.texture().getHeight());
        wPawn4.setTouchable(Touchable.enabled);

        MyActor wPawn5 = new MyActor("/Users/sgupta11/Desktop/Chess/Assets/wPawn.png", 400, 100, "Pawn", "White", "E2");
        wPawn5.setBounds(0, 0, wPawn5.texture().getWidth(), wPawn5.texture().getHeight());
        wPawn5.setTouchable(Touchable.enabled);

        MyActor wPawn6 = new MyActor("/Users/sgupta11/Desktop/Chess/Assets/wPawn.png", 500, 100, "Pawn", "White", "F2");
        wPawn6.setBounds(0, 0, wPawn6.texture().getWidth(), wPawn6.texture().getHeight());
        wPawn6.setTouchable(Touchable.enabled);

        MyActor wPawn7 = new MyActor("/Users/sgupta11/Desktop/Chess/Assets/wPawn.png", 600, 100, "Pawn", "White", "G2");
        wPawn7.setBounds(0, 0, wPawn7.texture().getWidth(), wPawn7.texture().getHeight());
        wPawn7.setTouchable(Touchable.enabled);

        MyActor wPawn8 = new MyActor("/Users/sgupta11/Desktop/Chess/Assets/wPawn.png", 700, 100, "Pawn", "White", "H2");
        wPawn8.setBounds(0, 0, wPawn8.texture().getWidth(), wPawn8.texture().getHeight());
        wPawn8.setTouchable(Touchable.enabled);

        MyActor wRook1 = new MyActor("/Users/sgupta11/Desktop/Chess/Assets/wRook.png", 0, 0, "Rook", "White", "A1");
        wRook1.setBounds(0, 0, wRook1.texture().getWidth(), wRook1.texture().getHeight());
        wRook1.setTouchable(Touchable.enabled);

        MyActor wRook2 = new MyActor("/Users/sgupta11/Desktop/Chess/Assets/wRook.png", 700, 0, "Rook", "White", "H1");
        wRook2.setBounds(0, 0, wRook2.texture().getWidth(), wRook2.texture().getHeight());
        wRook2.setTouchable(Touchable.enabled);

        MyActor wKnight1 = new MyActor("/Users/sgupta11/Desktop/Chess/Assets/wKnight.png", 100, 0, "Knight", "White", "B1");
        wKnight1.setBounds(0, 0, wKnight1.texture().getWidth(), wKnight1.texture().getHeight());
        wKnight1.setTouchable(Touchable.enabled);

        MyActor wKnight2 = new MyActor("/Users/sgupta11/Desktop/Chess/Assets/wKnight.png", 600, 0, "Knight", "White", "G1");
        wKnight2.setBounds(0, 0, wKnight2.texture().getWidth(), wKnight2.texture().getHeight());
        wKnight2.setTouchable(Touchable.enabled);

        MyActor wBishop1 = new MyActor("/Users/sgupta11/Desktop/Chess/Assets/wBishop.png", 200, 0, "Bishop", "White", "C1");
        wBishop1.setBounds(0, 0, wBishop1.texture().getWidth(), wBishop1.texture().getHeight());
        wBishop1.setTouchable(Touchable.enabled);

        MyActor wBishop2 = new MyActor("/Users/sgupta11/Desktop/Chess/Assets/wBishop.png", 500, 0, "Bishop", "White", "F1");
        wBishop2.setBounds(0, 0, wBishop2.texture().getWidth(), wBishop2.texture().getHeight());
        wBishop2.setTouchable(Touchable.enabled);

        MyActor wKing = new MyActor("/Users/sgupta11/Desktop/Chess/Assets/wKing.png", 400, 0, "King", "White", "E1");
        wKing.setBounds(0, 0, wKing.texture().getWidth(), wKing.texture().getHeight());
        wKing.setTouchable(Touchable.enabled);

        MyActor wQueen = new MyActor("/Users/sgupta11/Desktop/Chess/Assets/wQueen.png", 300, 0, "Queen", "White", "D1");
        wQueen.setBounds(0, 0, wQueen.texture().getWidth(), wQueen.texture().getHeight());
        wQueen.setTouchable(Touchable.enabled);

        // Black Pieces
        MyActor bPawn1 = new MyActor("/Users/sgupta11/Desktop/Chess/Assets/bPawn.png", 0, 600, "Pawn", "Black", "A7");
        bPawn1.setBounds(0, 0, bPawn1.texture().getWidth(), bPawn1.texture().getHeight());
        bPawn1.setTouchable(Touchable.enabled);

        MyActor bPawn2 = new MyActor("/Users/sgupta11/Desktop/Chess/Assets/bPawn.png", 100, 600, "Pawn", "Black", "B7");
        bPawn2.setBounds(0, 0, bPawn2.texture().getWidth(), bPawn2.texture().getHeight());
        bPawn2.setTouchable(Touchable.enabled);

        MyActor bPawn3 = new MyActor("/Users/sgupta11/Desktop/Chess/Assets/bPawn.png", 200, 600, "Pawn", "Black", "C7");
        bPawn3.setBounds(0, 0, bPawn3.texture().getWidth(), bPawn3.texture().getHeight());
        bPawn3.setTouchable(Touchable.enabled);

        MyActor bPawn4 = new MyActor("/Users/sgupta11/Desktop/Chess/Assets/bPawn.png", 300, 600, "Pawn", "Black", "D7");
        bPawn4.setBounds(0, 0, bPawn4.texture().getWidth(), bPawn4.texture().getHeight());
        bPawn4.setTouchable(Touchable.enabled);

        MyActor bPawn5 = new MyActor("/Users/sgupta11/Desktop/Chess/Assets/bPawn.png", 400, 600, "Pawn", "Black", "E7");
        bPawn5.setBounds(0, 0, bPawn5.texture().getWidth(), bPawn5.texture().getHeight());
        bPawn5.setTouchable(Touchable.enabled);

        MyActor bPawn6 = new MyActor("/Users/sgupta11/Desktop/Chess/Assets/bPawn.png", 500, 600, "Pawn", "Black", "F7");
        bPawn6.setBounds(0, 0, bPawn6.texture().getWidth(), bPawn6.texture().getHeight());
        bPawn6.setTouchable(Touchable.enabled);

        MyActor bPawn7 = new MyActor("/Users/sgupta11/Desktop/Chess/Assets/bPawn.png", 600, 600, "Pawn", "Black", "G7");
        bPawn7.setBounds(0, 0, bPawn7.texture().getWidth(), bPawn7.texture().getHeight());
        bPawn7.setTouchable(Touchable.enabled);

        MyActor bPawn8 = new MyActor("/Users/sgupta11/Desktop/Chess/Assets/bPawn.png", 700, 600, "Pawn", "Black", "H7");
        bPawn8.setBounds(0, 0, bPawn8.texture().getWidth(), bPawn8.texture().getHeight());
        bPawn8.setTouchable(Touchable.enabled);

        MyActor bRook1 = new MyActor("/Users/sgupta11/Desktop/Chess/Assets/bRook.png", 0, 700, "Rook", "Black", "A8");
        bRook1.setBounds(0, 0, bRook1.texture().getWidth(), bRook1.texture().getHeight());
        bRook1.setTouchable(Touchable.enabled);

        MyActor bRook2 = new MyActor("/Users/sgupta11/Desktop/Chess/Assets/bRook.png", 700, 700, "Rook", "Black", "H8");
        bRook2.setBounds(0, 0, bRook2.texture().getWidth(), bRook2.texture().getHeight());
        bRook2.setTouchable(Touchable.enabled);

        MyActor bKnight1 = new MyActor("/Users/sgupta11/Desktop/Chess/Assets/bKnight.png", 100, 700, "Knight", "Black", "B8");
        bKnight1.setBounds(0, 0, bKnight1.texture().getWidth(), bKnight1.texture().getHeight());
        bKnight1.setTouchable(Touchable.enabled);

        MyActor bKnight2 = new MyActor("/Users/sgupta11/Desktop/Chess/Assets/bKnight.png", 600, 700, "Knight", "Black", "G8");
        bKnight2.setBounds(0, 0, bKnight2.texture().getWidth(), bKnight2.texture().getHeight());
        bKnight2.setTouchable(Touchable.enabled);

        MyActor bBishop1 = new MyActor("/Users/sgupta11/Desktop/Chess/Assets/bBishop.png", 200, 700, "Bishop", "Black", "C8");
        bBishop1.setBounds(0, 0, bBishop1.texture().getWidth(), bBishop1.texture().getHeight());
        bBishop1.setTouchable(Touchable.enabled);

        MyActor bBishop2 = new MyActor("/Users/sgupta11/Desktop/Chess/Assets/bBishop.png", 500, 700, "Bishop", "Black", "F8");
        bBishop2.setBounds(0, 0, bBishop2.texture().getWidth(), bBishop2.texture().getHeight());
        bBishop2.setTouchable(Touchable.enabled);

        MyActor bKing = new MyActor("/Users/sgupta11/Desktop/Chess/Assets/bKing.png", 400, 700, "King", "Black", "E1");
        bKing.setBounds(0, 0, bKing.texture().getWidth(), bKing.texture().getHeight());
        bKing.setTouchable(Touchable.enabled);

        MyActor bQueen = new MyActor("/Users/sgupta11/Desktop/Chess/Assets/bQueen.png", 300, 700, "Queen", "Black", "D1");
        bQueen.setBounds(0, 0, bQueen.texture().getWidth(), bQueen.texture().getHeight());
        bQueen.setTouchable(Touchable.enabled);

        pieces.add(wPawn1);
        pieces.add(wPawn2);
        pieces.add(wPawn3);
        pieces.add(wPawn4);
        pieces.add(wPawn5);
        pieces.add(wPawn6);
        pieces.add(wPawn7);
        pieces.add(wPawn8);
        pieces.add(wRook1);
        pieces.add(wRook2);
        pieces.add(wKnight1);
        pieces.add(wKnight2);
        pieces.add(wBishop1);
        pieces.add(wBishop2);
        pieces.add(wKing);
        pieces.add(wQueen);

        pieces.add(bPawn1);
        pieces.add(bPawn2);
        pieces.add(bPawn3);
        pieces.add(bPawn4);
        pieces.add(bPawn5);
        pieces.add(bPawn6);
        pieces.add(bPawn7);
        pieces.add(bPawn8);
        pieces.add(bRook1);
        pieces.add(bRook2);
        pieces.add(bKnight1);
        pieces.add(bKnight2);
        pieces.add(bBishop1);
        pieces.add(bBishop2);
        pieces.add(bKing);
        pieces.add(bQueen);

        whitePieces.add(wPawn1);
        whitePieces.add(wPawn2);
        whitePieces.add(wPawn3);
        whitePieces.add(wPawn4);
        whitePieces.add(wPawn5);
        whitePieces.add(wPawn6);
        whitePieces.add(wPawn7);
        whitePieces.add(wPawn8);
        whitePieces.add(wRook1);
        whitePieces.add(wRook2);
        whitePieces.add(wKnight1);
        whitePieces.add(wKnight2);
        whitePieces.add(wBishop1);
        whitePieces.add(wBishop2);
        whitePieces.add(wKing);
        whitePieces.add(wQueen);

        darkPieces.add(bPawn1);
        darkPieces.add(bPawn2);
        darkPieces.add(bPawn3);
        darkPieces.add(bPawn4);
        darkPieces.add(bPawn5);
        darkPieces.add(bPawn6);
        darkPieces.add(bPawn7);
        darkPieces.add(bPawn8);
        darkPieces.add(bRook1);
        darkPieces.add(bRook2);
        darkPieces.add(bKnight1);
        darkPieces.add(bKnight2);
        darkPieces.add(bBishop1);
        darkPieces.add(bBishop2);
        darkPieces.add(bKing);
        darkPieces.add(bQueen);

    }


    public static ArrayList<MyActor> returnPieces() {
        createPieces();
        return pieces;
    }

    public static ArrayList<MyActor> returnWhitePieces() {
        return whitePieces;
    }

    public static ArrayList<MyActor> returnDarkPieces() {
        return darkPieces;
    }
}
