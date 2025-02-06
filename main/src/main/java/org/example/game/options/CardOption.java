package org.example.game.options;

import org.example.game.GameCard;
import org.example.game.GamePlayer;

public class CardOption extends OptionOption {

    private final GameCard cardSource;
    private final Object sourcePlayer;

    public CardOption(GameCard card, GamePlayer player) {
        this.cardSource = card;
        this.sourcePlayer = player;
    }

    @Override
    public String toString() {
        return cardSource + " - " + sourcePlayer;
    }
}
