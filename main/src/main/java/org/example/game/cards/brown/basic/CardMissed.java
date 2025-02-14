package org.example.game.cards.brown.basic;

import org.example.game.cards.DistanceAllowedTarget;
import org.example.game.cards.PokerValue;
import org.example.game.cards.Suit;
import org.example.game.cards.brown.BrownBorderCard;

public class CardMissed extends BrownBorderCard {
    public CardMissed(Suit suit, PokerValue pokerValue) {
        super(suit, pokerValue);
        this.cardName = "MISSED!";
        this.canPlayedOnSideOfTurn = false;
        this.canPlayedOutSideOfTurn = true;

        this.allowedTarget = DistanceAllowedTarget.MYSELF;
    }
}
