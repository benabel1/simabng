package org.example.game.cards.blue.basic;

import org.example.game.cards.DistanceAllowedTarget;
import org.example.game.cards.PokerValue;
import org.example.game.cards.IsRevealAble;
import org.example.game.cards.Suit;
import org.example.game.cards.blue.BlueBorderCard;

public class CardJail extends BlueBorderCard implements IsRevealAble {

    public CardJail(Suit s, PokerValue p) {
        super(s, p);
        this.cardName = "JAIL";

        this.allowedTarget =  DistanceAllowedTarget.OTHER_THAN_SHERIFF;
    }

    @Override
    public String getPriorityType() {
        return getCardName();
    }

}
