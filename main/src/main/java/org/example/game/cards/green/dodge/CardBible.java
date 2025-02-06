package org.example.game.cards.green.dodge;

import org.example.game.cards.PokerValue;
import org.example.game.cards.Suit;
import org.example.game.cards.green.GreenBorderCard;

public class CardBible extends GreenBorderCard {
    public CardBible(Suit s, PokerValue p) {
        super(s, p);
        this.cardName = "BIBLE";
    }
}
