package org.example.game.cards.brown.dodge;

import org.example.game.cards.PokerValue;
import org.example.game.cards.Suit;
import org.example.game.cards.brown.BrownBorderCard;

public class CardPunch extends BrownBorderCard {
    public CardPunch(Suit s, PokerValue p) {
        super(s, p);
        this.cardName = "PUNCH";
    }
}
