package org.example.game.cards.blue.basic;

import org.example.game.cards.IsReach;
import org.example.game.cards.PokerValue;
import org.example.game.cards.Suit;
import org.example.game.cards.blue.BlueBorderCard;

public class CardScope extends BlueBorderCard implements IsReach {

    public CardScope(Suit s, PokerValue p) {
        super(s, p);
        this.cardName = "SCOPE";
    }

}
