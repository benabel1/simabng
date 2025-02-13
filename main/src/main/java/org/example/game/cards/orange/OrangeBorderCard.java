package org.example.game.cards.orange;

import org.example.game.cards.GameCard;
import org.example.game.cards.PokerValue;
import org.example.game.cards.Suit;

import static org.example.game.cards.CardBorderColor.ORANGE;

public class OrangeBorderCard extends GameCard {
    public OrangeBorderCard(Suit s, PokerValue p) {
        super(s, p);
        //default setup values
        this.color = ORANGE;
        this.canPlayedOnSideOfTurn = true;
        this.canPlayedOutSideOfTurn = false;
        this.canUsedOnSideOfTurn = true;
        this.canUsedOutSideOfTurn = true;
    }
}
