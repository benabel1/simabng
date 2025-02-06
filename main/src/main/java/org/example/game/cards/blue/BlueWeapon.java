package org.example.game.cards.blue;

import org.example.game.cards.IsWeapon;
import org.example.game.cards.PokerValue;
import org.example.game.cards.Suit;

public class BlueWeapon extends  BlueBorderCard implements IsWeapon {
    protected int maxRange;
    public BlueWeapon(Suit s, PokerValue p) {
        super(s, p);
    }

    @Override
    public int getMaxWeaponRange() {
        return maxRange;
    }
}
