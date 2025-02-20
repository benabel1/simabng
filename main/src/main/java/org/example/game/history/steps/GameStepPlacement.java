package org.example.game.history.steps;

import org.example.game.GamePlayer;
import org.example.game.cards.GameCard;

public class GameStepPlacement {
    private final GameCard card;
    private final GamePlayer player;
    private final GamePlayer target;

    public GameStepPlacement(GameCard card, GamePlayer player, GamePlayer target) {
        this.card = card;
        this.player = player;
        this.target = target;
    }

    @Override
    public String toString() {
        return "GameStepPlacement{" +
                "card=" + card +
                ", player=" + player +
                ", target=" + target +
                '}';
    }
}
