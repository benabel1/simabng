package org.example.game.cards.orange.dangerous;

import org.example.game.cards.PokerValue;
import org.example.game.cards.Suit;
import org.example.game.cards.orange.OrangeBorderCard;

public class CardBomb extends OrangeBorderCard {
    public CardBomb(Suit s, PokerValue p) {
        super(s, p);
        this.cardName = "LOCK BOMB";

        this.costOfActivation = 3;
    }
}
