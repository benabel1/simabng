package org.example.game.cards.brown.greatplains;

import org.example.game.cards.PokerValue;
import org.example.game.cards.Suit;
import org.example.game.cards.brown.BrownBorderCard;

public class CardSmokeSignals extends BrownBorderCard {
    public CardSmokeSignals(Suit s, PokerValue p) {
        super(s, p);
        this.cardName = "Smoke signals";
        this.textOnCard = "You and chosen player secretly show hand or Role card. You may exchange one hand or front card or even Role card, if both agree.";
    }
}
