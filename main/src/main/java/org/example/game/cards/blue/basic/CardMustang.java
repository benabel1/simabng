package org.example.game.cards.blue.basic;

import org.example.game.cards.IsDistance;
import org.example.game.cards.PokerValue;
import org.example.game.cards.Suit;
import org.example.game.cards.blue.BlueBorderCard;

public class CardMustang extends BlueBorderCard implements IsDistance {

    public CardMustang(Suit s, PokerValue p) {
        super(s, p);
        this.cardName = "MUSTANG";
    }

}
