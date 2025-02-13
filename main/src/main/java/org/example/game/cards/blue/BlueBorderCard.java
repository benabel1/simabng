package org.example.game.cards.blue;

import org.example.game.cards.GameCard;
import org.example.game.cards.PokerValue;
import org.example.game.cards.Suit;

import static org.example.game.cards.CardBorderColor.BLUE;

public class BlueBorderCard extends GameCard {
    public BlueBorderCard(Suit s, PokerValue p) {
        super(s, p);
        //default setup values
        this.color = BLUE;
        this.canPlayedOnSideOfTurn = true;
        this.canPlayedOutSideOfTurn = false;
    }
}
