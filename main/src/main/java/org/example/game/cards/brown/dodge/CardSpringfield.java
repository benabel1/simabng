package org.example.game.cards.brown.dodge;

import org.example.game.cards.PokerValue;
import org.example.game.cards.Suit;
import org.example.game.cards.brown.BrownBorderCard;
import org.example.game.cards.brown.BrownBorderCardWithAdditionalDiscard;

public class CardSpringfield extends BrownBorderCardWithAdditionalDiscard {
    public CardSpringfield(Suit s, PokerValue p) {
        super(s, p);
        this.cardName = "SPRINGFIELD";
    }
}
