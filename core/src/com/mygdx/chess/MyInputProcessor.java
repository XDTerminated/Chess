package com.mygdx.chess;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.audio.Sound;

public class MyInputProcessor implements InputProcessor {

    // Creates variables
    MyActor[] pieces; // Represents the turn and the pieces of the color
    MyActor[] whitePieces;
    MyActor[] blackPieces;
    MyActor[][] chessBoard; // Computers internal memory of the chessboard
    private MyActor touched = new MyActor();
    private boolean isDragging = false;
    final private Stage stage;
    private int touchedIndexX;
    private int touchedIndexY;
    Sound move = Gdx.audio.newSound(Gdx.files.internal("move.mp3"));
    Sound capture = Gdx.audio.newSound(Gdx.files.internal("capture.mp3"));


    // Constructor
    public MyInputProcessor(MyActor[] whitePieces, MyActor[] blackPieces, MyActor[][] chessBoard, Stage stage) {
        this.whitePieces = whitePieces;
        this.blackPieces = blackPieces;
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

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {

        Vector2 stageCoordinates = stage.screenToStageCoordinates(new Vector2((float) screenX, (float) screenY));
        if (ChessBoard.getTurn().equals("White")) {
            pieces = whitePieces;
        } else {
            pieces = blackPieces;
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

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        if (ChessBoard.getTurn().equals("Black")) {
            ChessBoard.setTurn("White");
        } else {
            ChessBoard.setTurn("Black");
        }

        if (isDragging == false) {
            touchedIndexX = 1000;
            touchedIndexY = 1000;

        }
        touched.setXPos(Math.round((int) (Math.round(touched.getXPOS() / 100.0) * 100)));
        touched.setYPos(Math.round((int) (Math.round(touched.getYPOS() / 100.0) * 100)));

        for (int i = 0; i < pieces.length; i++) {
            if (touched.getXPOS() == pieces[i].getXPOS() && touched.getYPOS() == pieces[i].getYPOS()) {
                if (!pieces[i].equals(touched)) {
                    pieces[i].remove();
                    pieces[i] = null;
                    capture.play();
                    break;
                }

            }
        }

        if (!(touchedIndexX == 1000)) {
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