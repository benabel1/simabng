package org.example.game.options;

import org.example.game.GamePlayer;
import org.example.game.cards.GameCard;

public class FantonCardOption extends CardOption {

    protected GameCard phantomCard;
    public FantonCardOption(GameCard card, GameCard phantom, GamePlayer player) {
        super(card, player);
        this.phantomCard = phantom;
    }
}
