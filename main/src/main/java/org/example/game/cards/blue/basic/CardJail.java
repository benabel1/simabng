package org.example.game.cards.blue.basic;

import org.example.game.cards.PokerValue;
import org.example.game.cards.Suit;
import org.example.game.cards.blue.BlueBorderCard;

public class CardJail extends BlueBorderCard {

    public CardJail(Suit s, PokerValue p) {
        super(s, p);
        this.cardName = "JAIL";
    }

}
