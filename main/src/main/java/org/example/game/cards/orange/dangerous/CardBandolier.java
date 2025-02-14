package org.example.game.cards.orange.dangerous;

import org.example.game.cards.PokerValue;
import org.example.game.cards.Suit;
import org.example.game.cards.orange.OrangeBorderCard;

public class CardBandolier extends OrangeBorderCard {
    public CardBandolier(Suit s, PokerValue p) {
        super(s, p);
        this.cardName = "BANDOLIER";

        this.costOfActivation = 3;
    }
}
