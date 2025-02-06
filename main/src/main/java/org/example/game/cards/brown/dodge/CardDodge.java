package org.example.game.cards.brown.dodge;

import org.example.game.cards.PokerValue;
import org.example.game.cards.Suit;
import org.example.game.cards.brown.BrownBorderCard;

public class CardDodge extends BrownBorderCard {
    public CardDodge(Suit s, PokerValue p) {
        super(s, p);
        this.cardName = "DODGE";

        this.canPlayedOnSideOfTurn = false;
        this.canPlayedOutSideOfTurn = true;
    }
}
