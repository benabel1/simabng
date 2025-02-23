package org.example.game.history.sequence;

import org.example.game.GamePlayer;

public class GamePhasePlay extends GamePhase {
    public GamePhasePlay(GameRound gameRound, GameTurn gameTurn, GamePlayer player) {
        super(gameRound, gameTurn, player);
    }

    @Override
    public String toString() {
        return "GamePhasePlay{" +
                "cards=" + playedCards +
                '}';
    }
}
