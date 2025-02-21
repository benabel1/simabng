package org.example.game.cards.brown;

import org.example.game.Game;
import org.example.game.GamePlayer;
import org.example.game.cards.DistanceAllowedTarget;
import org.example.game.cards.GameCard;
import org.example.game.cards.PokerValue;
import org.example.game.cards.Suit;
import org.example.game.deck.DeckAble;
import org.example.game.deck.DeckName;
import org.example.game.history.steps.GameStepAll;
import org.example.game.history.steps.GameStepOther;
import org.example.game.history.steps.GameStepOthers;
import org.example.game.history.steps.GameStepYourself;
import org.example.game.options.*;

import static org.example.game.cards.CardBorderColor.BROWN;

public class BrownBorderCard extends GameCard {
    public BrownBorderCard(Suit s, PokerValue p) {
        super(s, p);
        //default setup values
        this.color = BROWN;
        this.canPlayedOnSideOfTurn = true;
        this.canPlayedOutSideOfTurn = false;
    }

    @Override
    public boolean canBePlayedFromHand(Game game, GamePlayer player) {
        return canPlayedOnSideOfTurn;
    }

    @Override
    public void playCardFromHand(Game game, CardOption option, GamePlayer sourcePlayer) {
        //card without target
        if (allowedTarget == DistanceAllowedTarget.NONE) {
            sourcePlayer.removeFromHand(this);
            addRecordOfPlay();
            game.getPile(DeckName.DISCARD_PILE).putOnTop(this);
            game.log(2, "[" + sourcePlayer + "]"+ this + " was played");
            game.markStepAndCard(option, this, new GameStepYourself(game, this, sourcePlayer));
        }

        if (allowedTarget == DistanceAllowedTarget.ALL) {
            sourcePlayer.removeFromHand(this);
            addRecordOfPlay();
            game.getPile(DeckName.DISCARD_PILE).putOnTop(this);
            game.log(2, "[" + sourcePlayer + "]"+ this + " was played");
            game.markStepAndCard(option, this, new GameStepAll(game, this, sourcePlayer));
        }

        if (allowedTarget == DistanceAllowedTarget.OTHERS) {
            sourcePlayer.removeFromHand(this);
            addRecordOfPlay();
            game.getPile(DeckName.DISCARD_PILE).putOnTop(this);
            game.log(2, "[" + sourcePlayer + "]"+ this + " was played");
            game.markStepAndCard(option, this, new GameStepOthers(game, this, sourcePlayer));

            for (GamePlayer other: game.getActivePlayersOtherThan(sourcePlayer)) {
                applyPartOfEffectOnOtherPlayer(game, sourcePlayer, other);
            }
        }

        if (allowedTarget == DistanceAllowedTarget.OTHER) {
            sourcePlayer.removeFromHand(this);
            addRecordOfPlay();
            game.getPile(DeckName.DISCARD_PILE).putOnTop(this);
            game.log(2, "[" + sourcePlayer + "]"+ this + " was played");
            game.markStepAndCard(option, this, new GameStepOther(game, this, sourcePlayer));
        }

        if (allowedTarget == DistanceAllowedTarget.WEAPON_RANGE) {
            sourcePlayer.removeFromHand(this);
            addRecordOfPlay();
            game.getPile(DeckName.DISCARD_PILE).putOnTop(this);
            game.log(2, "[" + sourcePlayer + "]"+ this + " was played");
            game.markStepAndCard(option, this, new GameStepOther(game, this, sourcePlayer));
        }

        if (allowedTarget == DistanceAllowedTarget.SPECIFIC_RANGE) {
            sourcePlayer.removeFromHand(this);
            addRecordOfPlay();
            game.getPile(DeckName.DISCARD_PILE).putOnTop(this);
            game.log(2, "[" + sourcePlayer + "]"+ this + " was played");
            game.markStepAndCard(option, this, new GameStepOther(game, this, sourcePlayer));
        }
    }
    @Override
    public void applyPartOfEffectOnOtherPlayer(Game game, GamePlayer sourcePlayer, GamePlayer other) {

    }

    @Override
    public OptionOption generateOption(DeckAble card, GamePlayer gamePlayer) {
        switch (allowedTarget) {
            case OTHER: return new CardOptionTargetOtherPlayer(card, gamePlayer, null, distanceMax);
            case MYSELF: return new CardOption((GameCard) card, gamePlayer);
            case SPECIFIC_RANGE: return new CardOptionTargetOtherPlayer(card, gamePlayer, null, distanceMax);
            case WEAPON_RANGE: return new CardOptionAtWeaponRange(this, gamePlayer, gamePlayer.getWeaponRange() + gamePlayer.getMaxReach());
            case CARD_HAND_FRONT_ANY_DISTANCE: return new CardOptionTargetOtherPlayerAndCardInFrontOrHand(this, gamePlayer, null, null, null);
        }

        return new CardOption((GameCard) card, gamePlayer);
    }
}
