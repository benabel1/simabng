package org.example.game.cards.brown.basic;

import org.example.game.cards.DistanceAllowedTarget;
import org.example.game.cards.PokerValue;
import org.example.game.cards.Suit;
import org.example.game.cards.brown.BrownBorderCard;

public class CardGatling extends BrownBorderCard {
    public CardGatling(Suit suit, PokerValue pokerValue) {
        super(suit, pokerValue);
        this.cardName = "GATLING";

        this.allowedTarget = DistanceAllowedTarget.OTHERS;
    }
}
