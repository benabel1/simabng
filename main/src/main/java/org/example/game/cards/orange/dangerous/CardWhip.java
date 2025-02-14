package org.example.game.cards.orange.dangerous;

import org.example.game.cards.PokerValue;
import org.example.game.cards.Suit;
import org.example.game.cards.green.GreenBorderCard;
import org.example.game.cards.orange.OrangeBorderCard;

public class CardWhip extends OrangeBorderCard {
    public CardWhip(Suit s, PokerValue p) {
        super(s, p);
        this.cardName = "WHIP";

        this.costOfActivation = 3;
    }
}
