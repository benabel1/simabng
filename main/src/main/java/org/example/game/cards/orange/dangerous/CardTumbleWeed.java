package org.example.game.cards.orange.dangerous;

import org.example.game.cards.PokerValue;
import org.example.game.cards.Suit;
import org.example.game.cards.orange.OrangeBorderCard;

public class CardTumbleWeed extends OrangeBorderCard {
    public CardTumbleWeed(Suit s, PokerValue p) {
        super(s, p);
        this.cardName = "THUMBLE WEED";

        this.costOfActivation = 1;
    }
}
