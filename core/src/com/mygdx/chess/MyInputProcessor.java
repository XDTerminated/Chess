package com.mygdx.chess;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.scenes.scene2d.Touchable;

import java.util.*;

public class MyInputProcessor implements InputProcessor {

    // Creates variables
    private ArrayList<MyActor> pieces; // Stores white when its whites turn and black when its blacks turn.
    private ArrayList<MyActor> piecesOpposite; // Stores black when its whites turn and white when its black turns.
    private final ArrayList<MyActor> whitePieces;
    private final ArrayList<MyActor> blackPieces;
    private final MyActor[][] chessBoard; // Computers internal memory of the chessboard
    private MyActor touched = null; // ...
    private boolean isDragging = false;
    final private Stage stage;
    private final Sound move = Gdx.audio.newSound(Gdx.files.internal("move.mp3"));
    private final Sound capture = Gdx.audio.newSound(Gdx.files.internal("capture.mp3"));


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
        } else if (ChessBoard.getTurn().equals("Black")) {
            pieces = blackPieces;
            piecesOpposite = whitePieces;
        }


        for (MyActor a : pieces) {
            if ((a.getBounds().getX() <= stageCoordinates.x && a.getBounds().getWidth() >= stageCoordinates.x && a.getBounds().getY() <= stageCoordinates.y && a.getBounds().getHeight() >= stageCoordinates.y) || isDragging) {

                touched = a;
                touched.toFront();

                isDragging = true;

                return true;

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

        String s = touched.getPosition();
        int initialX = (((int) s.charAt(0)) - 97) * 100; int initialY = (((int) s.charAt(1)) - 49) * 100;

        touched.setXPos(Math.round((int) (Math.round(touched.getXPOS() / 100.0) * 100)));
        touched.setYPos(Math.round((int) (Math.round(touched.getYPOS() / 100.0) * 100)));

        for (MyActor piece : pieces) {
            if (touched.getXPOS() == piece.getXPOS() && touched.getYPOS() == piece.getYPOS()) {
                if (touched != piece) {
                    touched.setXPos(initialX);
                    touched.setYPos(initialY);
                    touched = null;
                    isDragging = false;
                    return false;
                }
            }
        }

        if ((touched.getXPOS() == initialX) && (touched.getYPOS() == initialY)) {
            touched.setXPos(initialX);
            touched.setYPos(initialY);
            touched = null;
            isDragging = false;
            return false;
        }
        if (touched.getXPOS() < 0 || touched.getXPOS() > 700 || touched.getYPOS() < 0 || touched.getYPOS() > 700) {
            touched.setXPos(initialX);
            touched.setYPos(initialY);
            touched = null;
            isDragging = false;
            return false;
        }

        if (!Rules.isLegal(chessBoard, touched, touched.getXPOS() - initialX, touched.getYPOS() - initialY)) {
            touched.setXPos(initialX);
            touched.setYPos(initialY);
            touched = null;
            isDragging = false;
            return false;
        } else {

            System.out.println(touched.getEnPassant());

            chessBoard[(initialY/100)][(initialX/100)] = null;
            chessBoard[(touched.getYPOS()/100)][((touched.getXPOS())/100)] = touched;

            touched.setPosition("" + (char) (touched.getXPOS()/100) + 97 + (char) (touched.getYPOS()/100) + 49);

            // Pawn Promotions -> Queen
            if (Rules.promotion) {
                for (int i = 0; i < whitePieces.size(); i++) {
                    if (whitePieces.get(i) == chessBoard[(touched.getYPOS()/100)][((touched.getXPOS())/100)]) {
                        whitePieces.remove(i);
                        break;
                    }
                }

                for (int i = 0; i < blackPieces.size(); i++) {
                    if (blackPieces.get(i) == chessBoard[(touched.getYPOS()/100)][((touched.getXPOS())/100)]) {
                        blackPieces.remove(i);
                        break;
                    }
                }
                chessBoard[(touched.getYPOS()/100)][((touched.getXPOS())/100)].remove();
                if (Rules.promotedColor.equals("White")) {
                    MyActor wQueen = new Queen("wQueen.png", touched.getXPOS(), touched.getYPOS(), "W", "");
                    wQueen.setPosition("" + (char) ((touched.getXPOS()/100) + 97) +  (char) ((touched.getYPOS()/100) + 49));
                    wQueen.setBounds(0, 0, wQueen.texture().getWidth(), wQueen.texture().getHeight());
                    wQueen.setTouchable(Touchable.enabled);
                    chessBoard[(touched.getYPOS()/100)][((touched.getXPOS())/100)] = wQueen;
                    stage.addActor(wQueen);
                    whitePieces.add(wQueen);
                } else {
                    MyActor bQueen = new Queen("bQueen.png", touched.getXPOS(), touched.getYPOS(), "B", "" + (char) ((touched.getXPOS()/100) + 97) + (char) (touched.getYPOS()/100) + 49);
                    bQueen.setPosition("" + (char) ((touched.getXPOS()/100) + 97) +  (char) ((touched.getYPOS()/100) + 49));
                    chessBoard[(touched.getYPOS()/100)][((touched.getXPOS())/100)] = bQueen;
                    bQueen.setBounds(0, 0, bQueen.texture().getWidth(), bQueen.texture().getHeight());
                    bQueen.setTouchable(Touchable.enabled);
                    stage.addActor(bQueen);
                    blackPieces.add(bQueen);
                }

                Rules.promotion = false;
            }

            // En Passant
            if (Rules.enPassant) {
                for (int i = 0; i < whitePieces.size(); i++) {
                    if (chessBoard[Rules.xPiece/100][Rules.yPiece/100] == whitePieces.get(i)) {
                        whitePieces.remove(i);
                        break;
                    }
                }

                for (int i = 0; i < blackPieces.size(); i++) {
                    if (chessBoard[Rules.xPiece/100][Rules.yPiece/100] == blackPieces.get(i)) {
                        blackPieces.remove(i);
                        break;
                    }
                }

                chessBoard[Rules.xPiece/100][Rules.yPiece/100].remove();
                chessBoard[Rules.xPiece/100][Rules.yPiece/100] = null;
                Rules.enPassant = false;
                capturePlayed = true;
                capture.play();
            }

            touched.setHasMoved();

        }

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

        if (ChessBoard.getTurn().equals("Black")) {
            ChessBoard.setTurn("White");
        } else {
            ChessBoard.setTurn("Black");
        }


        String position = "" + (char)(touched.getXPOS() /100 + 97) + (char)(touched.getYPOS() /100 + 49);
        touched.setPosition(position);

        touched = null;
        // Go through all the pawns and change the en passant if the en passant is 0;
        for (MyActor a: whitePieces) {
            if (a.getEnPassant()) {
                if (a.getCounter() == 0) {
                    a.increaseCounter();
                } else if (a.getCounter() == 1) {
                    a.setEnPassant(false);
                }
            }
        }

        for (MyActor a: blackPieces) {
            if (a.getEnPassant()) {
                if (a.getCounter() == 0) {
                    a.increaseCounter();
                } else if (a.getCounter() == 1) {
                    a.setEnPassant(false);
                }
            }
        }

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