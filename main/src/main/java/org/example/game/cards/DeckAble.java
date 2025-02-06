package org.example.game.cards;

import org.example.game.GamePlayer;
import org.example.game.OptionOption;

public class DeckAble {
    protected String cardName;
    boolean cardWasShown;

    public String getCardName() {
        return cardName;
    }

    public boolean canBePlay() {
        return false;
    }

    public OptionOption generateOption(DeckAble card, GamePlayer gamePlayer) {
        return null;
    }
}
