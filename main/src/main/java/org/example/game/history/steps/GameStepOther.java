package org.example.game.history.steps;

import org.example.game.Game;
import org.example.game.GamePlayer;
import org.example.game.cards.GameCard;
import org.example.game.cards.brown.BrownBorderCard;

public class GameStepOther extends GameStep {
    private final GameCard card;
    private final GamePlayer player;

    public GameStepOther(Game game, GameCard card, GamePlayer sourcePlayer) {
        super(game);
        this.card = card;
        this.player = sourcePlayer;
    }

    @Override
    public String toString() {
        return "GameStepOther{" +
                "card=" + card +
                ", player=" + player +
                '}';
    }
}
