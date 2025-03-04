package org.example.game.history;

import org.example.game.Game;
import org.example.game.GamePlayer;
import org.example.game.history.sequence.GameRound;
import org.example.game.history.sequence.GameTurn;

import java.util.ArrayList;

public class HistoryTracker {
    private final Game game;
    private final ArrayList<GameRound> rounds;
    private GameRound round;
    private GameTurn turn;

    public HistoryTracker(Game game) {
        this.game = game;
        rounds = new ArrayList<>();
    }

    public GameTurn getCurrentTurn() {
        return turn;
    }

    public GameRound getCurrentRound() {
        return round;
    }

    public void createRound() {
        this.round = new GameRound();
        rounds.add(round);
        game.log(0, "Round["+ rounds.size() +"]");
    }

    public void createTurn(GamePlayer player) {
        if (!rounds.isEmpty()) {
            GameTurn turn = new GameTurn(player, round);
            this.rounds.get(this.rounds.size() - 1).getTurns().add(turn);
            this.turn = turn;
        } else {
            System.err.println("None Rounds Was Created");
        }
    }

}
