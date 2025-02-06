package org.example.game.cards.brown.basic;

import org.example.game.cards.PokerValue;
import org.example.game.cards.Suit;
import org.example.game.GameCard;

public class CardBeer extends BrownBorderCard {
    public CardBeer(Suit suit, PokerValue pokerValue) {
        super(suit, pokerValue);
        this.cardName = "BEER";
    }
}
