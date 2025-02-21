package org.example.game.history.steps;

import org.example.game.Game;
import org.example.game.GamePlayer;
import org.example.game.cards.GameCard;
import org.example.game.cards.brown.BrownBorderCard;

import java.util.List;

public class GameStepAll extends GameStep {
    private final GameCard card;
    private final GamePlayer played;

    public GameStepAll(Game game, BrownBorderCard brownBorderCard, GamePlayer sourcePlayer) {
        super(game);
        this.card = brownBorderCard;
        this.played = sourcePlayer;
    }

    @Override
    public String toString() {
        return "GameStepAll{" +
                "card=" + card +
                ", played=" + played +
                '}';
    }
}
