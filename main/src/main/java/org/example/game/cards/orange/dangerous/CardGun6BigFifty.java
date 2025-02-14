package org.example.game.cards.orange.dangerous;

import org.example.game.cards.PokerValue;
import org.example.game.cards.Suit;
import org.example.game.cards.orange.OrangeBorderCard;

public class CardGun6BigFifty extends OrangeBorderCard {
    public CardGun6BigFifty(Suit s, PokerValue p) {
        super(s, p);
        this.cardName = "BELL TOWER";

        this.costOfActivation = 1;
    }
}
