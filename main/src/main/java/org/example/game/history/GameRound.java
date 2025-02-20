package org.example.game.history;

import java.util.ArrayList;
import java.util.HashMap;

public class GameRound {
    private final int roundNumber;
    private final ArrayList<GameTurn> turns;
    public static HashMap<Integer, GameRound> roundsTable = new HashMap<>();

    public GameRound() {
        turns = new ArrayList<>();
        roundNumber = roundsTable.size();
        roundsTable.put(roundNumber, this);
    }

    public ArrayList<GameTurn> getTurns() {
        return turns;
    }
}
