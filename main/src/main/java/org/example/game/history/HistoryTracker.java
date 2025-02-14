package org.example.game.history;

import org.example.game.Game;
import org.example.game.GamePlayer;

import java.util.ArrayList;

public class HistoryTracker {
    private final Game game;
    private final ArrayList<GameRound> rounds;
    private GameTurn turn;

    public HistoryTracker(Game game) {
        this.game = game;
        rounds = new ArrayList<>();
    }

    public GameTurn getCurrentTurn() {
        return turn;
    }

    public void createRound() {
        rounds.add(new GameRound());
        game.log(0, "Round["+ rounds.size() +"]");
    }

    public void createTurn(GamePlayer player) {
        GameTurn turn = new GameTurn(player);
        if (!rounds.isEmpty()) {
            this.rounds.get(this.rounds.size() - 1).getTurns().add(turn);
            this.turn = turn;
        } else {
            System.err.println("None Rounds Was Created");
        }
    }

}
