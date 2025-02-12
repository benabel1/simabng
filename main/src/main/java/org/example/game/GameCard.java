package org.example.game;

import org.example.game.cards.*;
import org.example.game.options.CardOption;
import org.example.game.options.OptionOption;

public class GameCard extends DeckAble {
    protected final Suit suit;
    protected final PokerValue poker;

    protected CardBorderColor color;
    protected boolean canPlayedOnSideOfTurn;
    protected boolean canPlayedOutSideOfTurn;

    protected int distanceMax;
    protected DistanceAllowedTarget alloedTarget;

    public GameCard(Suit s, PokerValue p) {
        this.suit = s;
        this.poker = p;
    }

    @Override
    public String toString() {
        return "[" + suit + poker+ "]" + cardName;
    }

    @Override
    public boolean canBePlay() {
        return true;
    }

    @Override
    public OptionOption generateOption(DeckAble card, GamePlayer gamePlayer) {
        return new CardOption((GameCard) card, gamePlayer);
    }
}
