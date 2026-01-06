package org.example.game.cards;

import org.example.game.Game;
import org.example.game.GamePlayer;
import org.example.game.deck.DeckAble;
import org.example.game.history.steps.GameStep;
import org.example.game.history.steps.GameStepPlayCardOnTargetPlayer;
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
    protected DistanceAllowedTarget usageAllowedTarget;
    protected boolean canBePlayerOnDeadToo;

    public GameCard(Suit s, PokerValue p) {
        this.suit = s;
        this.poker = p;

        this.cardName = this.getClass().getName();
        setPlayableInTurnByDefault();
        canBePlayerOnDeadToo = false;
    }

    public static boolean matchCard(GameCard deckAble, IsRevealAble cardBarrel) {
        return cardBarrel.matchSuitAndPoker(deckAble);
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

    public void playCardFromHand(Game game, CardOption option, GamePlayer sourcePlayer) {
//        if (sourcePlayer != null) {
//            sourcePlayer.removeFromHand(this);
//            addRecordOfPlay();
//            game.log(2, "[" + sourcePlayer + "]"+ this + "was played");
//            if (option != null && !option.isOptionRecordedInStep()) {
//                game.markStepAndCard(option, this, new GameStep(game));
//            }
//        }
    }

    public void playCardFromHand(Game game, CardOption option, GamePlayer sourcePlayer, GamePlayer targetPlayer) {
        if (sourcePlayer != null && targetPlayer != null) {
            sourcePlayer.removeFromHand(this);
            if (option != null && !option.isOptionRecordedInStep()) {
                game.markStepAndCard(option, this, new GameStepPlayCardOnTargetPlayer(game, this, sourcePlayer, targetPlayer));
            }
        }
    }

    public void useCardInGame(Game game, OptionOption option, GamePlayer ownerPlayer) {}

    public void applyPartOfEffectOnOtherPlayer(Game game, GamePlayer sourcePlayer, GamePlayer other) {}

    public boolean canTargetEliminated() {
        return canBePlayerOnDeadToo;
    }

    public Suit getSuit() {
        return suit;
    }

    public PokerValue getPoker() {
        return poker;
    }

    protected void setPlayableInTurnByDefault() {
        this.canPlayedOnSideOfTurn = true;
        this.canPlayedOutSideOfTurn = false;
    }
}
