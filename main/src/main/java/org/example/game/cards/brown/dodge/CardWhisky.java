package org.example.game.cards.brown.dodge;

import org.example.game.cards.PokerValue;
import org.example.game.cards.Suit;
import org.example.game.cards.brown.BrownBorderCardWithAdditionalDiscard;

public class CardWhisky extends BrownBorderCardWithAdditionalDiscard {
    public CardWhisky(Suit s, PokerValue p) {
        super(s, p);
        this.cardName = "WHISKY";
    }

}
