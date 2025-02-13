package org.example.game.cards;

import org.example.game.Game;
import org.example.game.GamePlayer;
import org.example.game.options.OptionOption;

public class DeckAble {
    protected String cardName;
    boolean cardWasShown;

    public String getCardName() {
        return cardName;
    }

    public boolean canBePlay(Game game) {
        return true;
    }

    public OptionOption generateOption(DeckAble card, GamePlayer gamePlayer) {
        return null;
    }
}
