package com.mygdx.chess;
import java.util.*;

public class Rules {


    public static boolean isLegal(MyActor[][] position, MyActor piece, int xChange, int yChange) {
        // Pawns
        if (piece.getName().equals("Pawn")) {
            // Standard Pawn Pushes
            if ((position[(piece.getYPOS()/100)][((piece.getXPOS())/100)]) == null) {
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
                        if (piece.color().equals("W") && yChange == 100) {
                            return true;
                        } else if (piece.color().equals("B") && yChange == -100) {
                            return true;
                        }
                    }
                }
            }

            // Capturing other pieces with pawns
            if (piece.color().equals("W") && yChange == 100 && Math.abs(xChange) == 100) {
                if ((position[((piece.getYPOS())/100)][((piece.getXPOS())/100)] != null)) {
                    return true;
                }
            } else if (piece.color().equals("B") && yChange == -100 && Math.abs(xChange) == 100) {
                if ((position[((piece.getYPOS())/100)][((piece.getXPOS())/100)] != null)) {
                    return true;
                }
            }

            // En Passant

            // Promotions
        }

        // Knights
        else if (piece.getName().equals("Knight")) {
            if (xChange == 0 || yChange == 0) {
                return false;
            } else if (Math.abs((yChange/xChange)) == 2 || Math.abs((double) yChange/ (double) xChange) == 0.5) {
                return true;
            }

        }

        // Bishops
        else if (piece.getName().equals("Bishop")) {
            if (xChange == 0 || yChange == 0) {
                return false;
            }
            return traceBackDiagonal(position, piece, (piece.getYPOS()/100), piece.getXPOS()/100, xChange, yChange);

        }

        // Rooks
        else if (piece.getName().equals("Rook")) {
            if (xChange != 0) {
                if (yChange/xChange == 0) {
                    return traceBackVH(position, piece, (piece.getYPOS()/100), piece.getXPOS()/100, xChange, yChange);
                }
            } else if (xChange == 0) {
                return traceBackVH(position, piece, (piece.getYPOS()/100), piece.getXPOS()/100, xChange, yChange);
            }


        }

        // Queens
        else if (piece.getName().equals("Queen")) {
            if (xChange != 0) {
                if (yChange/xChange == 0) {
                    return traceBackVH(position, piece, (piece.getYPOS()/100), piece.getXPOS()/100, xChange, yChange);
                }
            } else if (xChange == 0) {
                return traceBackVH(position, piece, (piece.getYPOS()/100), piece.getXPOS()/100, xChange, yChange);
            }
            if (Math.abs(yChange/xChange) == 1) {
                return traceBackDiagonal(position, piece, (piece.getYPOS()/100), piece.getXPOS()/100, xChange, yChange);
            }
        }

        else if (piece.getName().equals("King")) {

        }


        return false;
    }

    public static boolean traceBackDiagonal(MyActor[][] position, MyActor piece, int x, int y, int xChange, int yChange) {
        if (xChange > 0 && yChange > 0) {
            if (position[x - 1][y - 1] == null) {
                return traceBackDiagonal(position, piece, x - 1, y - 1, xChange, yChange);
            } else if (position[x - 1][y - 1] == piece) {
                return true;
            }
        } else if (xChange > 0 && yChange < 0) {
            if (position[x + 1][y - 1] == null) {
                return traceBackDiagonal(position, piece, x + 1, y - 1, xChange, yChange);
            } else if (position[x + 1][y - 1] == piece) {
                return true;
            }
        } else if (xChange < 0 && yChange > 0) {
            if (position[x - 1][y + 1] == null) {
                return traceBackDiagonal(position, piece, x - 1, y + 1, xChange, yChange);
            } else if (position[x - 1][y + 1] == piece) {
                return true;
            }
        } else if (xChange < 0 && yChange < 0) {
            if (position[x + 1][y + 1] == null) {
                return traceBackDiagonal(position, piece, x + 1, y + 1, xChange, yChange);
            } else if (position[x + 1][y + 1] == piece) {
                return true;
            }
        }

        return false;
    }

    public static boolean traceBackVH(MyActor[][] position, MyActor piece, int x, int y, int xChange, int yChange) {

        if (xChange > 0) {
            if (position[x][y - 1] == null) {
                return traceBackVH(position, piece, x, y - 1, xChange, yChange);
            } else if (position[x][y - 1] == piece) {
                return true;
            }
        } else if (xChange < 0) {
            if (position[x][y + 1] == null) {
                return traceBackVH(position, piece, x, y + 1, xChange, yChange);
            } else if (position[x][y + 1] == piece) {
                return true;
            }
        } else if (yChange > 0) {
            if (position[x - 1][y] == null) {
                return traceBackVH(position, piece, x - 1, y, xChange, yChange);
            } else if (position[x - 1][y] == piece) {
                return true;
            }
        } else if (yChange < 0) {
            if (position[x + 1][y] == null) {
                return traceBackVH(position, piece, x + 1, y, xChange, yChange);
            } else if (position[x + 1][y] == piece) {
                return true;
            }
        }

        return false;
    }
}
