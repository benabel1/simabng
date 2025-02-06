package org.example.game.cards.brown;

import org.example.game.GameCard;
import org.example.game.cards.PokerValue;
import org.example.game.cards.Suit;

import static org.example.game.cards.CardBorderColor.BROWN;

public class BrownBorderCard extends GameCard {
    public BrownBorderCard(Suit s, PokerValue p) {
        super(s, p);
        //default setup values
        this.color = BROWN;
        this.canPlayedOnSideOfTurn = true;
        this.canPlayedOutSideOfTurn = false;
    }
}
