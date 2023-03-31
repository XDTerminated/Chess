package com.mygdx.chess;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.audio.Sound;
import java.util.*;

public class MyInputProcessor implements InputProcessor {

    // Creates variables
    ArrayList<MyActor> pieces; // Stores white when its whites turn and black when its blacks turn.
    ArrayList<MyActor> piecesOpposite; // Stores black when its whites turn and white when its black turns.
    ArrayList<MyActor> whitePieces;
    ArrayList<MyActor> blackPieces;
    MyActor[][] chessBoard; // Computers internal memory of the chessboard
    private MyActor touched = null; // ...
    private boolean isDragging = false;
    final private Stage stage;
    private int touchedIndexX;
    private int touchedIndexY;
    Sound move = Gdx.audio.newSound(Gdx.files.internal("move.mp3"));
    Sound capture = Gdx.audio.newSound(Gdx.files.internal("capture.mp3"));


    // Constructor
    public MyInputProcessor(MyActor[] whitePieces, MyActor[] blackPieces, MyActor[][] chessBoard, Stage stage) {
        this.whitePieces = new ArrayList<>(Arrays.asList(whitePieces));
        this.blackPieces = new ArrayList<>(Arrays.asList(blackPieces));
        this.chessBoard = chessBoard;

        this.stage = stage;
    }

    // Override Functions
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override // To Fix
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        touched = null;

        Vector2 stageCoordinates = stage.screenToStageCoordinates(new Vector2((float) screenX, (float) screenY));
        // Set the pieces to white/black depending on the turn
        if (ChessBoard.getTurn().equals("White")) {
            pieces = whitePieces;
            piecesOpposite = blackPieces;
        } else {
            pieces = blackPieces;
            piecesOpposite = whitePieces;
        }

        for (MyActor a : pieces) {
            if ((a.getBounds().getX() <= stageCoordinates.x && a.getBounds().getWidth() >= stageCoordinates.x && a.getBounds().getY() <= stageCoordinates.y && a.getBounds().getHeight() >= stageCoordinates.y) || isDragging) {

                touched = a;
                touched.toFront();

                if (!isDragging) {
                    touchedIndexX = (int) (touched.getYPOS() / 100);
                    touchedIndexY = (int) (touched.getXPOS() / 100);
                }

                isDragging = true;

                return true;

            } else {
                isDragging = false;
            }

        }

        return false;


    }

    @Override // To Fix
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        boolean capturePlayed = false;
        if (touched == null) {
            return false;
        }

        if (ChessBoard.getTurn().equals("Black")) {
            ChessBoard.setTurn("White");
        } else {
            ChessBoard.setTurn("Black");
        }

        touched.setXPos(Math.round((int) (Math.round(touched.getXPOS() / 100.0) * 100)));
        touched.setYPos(Math.round((int) (Math.round(touched.getYPOS() / 100.0) * 100)));

        for (int i = 0; i < piecesOpposite.size(); i++) {
            if (touched.getXPOS() == piecesOpposite.get(i).getXPOS() && touched.getYPOS() == piecesOpposite.get(i).getYPOS()) {
                piecesOpposite.get(i).remove();
                piecesOpposite.remove(i);
                capturePlayed = true;
                capture.play();
                break;
            }
        }

        if (!capturePlayed) {
            move.play();
        }


        isDragging = false;

        return true;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {

            if (isDragging) {
                touched.setXPos(Gdx.input.getX() - touched.texture().getWidth() / 2);
                touched.setYPos(800 - Gdx.input.getY() - touched.texture().getHeight() / 2);
                return true;

            }

            return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(float amountX, float amountY) {
        return false;
    }
}