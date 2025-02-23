package org.example.game.history.sequence;

import org.example.game.GamePlayer;

public class GamePhaseDiscard extends GamePhase {
    public GamePhaseDiscard(GameTurn gameTurn, GamePlayer player) {
        super(gameTurn.getRound(), gameTurn, player);
    }

    @Override
    public String toString() {
        if (round != null && turn != null) {
            return "Discard[R:" + round.getRoundNumber() + "][T:" + turn.getTurnCount() + "]";
        } else {
            return "Discard[R:" + round + "][T:" + turn + "]";
        }
    }
}
