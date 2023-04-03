package com.mygdx.chess;
import java.util.*;

public class Rules {


    public static boolean isLegal(MyActor[][] position, MyActor piece, int xChange, int yChange) {
        // Pawns
        if (piece.getName().equals("Pawn")) {
            // If the piece is pinned to the king by an enemy piece
            if (!isPinned(position, piece)) {
//                return false;
            }
            // Standard Pawn Pushes
            if ((position[7 - (piece.getYPOS()/100)][((piece.getXPOS())/100)]) == null) {
                if (!piece.getHasMoved()) {

                    if (xChange == 0) {
                        if (piece.color().equals("W") && yChange <= 200 && yChange > 0) {
                            piece.setHasMoved();
                            return true;
                        } else if (piece.color().equals("B") && yChange >= -200 && yChange < 0) {
                            piece.setHasMoved();
                            return true;
                        }
                    }
                } else if (piece.getHasMoved()) {
                    if (xChange == 0) {
                        if (piece.color().equals("W") && yChange == 100 && yChange > 0) {
                            return true;
                        }
                    } else if (piece.color().equals("B") && yChange == -100 && yChange < 0) {
                        return true;
                    }
                }
            }

            // Capturing other pieces with pawns
            if (piece.color().equals("W") && yChange == 100 && Math.abs(xChange) == 100) {
                if ((position[(7 - (piece.getYPOS())/100)][((piece.getXPOS())/100)] != null)) {
                    return true;
                }
            } else if (piece.color().equals("B") && yChange == -100 && Math.abs(xChange) == 100) {
                if ((position[(7 - (piece.getYPOS())/100)][((piece.getXPOS())/100)] != null)) {
                    return true;
                }
            }

            // En Passant

        }

        // Knights
        if (piece.getName().equals("Knight")) {
            if (xChange == 0 || yChange == 0) {
                return false;
            } else if (Math.abs((yChange/xChange)) == 2 || Math.abs((double) yChange/ (double) xChange) == 0.5) {
                return true;
            }
        }
        return false;
    }

    public static boolean isPinned(MyActor[][] position, MyActor piece) {
        return false;
    }



}
