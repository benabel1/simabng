package org.example.game.cards.brown.dangerous;

import org.example.game.cards.PokerValue;
import org.example.game.cards.Suit;
import org.example.game.cards.brown.BrownBorderCard;

public class CardReloading extends BrownBorderCard {
    public CardReloading(Suit suit, PokerValue pokerValue) {
        super(suit, pokerValue);
        this.cardName = "RELOADING";
    }
}
