package org.example.game.history;

import org.example.game.GamePlayer;
import org.example.game.deck.DeckAble;

import java.util.ArrayList;
import java.util.List;

public class GamePhasePlay extends GamePhase {
    List<DeckAble> playedCards;
    public GamePhasePlay(GameRound gameRound, GameTurn gameTurn, GamePlayer player) {
        super(gameRound, gameTurn, player);
        playedCards = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "GamePhasePlay{" +
                "cards=" + playedCards +
                '}';
    }
}
