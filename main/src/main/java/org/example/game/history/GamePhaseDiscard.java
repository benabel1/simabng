package org.example.game.history;

import org.example.game.GamePlayer;

public class GamePhaseDiscard extends GamePhase {
    public GamePhaseDiscard(GameTurn gameTurn, GamePlayer player) {
        super(gameTurn.getRound(), gameTurn, player);
    }
}
