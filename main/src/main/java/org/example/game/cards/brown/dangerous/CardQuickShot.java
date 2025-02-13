package org.example.game.cards.brown.dangerous;

import org.example.game.cards.PokerValue;
import org.example.game.cards.Suit;

public class CardQuickShot extends BrownBorderCardBoostable {
    public CardQuickShot(Suit suit, PokerValue pokerValue) {
        super(suit, pokerValue);
        this.cardName = "QUIT SHOT";
        this.boostCost = 1;
    }
}
