package com.mygdx.chess;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ScreenUtils;

import javax.net.ssl.HandshakeCompletedEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class ChessBoard {

    // Variables
    static HashMap<String, ArrayList<Pieces>> whitePieces = new HashMap<String, ArrayList<Pieces>>();
    static HashMap<String, ArrayList<Pieces>> blackPieces = new HashMap<String, ArrayList<Pieces>>();


    static ShapeRenderer shapeRenderer = new ShapeRenderer();
    static SpriteBatch spriteBatch = new SpriteBatch();

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
        Pieces wPawn1 = new Pieces(new Sprite(new Texture(Gdx.files.internal("/Users/sgupta11/Desktop/Chess/Assets/wPawn.png"))), "Pawn", "White", "a2", 0, 1);
        Pieces wPawn2 = new Pieces(new Sprite(new Texture(Gdx.files.internal("/Users/sgupta11/Desktop/Chess/Assets/wPawn.png"))), "Pawn", "White", "b2", 1, 1);
        Pieces wPawn3 = new Pieces(new Sprite(new Texture(Gdx.files.internal("/Users/sgupta11/Desktop/Chess/Assets/wPawn.png"))), "Pawn", "White", "c2", 2, 1);
        Pieces wPawn4 = new Pieces(new Sprite(new Texture(Gdx.files.internal("/Users/sgupta11/Desktop/Chess/Assets/wPawn.png"))), "Pawn", "White", "d2", 3, 1);
        Pieces wPawn5 = new Pieces(new Sprite(new Texture(Gdx.files.internal("/Users/sgupta11/Desktop/Chess/Assets/wPawn.png"))), "Pawn", "White", "e2", 4, 1);
        Pieces wPawn6 = new Pieces(new Sprite(new Texture(Gdx.files.internal("/Users/sgupta11/Desktop/Chess/Assets/wPawn.png"))), "Pawn", "White", "f2", 5, 1);
        Pieces wPawn7 = new Pieces(new Sprite(new Texture(Gdx.files.internal("/Users/sgupta11/Desktop/Chess/Assets/wPawn.png"))), "Pawn", "White", "g2", 6, 1);
        Pieces wPawn8 = new Pieces(new Sprite(new Texture(Gdx.files.internal("/Users/sgupta11/Desktop/Chess/Assets/wPawn.png"))), "Pawn", "White", "h2", 7, 1);
        // White Rooks
        Pieces wRook1 = new Pieces(new Sprite(new Texture(Gdx.files.internal("/Users/sgupta11/Desktop/Chess/Assets/wRook.png"))), "Rook", "White", "a1", 8, 5);
        Pieces wRook2 = new Pieces(new Sprite(new Texture(Gdx.files.internal("/Users/sgupta11/Desktop/Chess/Assets/wRook.png"))), "Rook", "White", "h1", 15, 5);
        // White Knights
        Pieces wKnight1 = new Pieces(new Sprite(new Texture(Gdx.files.internal("/Users/sgupta11/Desktop/Chess/Assets/wKnight.png"))), "Knight", "White", "b1", 9, 3);
        Pieces wKnight2 = new Pieces(new Sprite(new Texture(Gdx.files.internal("/Users/sgupta11/Desktop/Chess/Assets/wKnight.png"))), "Knight", "White", "g1", 14, 3);
        // White Bishops
        Pieces wBishop1 = new Pieces(new Sprite(new Texture(Gdx.files.internal("/Users/sgupta11/Desktop/Chess/Assets/wBishop.png"))), "Bishop", "White", "c1", 10, 3);
        Pieces wBishop2 = new Pieces(new Sprite(new Texture(Gdx.files.internal("/Users/sgupta11/Desktop/Chess/Assets/wBishop.png"))), "Bishop", "White", "f1", 13, 3);

        // White Queen
        Pieces wQueen = new Pieces(new Sprite(new Texture(Gdx.files.internal("/Users/sgupta11/Desktop/Chess/Assets/wQueen.png"))), "Queen", "White", "d1", 11, 9);
        // White King
        Pieces wKing = new Pieces(new Sprite(new Texture(Gdx.files.internal("/Users/sgupta11/Desktop/Chess/Assets/wKing.png"))), "King", "White", "e1", 12, 100);


        // Black Pawns
        Pieces bPawn1 = new Pieces(new Sprite(new Texture(Gdx.files.internal("/Users/sgupta11/Desktop/Chess/Assets/bPawn.png"))), "Pawn", "Black", "a7", 0, 1);
        Pieces bPawn2 = new Pieces(new Sprite(new Texture(Gdx.files.internal("/Users/sgupta11/Desktop/Chess/Assets/bPawn.png"))), "Pawn", "Black", "b7", 1, 1);
        Pieces bPawn3 = new Pieces(new Sprite(new Texture(Gdx.files.internal("/Users/sgupta11/Desktop/Chess/Assets/bPawn.png"))), "Pawn", "Black", "c7", 2, 1);
        Pieces bPawn4 = new Pieces(new Sprite(new Texture(Gdx.files.internal("/Users/sgupta11/Desktop/Chess/Assets/bPawn.png"))), "Pawn", "Black", "d7", 3, 1);
        Pieces bPawn5 = new Pieces(new Sprite(new Texture(Gdx.files.internal("/Users/sgupta11/Desktop/Chess/Assets/bPawn.png"))), "Pawn", "Black", "e7", 4, 1);
        Pieces bPawn6 = new Pieces(new Sprite(new Texture(Gdx.files.internal("/Users/sgupta11/Desktop/Chess/Assets/bPawn.png"))), "Pawn", "Black", "f7", 5, 1);
        Pieces bPawn7 = new Pieces(new Sprite(new Texture(Gdx.files.internal("/Users/sgupta11/Desktop/Chess/Assets/bPawn.png"))), "Pawn", "Black", "g7", 6, 1);
        Pieces bPawn8 = new Pieces(new Sprite(new Texture(Gdx.files.internal("/Users/sgupta11/Desktop/Chess/Assets/bPawn.png"))), "Pawn", "Black", "h7", 7, 1);
        // Black Rooks
        Pieces bRook1 = new Pieces(new Sprite(new Texture(Gdx.files.internal("/Users/sgupta11/Desktop/Chess/Assets/bRook.png"))), "Rook", "Black", "a8", 8, 5);
        Pieces bRook2 = new Pieces(new Sprite(new Texture(Gdx.files.internal("/Users/sgupta11/Desktop/Chess/Assets/bRook.png"))), "Rook", "Black", "h8", 15, 5);
        // Black Knights
        Pieces bKnight1 = new Pieces(new Sprite(new Texture(Gdx.files.internal("/Users/sgupta11/Desktop/Chess/Assets/bKnight.png"))), "Knight", "Black", "b8", 9, 3);
        Pieces bKnight2 = new Pieces(new Sprite(new Texture(Gdx.files.internal("/Users/sgupta11/Desktop/Chess/Assets/bKnight.png"))), "Knight", "Black", "g8", 14, 3);
        // Black Bishops
        Pieces bBishop1 = new Pieces(new Sprite(new Texture(Gdx.files.internal("/Users/sgupta11/Desktop/Chess/Assets/bBishop.png"))), "Bishop", "Black", "c8", 10, 3);
        Pieces bBishop2 = new Pieces(new Sprite(new Texture(Gdx.files.internal("/Users/sgupta11/Desktop/Chess/Assets/bBishop.png"))), "Bishop", "Black", "f8", 13, 3);
        // Black Queen
        Pieces bQueen = new Pieces(new Sprite(new Texture(Gdx.files.internal("/Users/sgupta11/Desktop/Chess/Assets/bQueen.png"))), "Queen", "Black", "d8", 11, 9);
        // Black King
        Pieces bKing = new Pieces(new Sprite(new Texture(Gdx.files.internal("/Users/sgupta11/Desktop/Chess/Assets/bKing.png"))), "King", "Black", "e8", 12, 100);

        ArrayList<Pieces> wPawns = new ArrayList<Pieces>(Arrays.asList(wPawn1, wPawn2, wPawn3, wPawn4, wPawn5, wPawn6, wPawn7, wPawn8));
        ArrayList<Pieces> wRooks = new ArrayList<Pieces>(Arrays.asList(wRook1, wRook2));
        ArrayList<Pieces> wKnights = new ArrayList<Pieces>(Arrays.asList(wKnight1, wKnight2));
        ArrayList<Pieces> wBishops = new ArrayList<Pieces>(Arrays.asList(wBishop1, wBishop2));
        ArrayList<Pieces> wQueens = new ArrayList<Pieces>(Arrays.asList(wQueen));
        ArrayList<Pieces> wKings = new ArrayList<Pieces>(Arrays.asList(wKing));

        ArrayList<Pieces> bPawns = new ArrayList<Pieces>(Arrays.asList(bPawn1, bPawn2, bPawn3, bPawn4, bPawn5, bPawn6, bPawn7, bPawn8));
        ArrayList<Pieces> bRooks = new ArrayList<Pieces>(Arrays.asList(bRook1, bRook2));
        ArrayList<Pieces> bKnights = new ArrayList<Pieces>(Arrays.asList(bKnight1, bKnight2));
        ArrayList<Pieces> bBishops = new ArrayList<Pieces>(Arrays.asList(bBishop1, bBishop2));
        ArrayList<Pieces> bQueens = new ArrayList<Pieces>(Arrays.asList(bQueen));
        ArrayList<Pieces> bKings = new ArrayList<Pieces>(Arrays.asList(bKing));

        whitePieces.put("Pawns", wPawns);
        whitePieces.put("Knights", wKnights);
        whitePieces.put("Bishops", wBishops);
        whitePieces.put("Rooks", wRooks);
        whitePieces.put("King", wKings);
        whitePieces.put("Queen", wQueens);

        blackPieces.put("Pawns", bPawns);
        blackPieces.put("Knights", bKnights);
        blackPieces.put("Bishops", bBishops);
        blackPieces.put("Rooks", bRooks);
        blackPieces.put("King", bKings);
        blackPieces.put("Queen", bQueens);



    }

    public static void displayPosition(String FEN) {
        createPieces();

        HashMap<String, ArrayList<Pieces>> duplicateWhite = whitePieces;
        HashMap<String, ArrayList<Pieces>> duplicateBlack = blackPieces;

        int posX = 0; int posY = 700;
        spriteBatch.begin();

        for (int i = 0; i < FEN.length(); i++) {
            if (isInteger(FEN.substring(i, i + 1))) {
                posX = posX + 100 * Integer.parseInt(FEN.substring(i, i + 1));
            } else if (FEN.substring(i, i + 1).equals("/")) {
                posX = 0; posY = posY - 100;
            } else if (FEN.substring(i, i + 1).equals("P")) {
                spriteBatch.draw(duplicateWhite.get("Pawns").get(0).piece, posX, posY, 100, 100);
                duplicateWhite.get("Pawns").remove(0);
                posX+=100;
            } else if (FEN.substring(i, i + 1).equals("p")) {
                spriteBatch.draw(duplicateBlack.get("Pawns").get(0).piece, posX, posY, 100, 100);
                duplicateBlack.get("Pawns").remove(0);
                posX+=100;
            } else if (FEN.substring(i, i + 1).equals("R")) {
                spriteBatch.draw(duplicateWhite.get("Rooks").get(0).piece, posX, posY, 100, 100);
                duplicateWhite.get("Rooks").remove(0);
                posX+=100;
            } else if (FEN.substring(i, i + 1).equals("r")) {
                spriteBatch.draw(duplicateBlack.get("Rooks").get(0).piece, posX, posY, 100, 100);
                duplicateBlack.get("Rooks").remove(0);
                posX+=100;
            } else if (FEN.substring(i, i + 1).equals("N")) {
                spriteBatch.draw(duplicateWhite.get("Knights").get(0).piece, posX, posY, 100, 100);
                duplicateWhite.get("Knights").remove(0);
                posX+=100;
            } else if (FEN.substring(i, i + 1).equals("n")) {
                spriteBatch.draw(duplicateBlack.get("Knights").get(0).piece, posX, posY, 100, 100);
                duplicateBlack.get("Knights").remove(0);
                posX+=100;
            } else if (FEN.substring(i, i + 1).equals("B")) {
                spriteBatch.draw(duplicateWhite.get("Bishops").get(0).piece, posX, posY, 100, 100);
                duplicateWhite.get("Bishops").remove(0);
                posX+=100;
            } else if (FEN.substring(i, i + 1).equals("b")) {
                spriteBatch.draw(duplicateBlack.get("Bishops").get(0).piece, posX, posY, 100, 100);
                duplicateBlack.get("Bishops").remove(0);
                posX+=100;
            } else if (FEN.substring(i, i + 1).equals("Q")) {
                spriteBatch.draw(duplicateWhite.get("Queen").get(0).piece, posX, posY, 100, 100);
                duplicateWhite.get("Queen").remove(0);
                posX+=100;
            } else if (FEN.substring(i, i + 1).equals("q")) {
                spriteBatch.draw(duplicateBlack.get("Queen").get(0).piece, posX, posY, 100, 100);
                duplicateBlack.get("Queen").remove(0);
                posX+=100;
            } else if (FEN.substring(i, i + 1).equals("K")) {
                spriteBatch.draw(duplicateWhite.get("King").get(0).piece, posX, posY, 100, 100);
                duplicateWhite.get("King").remove(0);
                posX+=100;
            } else if (FEN.substring(i, i + 1).equals("k")) {
                spriteBatch.draw(duplicateBlack.get("King").get(0).piece, posX, posY, 100, 100);
                duplicateBlack.get("King").remove(0);
                posX+=100;
            }
        }

        spriteBatch.end();

    }

    public static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch(NumberFormatException e) {
            return false;
        } catch(NullPointerException e) {
            return false;
        }
        // only got here if we didn't return false
        return true;
    }
}
