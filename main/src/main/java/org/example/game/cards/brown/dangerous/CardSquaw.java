package org.example.game.cards.brown.dangerous;

import org.example.game.cards.PokerValue;
import org.example.game.cards.Suit;
import org.example.game.cards.brown.BrownBorderCardBoostable;

public class CardSquaw extends BrownBorderCardBoostable {
    public CardSquaw(Suit suit, PokerValue pokerValue) {
        super(suit, pokerValue);
        this.cardName = "SQUAW";
        this.boostCost = 2;
    }
}
