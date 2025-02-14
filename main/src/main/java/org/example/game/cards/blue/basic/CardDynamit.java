package org.example.game.cards.blue.basic;

import org.example.game.cards.PokerValue;
import org.example.game.cards.RevealAble;
import org.example.game.cards.Suit;
import org.example.game.cards.blue.BlueBorderCard;

public class CardDynamit extends BlueBorderCard implements RevealAble {

    public CardDynamit(Suit s, PokerValue p) {
        super(s, p);
        this.cardName = "DYNAMITE";
    }

    @Override
    public int getPriority() {
        return 0;
    }

    @Override
    public String getPriorityType() {
        return getCardName();
    }
}
