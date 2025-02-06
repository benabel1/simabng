package org.example.game.cards.blue.basic;

import org.example.game.cards.PokerValue;
import org.example.game.cards.Suit;
import org.example.game.cards.blue.BlueWeapon;

public class CardGun1Volcanic extends BlueWeapon {

    public CardGun1Volcanic(Suit s, PokerValue p) {
        super(s, p);
        this.cardName = "VOLCANIC";

        this.maxRange = 1;
    }

}
