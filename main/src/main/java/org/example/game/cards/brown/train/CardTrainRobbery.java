package org.example.game.cards.brown.train;

import org.example.game.Game;
import org.example.game.GamePlayer;
import org.example.game.cards.*;
import org.example.game.cards.brown.BrownBorderCard;
import org.example.game.deck.DeckAble;
import org.example.game.deck.DeckName;
import org.example.game.options.CardOption;
import org.example.game.options.scaner.OptionScanner;

public class CardTrainRobbery extends BrownBorderCard {

    public CardTrainRobbery(Suit s, PokerValue p) {
        super(s, p);
        this.cardName = "Train Robbery";

        this.allowedTarget = DistanceAllowedTarget.OTHER;
    }

    @Override
    public boolean canBePlayedFromHand(Game game, GamePlayer player) {
        return game.wasPlayedLessThan(this, 1);
    }

    @Override
    public void playCardFromHand(Game game, CardOption option, GamePlayer sourcePlayer, GamePlayer targetPlayer) {
        super.playCardFromHand(game, option, sourcePlayer, targetPlayer);
        if (sourcePlayer != null && targetPlayer != null) {
            //targetPlayer.responseToShotFromWithCard(game, sourcePlayer, this, sourcePlayer.getMissedNeed(this));
            game.increaseLimitTurnCount(this.getClass());

            for (DeckAble card :targetPlayer.getAllCards(CARD_ATTRIBUTE.CAUSE_FOR_ANY, ZONE.FRONT)) {
                if (card != null) {
                    boolean decisionForDiscardRatherSHOT = OptionScanner.scanForYesOrNoDefaultIsNo("Should discard: " + card);

                    if (decisionForDiscardRatherSHOT) {
                        targetPlayer.removeFromFront(card);
                        game.getPile(DeckName.DISCARD_PILE).putOnTop(card);
                        System.out.println("Chose to discard: " + card);
                    } else {
                        System.out.println("Chose to face SHOT for keeping: " + card);
                        targetPlayer.responseToShotFromWithCard(game, sourcePlayer, this, sourcePlayer.getMissedNeed(this));
                    }
                }
            }
        }
    }

}
