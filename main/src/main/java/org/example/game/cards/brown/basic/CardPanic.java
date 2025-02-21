package org.example.game.cards.brown.basic;

import org.example.game.Game;
import org.example.game.GamePlayer;
import org.example.game.cards.DistanceAllowedTarget;
import org.example.game.cards.PokerValue;
import org.example.game.cards.Suit;
import org.example.game.cards.ZONE;
import org.example.game.cards.brown.BrownBorderCard;
import org.example.game.options.CardOption;
import org.example.game.options.CardOptionTargetOtherPlayerAndCardInFrontOrHand;

public class CardPanic extends BrownBorderCard {
    public CardPanic(Suit suit, PokerValue pokerValue) {
        super(suit, pokerValue);
        this.cardName = "PANIC";

        this.allowedTarget =  this.allowedTarget = DistanceAllowedTarget.CARD_HAND_FRONT_ANY_DISTANCE;
        this.distanceMax = 1;
    }

    @Override
    public void playCardFromHand(Game game, CardOption option, GamePlayer sourcePlayer, GamePlayer targetPlayer) {
        if (option!= null && !option.isWasUndo()) {
            if (option instanceof CardOptionTargetOtherPlayerAndCardInFrontOrHand) {
                CardOptionTargetOtherPlayerAndCardInFrontOrHand pppp = (CardOptionTargetOtherPlayerAndCardInFrontOrHand) option;

                sourcePlayer.stealCardFromPlayer(pppp.getStolenCards(), targetPlayer, pppp.getZone() == ZONE.FRONT);

                super.playCardFromHand(game, option, sourcePlayer, targetPlayer);
            }
        }
    }
}
