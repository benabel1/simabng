package org.example.game.history.steps;

import org.example.game.Game;
import org.example.game.GamePlayer;
import org.example.game.cards.GameCard;

public class GameStepYourself extends GameStep{
    private final GameCard card;
    private final GamePlayer target;

    public GameStepYourself(Game game, GameCard card, GamePlayer target) {
        super(game);
        this.card = card;
        this.target = target;
    }

    @Override
    public String toString() {
        return "GameStepPlacement{" +
                "card=" + card +
                ", target=" + target +
                '}';
    }
}
