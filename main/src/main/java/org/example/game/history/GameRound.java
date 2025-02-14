package org.example.game.history;

import java.util.ArrayList;

public class GameRound {
    private final ArrayList<GameTurn> turns;

    public GameRound() {
        turns = new ArrayList<>();
    }

    public ArrayList<GameTurn> getTurns() {
        return turns;
    }
}
