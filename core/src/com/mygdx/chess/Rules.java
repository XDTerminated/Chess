package com.mygdx.chess;
import java.util.*;

public class Rules {
    public static boolean isLegal(ArrayList<MyActor> position, String turn) {
        return false;
    }

    public static String turn(String move) {
        if (move.equals("White")) {
            move = "Black";
        } else {
            move = "White";
        }

        return move;
    }
}
