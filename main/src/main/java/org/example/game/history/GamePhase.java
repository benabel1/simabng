package org.example.game.history;

import org.example.game.GamePlayer;

import java.util.ArrayList;
import java.util.List;

public class GamePhase {
    protected GamePlayer player;
    protected GameTurn turn;
    protected List<GameStep> steps;

    public GamePhase(GameTurn gameTurn, GamePlayer player) {
        this.player = player;
        this.turn = gameTurn;

        steps = new ArrayList<>();
    }
}
