package org.example.game.cards.orange.dangerous;

import org.example.game.cards.PokerValue;
import org.example.game.cards.Suit;
import org.example.game.cards.orange.OrangeBorderCard;

public class CardGun1DoubleBarrel extends OrangeBorderCard {
    public CardGun1DoubleBarrel(Suit s, PokerValue p) {
        super(s, p);
        this.cardName = "DOUBLE BARREL";

        this.costOfActivation = 1;
    }
}
