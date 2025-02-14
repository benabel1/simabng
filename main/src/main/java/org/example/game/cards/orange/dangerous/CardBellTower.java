package org.example.game.cards.orange.dangerous;

import org.example.game.cards.PokerValue;
import org.example.game.cards.Suit;
import org.example.game.cards.orange.OrangeBorderCard;

public class CardBellTower extends OrangeBorderCard {
    public CardBellTower(Suit s, PokerValue p) {
        super(s, p);
        this.cardName = "BELL TOWER";

        this.costOfActivation = 3;
    }
}
