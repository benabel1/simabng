package org.example.game.cards.brown.dangerous;

import org.example.game.cards.PokerValue;
import org.example.game.cards.Suit;

public class CardCaravan extends BrownBorderCardBoostable {
    public CardCaravan(Suit suit, PokerValue pokerValue) {
        super(suit, pokerValue);
        this.cardName = "SQUAW";
        this.boostCost = 2;
    }
}
