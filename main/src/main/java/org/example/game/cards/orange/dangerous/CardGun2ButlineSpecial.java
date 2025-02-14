package org.example.game.cards.orange.dangerous;

import org.example.game.cards.PokerValue;
import org.example.game.cards.Suit;
import org.example.game.cards.orange.OrangeBorderCard;

public class CardGun2ButlineSpecial extends OrangeBorderCard {
    public CardGun2ButlineSpecial(Suit s, PokerValue p) {
        super(s, p);
        this.cardName = "BELL TOWER";

        this.costOfActivation = 3;
    }
}
