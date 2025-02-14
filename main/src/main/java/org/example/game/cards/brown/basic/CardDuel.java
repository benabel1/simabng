package org.example.game.cards.brown.basic;

import org.example.game.cards.DistanceAllowedTarget;
import org.example.game.cards.PokerValue;
import org.example.game.cards.Suit;
import org.example.game.cards.brown.BrownBorderCard;

public class CardDuel extends BrownBorderCard {
    public CardDuel(Suit suit, PokerValue pokerValue) {
        super(suit, pokerValue);
        this.cardName = "DUEL";

        this.allowedTarget = DistanceAllowedTarget.OTHER;
        this.canPlayedOnSideOfTurn = true;
    }
}
