package org.example.game.cards.orange.dangerous;

import org.example.game.cards.PokerValue;
import org.example.game.cards.Suit;
import org.example.game.cards.orange.OrangeBorderCard;

public class CardBeerKeg extends OrangeBorderCard {
    public CardBeerKeg(Suit s, PokerValue p) {
        super(s, p);
        this.cardName = "BEER KEG";

        this.costOfActivation = 3;
    }
}
