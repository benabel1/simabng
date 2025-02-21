package org.example.game.cards.brown;

import org.example.game.cards.PokerValue;
import org.example.game.cards.Suit;
import org.example.game.cards.brown.BrownBorderCard;

public class BrownBorderCardBoostable extends BrownBorderCard {

    protected int boostCost;
    public BrownBorderCardBoostable(Suit s, PokerValue p) {
        super(s, p);
        this.boostCost = 4;
    }
}
