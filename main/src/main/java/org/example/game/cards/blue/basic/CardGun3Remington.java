package org.example.game.cards.blue.basic;

import org.example.game.cards.PokerValue;
import org.example.game.cards.Suit;
import org.example.game.cards.blue.BlueWeapon;

public class CardGun3Remington extends BlueWeapon {

    public CardGun3Remington(Suit s, PokerValue p) {
        super(s, p);
        this.cardName = "REMINGTON";

        this.maxRange = 3;
    }

}
