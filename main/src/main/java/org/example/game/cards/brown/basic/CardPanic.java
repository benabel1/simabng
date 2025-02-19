package org.example.game.cards.brown.basic;

import org.example.game.cards.DistanceAllowedTarget;
import org.example.game.cards.PokerValue;
import org.example.game.cards.Suit;
import org.example.game.cards.brown.BrownBorderCard;

public class CardPanic extends BrownBorderCard {
    public CardPanic(Suit suit, PokerValue pokerValue) {
        super(suit, pokerValue);
        this.cardName = "PANIC";

        this.allowedTarget = DistanceAllowedTarget.SPECIFIC_RANGE;
        this.distanceMax = 1;
    }
}
