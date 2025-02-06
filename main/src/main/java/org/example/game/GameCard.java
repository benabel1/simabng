package org.example.game;

import org.example.game.cards.DeckAble;
import org.example.game.cards.PokerValue;
import org.example.game.cards.Suit;

public class GameCard extends DeckAble {
    protected final Suit suit;
    protected final PokerValue poker;

    public GameCard(Suit s, PokerValue p) {
        this.suit = s;
        this.poker = p;
    }
}
