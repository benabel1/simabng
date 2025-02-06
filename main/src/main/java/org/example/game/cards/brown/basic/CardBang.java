package org.example.game.cards.brown.basic;

import org.example.game.cards.PokerValue;
import org.example.game.cards.Suit;
import org.example.game.cards.brown.BrownBorderCard;

public class CardBang extends BrownBorderCard {

    public CardBang(Suit s, PokerValue p) {
        super(s, p);
        this.cardName = "BANG!";
    }

}
