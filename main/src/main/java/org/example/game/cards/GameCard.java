package org.example.game.cards;

import org.example.game.Game;
import org.example.game.GamePlayer;
import org.example.game.deck.DeckAble;
import org.example.game.options.CardOption;
import org.example.game.options.OptionOption;

public abstract class GameCard extends DeckAble {
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

        this.cardName = this.getClass().getName();
    }

    @Override
    public String toString() {
        return "[" + suit + poker+ "]" + cardName;
    }

    @Override
    public boolean canBePlayedFromHand(Game game, GamePlayer player) {
        System.out.println("Not implemented for card: " + this);
        return false;
    }

    @Override
    public boolean canBeUsedInGame(Game game) {
        return  true;
    }

    @Override
    public OptionOption generateOption(DeckAble card, GamePlayer gamePlayer) {
        return new CardOption((GameCard) card, gamePlayer);
    }

    public void playCardFromHand(Game game, GamePlayer sourcePlayer) {
        if (sourcePlayer != null) {
            sourcePlayer.removeFromHand(this);
            addRecordOfPlay();
            game.log(2, "[" + sourcePlayer + "]"+ this + "was played");
        }
    }

    public void playCardFromHand(Game game, GamePlayer sourcePlayer, GamePlayer targetPlayer) {
        if (sourcePlayer != null && targetPlayer != null) {
            sourcePlayer.removeFromHand(this);
            addRecordOfPlay();
            game.log(2, "[" + sourcePlayer + "]"+ this + "was played on " + targetPlayer);
        }
    }

    public void useCardInGame(Game game, GamePlayer ownerPlayer) {}

    public void applyPartOfEffectOnOtherPlayer(Game game, GamePlayer sourcePlayer, GamePlayer other) {}
}
