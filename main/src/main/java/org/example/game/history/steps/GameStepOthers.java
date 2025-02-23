package org.example.game.history.steps;

import org.example.game.Game;
import org.example.game.GamePlayer;
import org.example.game.cards.GameCard;
import org.example.game.cards.brown.BrownBorderCard;

public class GameStepOthers extends GameStep {
    private final GameCard card;
    private final GamePlayer player;

    public GameStepOthers(Game game, GameCard card, GamePlayer sourcePlayer) {
        super(game);
        this.card = card;
        this.player = sourcePlayer;
    }

    @Override
    public String toString() {
        return "GameStepOthers{" +
                "card=" + card +
                ", player=" + player +
                '}';
    }
}
