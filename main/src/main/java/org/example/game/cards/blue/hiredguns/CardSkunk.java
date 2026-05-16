package org.example.game.cards.blue.hiredguns;

import org.example.game.cards.ITimeDurationAble;
import org.example.game.cards.PokerValue;
import org.example.game.cards.Suit;
import org.example.game.cards.blue.BlueBorderCard;

public class CardSkunk extends BlueBorderCard implements ITimeDurationAble {

    public CardSkunk(Suit s, PokerValue p) {
        super(s, p);
        this.cardName = "CardSkunk";
        this.textOnCard = "You has none ability until end of your next turn";
    }

    @Override
    public void f() {

    }
}
