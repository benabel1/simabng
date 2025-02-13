package org.example.game.cards.green;

import org.example.game.cards.GameCard;
import org.example.game.cards.PokerValue;
import org.example.game.cards.Suit;

import static org.example.game.cards.CardBorderColor.GREEN;

public class GreenBorderCard extends GameCard {
    public GreenBorderCard(Suit s, PokerValue p) {
        super(s, p);
        //default setup values
        this.color = GREEN;
        this.canPlayedOnSideOfTurn = true;
        this.canPlayedOutSideOfTurn = false;
    }
}
