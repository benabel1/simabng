package org.example.game.cards.green.hiredguns;

import org.example.game.cards.PokerValue;
import org.example.game.cards.Suit;
import org.example.game.cards.green.GreenBorderCard;

public class CardFourLeafClover extends GreenBorderCard {
    public CardFourLeafClover(Suit s, PokerValue p) {
        super(s, p);
        this.cardName = "Chosen player choose result of his reveal(BARREL works, DYNAMITE explodes, JAIL not works, ...).";
    }
}
