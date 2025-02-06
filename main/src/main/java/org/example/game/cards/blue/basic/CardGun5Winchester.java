package org.example.game.cards.blue.basic;

import org.example.game.cards.PokerValue;
import org.example.game.cards.Suit;
import org.example.game.cards.blue.BlueWeapon;

public class CardGun5Winchester extends BlueWeapon {

    public CardGun5Winchester(Suit s, PokerValue p) {
        super(s, p);
        this.cardName = "Winchester";
        this.maxRange = 5;
    }

}
