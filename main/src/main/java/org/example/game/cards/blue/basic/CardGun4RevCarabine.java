package org.example.game.cards.blue.basic;

import org.example.game.cards.PokerValue;
import org.example.game.cards.Suit;
import org.example.game.cards.blue.BlueWeapon;

public class CardGun4RevCarabine extends BlueWeapon {

    public CardGun4RevCarabine(Suit s, PokerValue p) {
        super(s, p);
        this.cardName = "CARABINE";

        this.maxRange = 4;
    }

}
