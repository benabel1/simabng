package org.example.game.cards.brown.dangerous;

import org.example.game.cards.PokerValue;
import org.example.game.cards.Suit;

public class CardArrow extends BrownBorderCardBoostable {
    public CardArrow(Suit suit, PokerValue pokerValue) {
        super(suit, pokerValue);
        this.cardName = "ARROW";
        this.boostCost = 1;
    }
}
