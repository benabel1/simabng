package org.example.game.cards.orange.dangerous;

import org.example.game.cards.PokerValue;
import org.example.game.cards.Suit;
import org.example.game.cards.orange.OrangeBorderCard;

public class CardCreate extends OrangeBorderCard {
    public CardCreate(Suit s, PokerValue p) {
        super(s, p);
        this.cardName = "CREATE";

        this.costOfActivation = 2;
    }
}
