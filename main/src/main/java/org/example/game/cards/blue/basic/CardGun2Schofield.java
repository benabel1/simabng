package org.example.game.cards.blue.basic;

import org.example.game.cards.PokerValue;
import org.example.game.cards.Suit;
import org.example.game.cards.blue.BlueWeapon;

public class CardGun2Schofield extends BlueWeapon {

    public CardGun2Schofield(Suit s, PokerValue p) {
        super(s, p);
        this.cardName = "SCHOFIELD";

        this.maxRange = 2;
    }

}
