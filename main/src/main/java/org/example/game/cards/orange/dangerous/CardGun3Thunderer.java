package org.example.game.cards.orange.dangerous;

import org.example.game.cards.PokerValue;
import org.example.game.cards.Suit;
import org.example.game.cards.orange.OrangeBorderCard;

public class CardGun3Thunderer extends OrangeBorderCard {
    public CardGun3Thunderer(Suit s, PokerValue p) {
        super(s, p);
        this.cardName = "THUNDERER";

        this.costOfActivation = 1;
    }
}
