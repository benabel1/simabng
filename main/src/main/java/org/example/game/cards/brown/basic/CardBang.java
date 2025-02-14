package org.example.game.cards.brown.basic;

import org.example.game.Game;
import org.example.game.cards.DistanceAllowedTarget;
import org.example.game.cards.PokerValue;
import org.example.game.cards.Suit;
import org.example.game.cards.brown.BrownBorderCard;

public class CardBang extends BrownBorderCard {

    public CardBang(Suit s, PokerValue p) {
        super(s, p);
        this.cardName = "BANG!";

        this.allowedTarget = DistanceAllowedTarget.WEAPON_RANGE;
    }

    @Override
    public boolean canBePlayedFromHand(Game game) {
        return game.wasPlayedLessThan(this, 1);
    }
}
