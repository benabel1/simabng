package org.example.game;

import org.example.game.cards.CardBorderColor;
import org.example.game.cards.DeckAble;
import org.example.game.cards.PokerValue;
import org.example.game.cards.Suit;

public class GameCard extends DeckAble {
    protected final Suit suit;
    protected final PokerValue poker;

    protected CardBorderColor color;
    protected boolean canPlayedOnSideOfTurn;
    protected boolean canPlayedOutSideOfTurn;

    public GameCard(Suit s, PokerValue p) {
        this.suit = s;
        this.poker = p;
    }
}
