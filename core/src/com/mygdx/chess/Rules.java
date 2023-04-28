package com.mygdx.chess;

public class Rules {


    public static String promotedColor;
    public static boolean promotion = false;
    public static boolean enPassant = false;
    public static int xPiece;
    public static int yPiece;
    public static boolean castle;



    public static boolean isLegal(MyActor[][] position, MyActor piece, int xChange, int yChange) {
        // Pawns
        if (piece.getName().equals("Pawn")) {
            // Standard Pawn Pushes
            if ((position[(piece.getYPOS()/100)][((piece.getXPOS())/100)]) == null) {
                if (!piece.getHasMoved()) {
                    if (xChange == 0) {
                        if (piece.color().equals("W") && yChange <= 200 && yChange > 0) {
                            if (yChange != 200) {
                                piece.setHasMoved();
                                return true;
                            }
                            if (piece.getXPOS() == 0) {
                                if (position[piece.getYPOS()/100][piece.getXPOS()/100 + 1] != null) {
                                    if (position[piece.getYPOS()/100][piece.getXPOS()/100 + 1].color().equals("B") && position[piece.getYPOS()/100][piece.getXPOS()/100 + 1].getName().equals("Pawn")) {
                                        piece.setEnPassant(true);
                                    }
                                }
                            } else if (piece.getXPOS() == 700) {

                                if (position[piece.getYPOS()/100][6] != null) {
                                    if (position[piece.getYPOS()/100][piece.getXPOS()/100 - 1].color().equals("B") && position[piece.getYPOS()/100][piece.getXPOS()/100 - 1].getName().equals("Pawn")) {
                                        piece.setEnPassant(true);
                                    }
                                }
                            } else {
                                if (position[piece.getYPOS()/100][piece.getXPOS()/100 - 1] != null) {
                                    if (position[piece.getYPOS()/100][piece.getXPOS()/100 - 1].color().equals("B") && position[piece.getYPOS()/100][piece.getXPOS()/100 - 1].getName().equals("Pawn")) {
                                        piece.setEnPassant(true);
                                    }
                                }

                                if (position[piece.getYPOS()/100][piece.getXPOS()/100 + 1] != null) {
                                    if (position[piece.getYPOS()/100][piece.getXPOS()/100 + 1].color().equals("B") && position[piece.getYPOS()/100][piece.getXPOS()/100 + 1].getName().equals("Pawn")) {
                                        piece.setEnPassant(true);
                                    }
                                }
                            }
                            piece.setHasMoved();
                            return true;
                        } else if (piece.color().equals("B") && yChange >= -200 && yChange < 0) {
                            if (yChange != -200) {
                                piece.setHasMoved();
                                return true;
                            }
                            if (piece.getXPOS() == 0) {
                                if (position[piece.getYPOS()/100][piece.getXPOS()/100 + 1] != null) {
                                    if (position[piece.getYPOS()/100][piece.getXPOS()/100 + 1].color().equals("W") && position[piece.getYPOS()/100][piece.getXPOS()/100 + 1].getName().equals("Pawn")) {
                                        piece.setEnPassant(true);
                                    }
                                }
                            } else if (piece.getXPOS() == 700) {
                                if (position[piece.getYPOS()/100][piece.getXPOS()/100 - 1] != null) {
                                    if (position[piece.getYPOS()/100][piece.getXPOS()/100 - 1].color().equals("W") && position[piece.getYPOS()/100][piece.getXPOS()/100 - 1].getName().equals("Pawn")) {
                                        piece.setEnPassant(true);
                                    }
                                }
                            } else {
                                if (position[piece.getYPOS()/100][piece.getXPOS()/100 - 1] != null) {
                                    if (position[piece.getYPOS()/100][piece.getXPOS()/100 - 1].color().equals("W") && position[piece.getYPOS()/100][piece.getXPOS()/100 - 1].getName().equals("Pawn")) {
                                        piece.setEnPassant(true);
                                    }
                                }

                                if (position[piece.getYPOS()/100][piece.getXPOS()/100 + 1] != null) {
                                    if (position[piece.getYPOS()/100][piece.getXPOS()/100 + 1].color().equals("W") && position[piece.getYPOS()/100][piece.getXPOS()/100 + 1].getName().equals("Pawn")) {
                                        piece.setEnPassant(true);
                                    }
                                }
                            }
                            piece.setHasMoved();
                            return true;
                        }
                    }
                } else {
                    if (xChange == 0) {
                        if (piece.color().equals("W") && yChange == 100) {
                            if (piece.getYPOS() == 700) {
                                promotedColor = "White";
                                promotion = true;
                            }
                            return true;
                        } else if (piece.color().equals("B") && yChange == -100) {
                            if (piece.getYPOS() == 0) {
                                promotedColor = "Black";
                                promotion = true;

                            }
                            return true;
                        }
                    }
                }
            }

            // Capturing other pieces with pawns
            if (piece.color().equals("W") && yChange == 100 && Math.abs(xChange) == 100) {
                if ((position[((piece.getYPOS())/100)][((piece.getXPOS())/100)] != null)) {
                    if (piece.getYPOS() == 700) {
                        promotedColor = "White";
                        promotion = true;


                    }
                    return true;
                }
            } else if (piece.color().equals("B") && yChange == -100 && Math.abs(xChange) == 100) {
                if ((position[((piece.getYPOS())/100)][((piece.getXPOS())/100)] != null)) {
                    if (piece.getYPOS() == 0) {
                        promotedColor = "Black";
                        promotion = true;
                    }
                    return true;
                }
            }

            // En Passant
            if (piece.color().equals("W")) {
                if (Math.abs(xChange) == 100 && yChange == 100) {
                    if (position[piece.getYPOS()/100 - 1][piece.getXPOS()/100] != null) {
                        if (position[piece.getYPOS()/100 - 1][piece.getXPOS()/100].getName().equals("Pawn") && position[piece.getYPOS()/100 - 1][piece.getXPOS()/100].color().equals("B") && position[piece.getYPOS()/100 - 1][piece.getXPOS()/100].getEnPassant()) {
                            enPassant = true;
                            xPiece = piece.getYPOS() - 100;
                            yPiece = piece.getXPOS();
                            return true;
                        }
                    }
                }
            } else {
                if (Math.abs(xChange) == 100 && yChange == -100) {
                    if (position[piece.getYPOS()/100 + 1][piece.getXPOS()/100] != null) {
                        if (position[piece.getYPOS()/100 + 1][piece.getXPOS()/100].getName().equals("Pawn") && position[piece.getYPOS()/100 + 1][piece.getXPOS()/100].color().equals("W") && position[piece.getYPOS()/100 + 1][piece.getXPOS()/100].getEnPassant()) {
                            enPassant = true;
                            xPiece = piece.getYPOS() + 100;
                            yPiece = piece.getXPOS();
                            return true;
                        }
                    }
                }
            }

        }

        // Knights
        else if (piece.getName().equals("Knight")) {
            if (xChange == 0 || yChange == 0) {
                return false;
            } else return (Math.abs((yChange / xChange)) == 2 || Math.abs((double) yChange / (double) xChange) == 0.5) && xChange <= 200 && yChange <= 200 && xChange >= -200 && yChange >= -200;

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
                if (yChange == 0) {
                    return traceBackVH(position, piece, (piece.getYPOS()/100), piece.getXPOS()/100, xChange, yChange);
                }
            } else {
                return traceBackVH(position, piece, (piece.getYPOS()/100), piece.getXPOS()/100, xChange, yChange);
            }


        }

        // Queens
        else if (piece.getName().equals("Queen")) {
            if (xChange != 0) {
                if (yChange == 0) {
                    return traceBackVH(position, piece, (piece.getYPOS()/100), piece.getXPOS()/100, xChange, yChange);
                }
            } else {
                return traceBackVH(position, piece, (piece.getYPOS()/100), piece.getXPOS()/100, xChange, yChange);
            }
            if (Math.abs(yChange/xChange) == 1) {
                return traceBackDiagonal(position, piece, (piece.getYPOS()/100), piece.getXPOS()/100, xChange, yChange);
            }
        }

        else if (piece.getName().equals("King")) {
            // Simple Movement
            if (!(0 <= Math.abs(xChange) && Math.abs(xChange) <= 100 && 0 <= Math.abs(yChange) && Math.abs(yChange) <= 100)) {
                return false;
            }

            if ((Math.abs(yChange) == 100 && Math.abs(xChange) == 0) || (Math.abs(xChange) == 100 && Math.abs(yChange) == 0)) {
                return traceBackVH(position, piece, (piece.getYPOS()/100), piece.getXPOS()/100, xChange, yChange);
            }

            if (Math.abs(yChange) == 100 && Math.abs(xChange) == 100) {
                return traceBackDiagonal(position, piece, (piece.getYPOS() / 100), piece.getXPOS() / 100, xChange, yChange);
            }

            // Castling
            if (Math.abs(yChange) == 0 && Math.abs(xChange) >= 200) {

            }
        }

        return false;
    }

    public static boolean traceBackDiagonal(MyActor[][] position, MyActor piece, int x, int y, int xChange, int yChange) {
        if (xChange > 0 && yChange > 0) {
            if (position[x - 1][y - 1] == null) {
                return traceBackDiagonal(position, piece, x - 1, y - 1, xChange, yChange);
            } else return position[x - 1][y - 1] == piece;
        } else if (xChange > 0 && yChange < 0) {
            if (position[x + 1][y - 1] == null) {
                return traceBackDiagonal(position, piece, x + 1, y - 1, xChange, yChange);
            } else return position[x + 1][y - 1] == piece;
        } else if (xChange < 0 && yChange > 0) {
            if (position[x - 1][y + 1] == null) {
                return traceBackDiagonal(position, piece, x - 1, y + 1, xChange, yChange);
            } else return position[x - 1][y + 1] == piece;
        } else if (xChange < 0 && yChange < 0) {
            if (position[x + 1][y + 1] == null) {
                return traceBackDiagonal(position, piece, x + 1, y + 1, xChange, yChange);
            } else return position[x + 1][y + 1] == piece;
        }

        return false;
    }

    public static boolean traceBackVH(MyActor[][] position, MyActor piece, int x, int y, int xChange, int yChange) {

        if (xChange > 0) {
            if (position[x][y - 1] == null) {
                return traceBackVH(position, piece, x, y - 1, xChange, yChange);
            } else return position[x][y - 1] == piece;
        } else if (xChange < 0) {
            if (position[x][y + 1] == null) {
                return traceBackVH(position, piece, x, y + 1, xChange, yChange);
            } else return position[x][y + 1] == piece;
        } else if (yChange > 0) {
            if (position[x - 1][y] == null) {
                return traceBackVH(position, piece, x - 1, y, xChange, yChange);
            } else return position[x - 1][y] == piece;
        } else if (yChange < 0) {
            if (position[x + 1][y] == null) {
                return traceBackVH(position, piece, x + 1, y, xChange, yChange);
            } else return position[x + 1][y] == piece;
        }

        return false;
    }

    public static boolean kingInCheck(MyActor[][] position, int x, int y, MyActor piece) {
        // Check Pawns
        if (position[x][y] == null) {
            x = piece.getXPOS()/100;
            y = piece.getYPOS()/100;
        }
        if (position[y][x].color().equals("B")) {
            if ((y - 1) >= 0 && (x + 1) <= 7) {
                if (position[y - 1][x + 1] != null) {
                    if (!position[y - 1][x + 1].color().equals(position[y][x].color()) && position[y - 1][x + 1].getName().equals("Pawn")) {
                        return true;
                    }
                }
            }

            if ((y - 1) >= 0 && (x - 1) >= 0) {
                if (position[y - 1][x - 1] != null) {
                    if (!position[y - 1][x - 1].color().equals(position[y][x].color()) && position[y - 1][x - 1].getName().equals("Pawn")) {
                        return true;
                    }
                }
            }
        } else {
            if ((y + 1) <= 7 && (x + 1) <= 7) {
                if (position[y + 1][x + 1] != null) {
                    if (!position[y + 1][x + 1].color().equals(position[y][x].color()) && position[y + 1][x + 1].getName().equals("Pawn")) {
                        return true;
                    }
                }
            }

            if ((y + 1) <= 7 && (x - 1) >= 0) {
                if (position[y + 1][x - 1] != null) {
                    if (!position[y + 1][x - 1].color().equals(position[y][x].color()) && position[y + 1][x - 1].getName().equals("Pawn")) {
                        return true;
                    }
                }
            }
        }

        // Check Knights
        if ((y + 1) <= 7 && (x + 2) <= 7) {
            if (position[y + 1][x + 2] != null) {
                if (!position[y + 1][x + 2].color().equals(position[y][x].color()) && position[y + 1][x + 2].getName().equals("Knight")) {
                    return true;
                }
            }
        }
        if ((y + 1)<= 7 && (x - 2) >= 0) {
            if (position[y + 1][x - 2] != null) {
                if (!position[y + 1][x - 2].color().equals(position[y][x].color()) && position[y + 1][x - 2].getName().equals("Knight")) {
                    return true;
                }
            }
        }
        if ((y + 2) <= 7 && (x + 1) <= 7) {
            if (position[y + 2][x + 1] != null) {
                if (!position[y + 2][x + 1].color().equals(position[y][x].color()) && position[y + 2][x + 1].getName().equals("Knight")) {
                    return true;
                }
            }
        }
        if ((y + 2) <= 7 && (x - 1) >= 0) {
            if (position[y + 2][x - 1] != null) {
                if (!position[y + 2][x - 1].color().equals(position[y][x].color()) && position[y + 2][x - 1].getName().equals("Knight")) {
                    return true;
                }
            }
        }
        if ((y - 1) >= 0 && (x + 2) <= 7) {
            if (position[y - 1][x + 2] != null) {
                if (!position[y - 1][x + 2].color().equals(position[y][x].color()) && position[y - 1][x + 2].getName().equals("Knight")) {
                    return true;
                }
            }
        }
        if ((y - 1) >= 0 && (x - 2) >= 0) {
            if (position[y - 1][x - 2] != null) {
                if (!position[y - 1][x - 2].color().equals(position[y][x].color()) && position[y - 1][x - 2].getName().equals("Knight")) {
                    return true;
                }
            }
        }
        if ((y - 2) >= 0 && (x + 1) <= 7) {
            if (position[y - 2][x + 1] != null) {
                if (!position[y - 2][x + 1].color().equals(position[y][x].color()) && position[y - 2][x + 1].getName().equals("Knight")) {
                    return true;
                }
            }
        }
        if ((y - 2) >= 0 && (x - 1) >= 0) {
            if (position[y - 2][x - 1] != null) {
                if (!position[y - 2][x - 1].color().equals(position[y][x].color()) && position[y - 2][x - 1].getName().equals("Knight")) {
                    return true;
                }
            }
        }

        // Check Vertical
        for (int i = y + 1; i <= 7; i++) {
            if (position[i][x] != null) {
                if (!position[i][x].color().equals(position[y][x].color())) {
                    if (position[i][x].getName().equals("Rook") || position[i][x].getName().equals("Queen")) {
                        return true;
                    } else {
                        break;
                    }
                } else {
                    break;
                }
            }
        }

        for (int i = y - 1; i >= 0; i--) {
            if (position[i][x] != null) {
                if (!position[i][x].color().equals(position[y][x].color())) {
                    if (position[i][x].getName().equals("Rook") || position[i][x].getName().equals("Queen")) {
                        return true;
                    } else {
                        break;
                    }
                } else {
                    break;
                }
            }
        }

        // Check Horizontal
        for (int i = x + 1; i <= 7; i++) {
            if (position[y][i] != null){
                if (!position[y][i].color().equals(position[y][x].color())) {
                    if (position[y][i].getName().equals("Rook") || position[y][i].getName().equals("Queen")) {
                        return true;
                    } else {
                        break;
                    }
                } else {
                    break;
                }
            }
        }

        for (int i = x - 1; i >= 0; i--) {
            if (position[y][i] != null) {
                if (!position[y][i].color().equals(position[y][x].color())) {
                    if (position[y][i].getName().equals("Rook") || position[y][i].getName().equals("Queen")) {
                        return true;
                    } else {
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        // Check Diagonals
        int x1 = x + 1;
        int y1 = y + 1;
        int x2 = x - 1;
        int y2 = y - 1;
        int x3 = x - 1;
        int y3 = y + 1;
        int x4 = x + 1;
        int y4 = y - 1;

        while (x1 <= 7 && y1 <= 7) {
            if (position[y1][x1] != null) {
                if (!position[y1][x1].color().equals(position[y][x].color())) {
                    if (position[y1][x1].getName().equals("Bishop") || position[y1][x1].getName().equals("Queen")) {
                        return true;
                    } else {
                        break;
                    }
                } else {
                    break;
                }
            }
            y1++;
            x1++;
        }

        while (x2 >= 0 && y2 >= 0) {
            if (position[y2][x2] != null) {
                if (!position[y2][x2].color().equals(position[y][x].color())) {
                    if (position[y2][x2].getName().equals("Bishop") || position[y2][x2].getName().equals("Queen")) {
                        return true;
                    } else {
                        break;
                    }
                } else {
                    break;
                }
            }
            y2--;
            x2--;
        }

        while (x3 >= 0 && y3 <= 7) {
            if (position[y3][x3] != null) {
                if (!position[y3][x3].color().equals(position[y][x].color())) {
                    if (position[y3][x3].getName().equals("Bishop") || position[y3][x3].getName().equals("Queen")) {
                        return true;
                    } else {
                        break;
                    }
                } else {
                    break;
                }
            }
            y3++;
            x3--;
        }

        while (x4 <= 7 && y4 >= 0) {
            if (position[y4][x4] != null) {
                if (!position[y4][x4].color().equals(position[y][x].color())) {
                    if (position[y4][x4].getName().equals("Bishop") || position[y4][x4].getName().equals("Queen")) {
                        return true;
                    } else {
                        break;
                    }
                } else {
                    break;
                }
            }
            y4--;
            x4++;
        }

        return false;
    }



}
