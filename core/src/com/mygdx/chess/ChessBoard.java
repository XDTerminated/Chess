package com.mygdx.chess;

import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;


public class ChessBoard {

    // Variables
    private static String turn;
    private static Stage stage = new Stage(new ScreenViewport());
    private static int[][] chessBoard = new int[8][8];

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

    }

    // Displays position based on FEN String
    public static void displayPosition(String FEN) {

    }

    public static void updateChessBoard() {

    }

}
