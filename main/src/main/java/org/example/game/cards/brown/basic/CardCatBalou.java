package org.example.game.cards.brown.basic;

import org.example.game.Game;
import org.example.game.GamePlayer;
import org.example.game.cards.*;
import org.example.game.cards.brown.BrownBorderCard;
import org.example.game.history.steps.GameStepPlayCardOnTargetPlayer;
import org.example.game.history.steps.GameStepPlayCardOnTargetPlayerHanfFrontCArd;
import org.example.game.options.CardOption;
import org.example.game.options.CardOptionTargetOtherPlayerAndCardInFrontOrHand;

public class CardCatBalou extends BrownBorderCard {
    public CardCatBalou(Suit suit, PokerValue pokerValue) {
        super(suit, pokerValue);
        this.cardName = "CAT BALOU";

        this.allowedTarget = DistanceAllowedTarget.CARD_HAND_FRONT_ANY_DISTANCE;
    }

    @Override
    public void playCardFromHand(Game game, CardOption option, GamePlayer sourcePlayer) {
        if (option != null && option instanceof CardOptionTargetOtherPlayerAndCardInFrontOrHand) {
            CardOptionTargetOtherPlayerAndCardInFrontOrHand act = (CardOptionTargetOtherPlayerAndCardInFrontOrHand) option;

            GameCard discardCard = act.getStolenCards();
            GamePlayer target = act.getTargetPlayer();
            sourcePlayer.discardCardFromPlayer(discardCard, target, act.getZone() == ZONE.FRONT);

            if (!option.isOptionRecordedInStep()){
                game.markStepAndCard(option, this, new GameStepPlayCardOnTargetPlayerHanfFrontCArd(
                        game,
                        this,
                        sourcePlayer,
                        target,
                        act.getZone(),
                        discardCard
                ));
            }

            super.playCardFromHand(game, option, sourcePlayer);
        }


    }
}
