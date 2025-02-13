package org.example.game.history;

import org.example.game.Game;
import org.example.game.GamePlayer;

import java.util.ArrayList;

public class HistoryTracker {
    private final Game game;
    private final ArrayList<GameTurn> turns;
    private final ArrayList<GameRound> rounds;

    public HistoryTracker(Game game) {
        this.game = game;
        turns = new ArrayList<>();
        rounds = new ArrayList<>();
    }

    public GameTurn getCurrentTurn() {
        return turns.get(0);
    }

    public void createRound() {
        rounds.add(new GameRound());
    }

    public void createTurn(GamePlayer player) {
        turns.add(new GameTurn(player));
    }

}
