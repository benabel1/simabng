package org.example.game.cards.brown.dangerous;

import org.example.game.cards.PokerValue;
import org.example.game.cards.Suit;

public class CardDuck extends BrownBorderCardBoostable {
    public CardDuck(Suit suit, PokerValue pokerValue) {
        super(suit, pokerValue);
        this.cardName = "DUCK";
        this.boostCost = 2;
    }
}
