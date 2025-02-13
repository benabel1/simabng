package org.example.game.cards;

import org.example.game.Game;
import org.example.game.GamePlayer;
import org.example.game.options.CardOption;
import org.example.game.options.OptionOption;

public class GameCard extends DeckAble {
    protected final Suit suit;
    protected final PokerValue poker;

    protected CardBorderColor color;
    protected boolean canPlayedOnSideOfTurn;
    protected boolean canPlayedOutSideOfTurn;
    protected boolean canUsedOnSideOfTurn;
    protected boolean canUsedOutSideOfTurn;
    protected boolean canUsedFromPlayOnSideOfTurn;
    protected boolean canUsedFromPlayOutSideOfTurn;

    protected int distanceMax;
    protected DistanceAllowedTarget allowedTarget;

    public GameCard(Suit s, PokerValue p) {
        this.suit = s;
        this.poker = p;
    }

    @Override
    public String toString() {
        return "[" + suit + poker+ "]" + cardName;
    }

    @Override
    public boolean canBePlay(Game game) {
        return true;
    }

    @Override
    public OptionOption generateOption(DeckAble card, GamePlayer gamePlayer) {
        return new CardOption((GameCard) card, gamePlayer);
    }

    public void playCard(Game game, GamePlayer sourcePlayer) {
    }
}
