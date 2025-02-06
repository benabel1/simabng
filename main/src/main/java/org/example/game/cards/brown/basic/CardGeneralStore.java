package org.example.game.cards.brown.basic;

import org.example.game.cards.PokerValue;
import org.example.game.cards.Suit;
import org.example.game.cards.brown.BrownBorderCard;

public class CardGeneralStore extends BrownBorderCard {
    public CardGeneralStore(Suit suit, PokerValue pokerValue) {
        super(suit, pokerValue);
        this.cardName = "GENERAL STORE";
    }
}
