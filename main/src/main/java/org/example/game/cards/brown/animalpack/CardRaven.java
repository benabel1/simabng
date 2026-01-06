package org.example.game.cards.brown.animalpack;

import org.example.game.cards.DistanceAllowedTarget;
import org.example.game.cards.PokerValue;
import org.example.game.cards.Suit;
import org.example.game.cards.brown.BrownBorderCard;

public class CardRaven extends BrownBorderCard {
    public CardRaven(Suit s, PokerValue p) {
        super(s, p);
        this.cardName = "Raven";

        allowedTarget = DistanceAllowedTarget.ALL;
    }
}
