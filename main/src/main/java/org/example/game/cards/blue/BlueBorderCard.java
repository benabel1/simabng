package org.example.game.cards.blue;

import org.example.game.Game;
import org.example.game.GamePlayer;
import org.example.game.cards.*;
import org.example.game.deck.DeckAble;
import org.example.game.history.steps.GameStepPlayCardOnTargetPlayer;
import org.example.game.options.*;
import org.example.game.options.scaner.OptionScanner;


public class BlueBorderCard extends GameCard {
    public BlueBorderCard(Suit s, PokerValue p) {
        super(s, p);
        //default setup values
        this.color = CardBorderColor.BLUE;
        this.allowedTarget = DistanceAllowedTarget.MYSELF;

        this.canPlayedOnSideOfTurn = true;
        this.canPlayedOutSideOfTurn = false;
    }

    @Override
    public void playCardFromHand(Game game, CardOption option, GamePlayer sourcePlayer) {
        if (allowedTarget == DistanceAllowedTarget.MYSELF) {
            super.playCardFromHand(game, option, sourcePlayer);
            sourcePlayer.placeInFrontCard(this);
            if (!option.isOptionRecordedInStep()) {
                game.markStepAndCard(option, this, new GameStepPlayCardOnTargetPlayer(game, this, sourcePlayer, sourcePlayer));
            }
        }

        if (allowedTarget == DistanceAllowedTarget.OTHER_THAN_SHERIFF) {
            GamePlayer bluePlacementTarget = OptionScanner.scanForObjectSpecificList("Choose placement of " + this, game.getActivePlayersOtherThan(null), 0, game.getActivePlayersCount(),  null);

            if (bluePlacementTarget != null && bluePlacementTarget != game.getSheriffPlayer()) {
                super.playCardFromHand(game, option, sourcePlayer);
                bluePlacementTarget.placeInFrontCard(this);
                if (!option.isOptionRecordedInStep()) {
                    game.markStepAndCard(option, this, new GameStepPlayCardOnTargetPlayer(game, this, sourcePlayer, bluePlacementTarget));
                }
            }
        }

        if (this instanceof IsWeapon) {
            sourcePlayer.replaceOldWeapon(game, this);
        }
    }

    @Override
    public void useCardInGame(Game game, OptionOption option, GamePlayer ownerPlayer) {
        super.useCardInGame(game, option, ownerPlayer);
    }

    @Override
    public boolean canBePlayedFromHand(Game game, GamePlayer player) {
        return true;
    }

    @Override
    public boolean canBeUsedInGame(Game game) {
        return false;
    }

    @Override
    public OptionOption generateOption(DeckAble card, GamePlayer gamePlayer) {
        switch(allowedTarget) {
            case MYSELF: return new CardOptionPlacementInFrontOfMe((GameCard) card, gamePlayer);
            case OTHER_THAN_SHERIFF: return new CardOptionPlacementInFrontOfNoneSheriff((GameCard) card, gamePlayer, null);
            case ANY: return new CardOptionPlacementInFrontOfAnyone((GameCard) card, gamePlayer, null);
        }
        return new CardOption((GameCard) card, gamePlayer);
    }
}
