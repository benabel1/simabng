package org.example.game.cards.brown.dangerous;

import org.example.game.cards.PokerValue;
import org.example.game.cards.Suit;
import org.example.game.cards.brown.BrownBorderCardBoostable;

public class CardFlintlock extends BrownBorderCardBoostable {
    public CardFlintlock(Suit suit, PokerValue pokerValue) {
        super(suit, pokerValue);
        this.cardName = "FLINTLOCK";
        this.boostCost = 2;
    }
}
