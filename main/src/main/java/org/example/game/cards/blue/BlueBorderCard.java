package org.example.game.cards.blue;

import org.example.game.Game;
import org.example.game.GamePlayer;
import org.example.game.cards.*;
import org.example.game.options.OptionScanner;


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
    public void playCardFromHand(Game game, GamePlayer sourcePlayer) {
        if (allowedTarget == DistanceAllowedTarget.MYSELF) {
            super.playCardFromHand(game, sourcePlayer);
            sourcePlayer.placeInFrontCard(this);
        }

        if (allowedTarget == DistanceAllowedTarget.OTHER_THAN_SHERIFF) {
            GamePlayer bluePlacementTarget = OptionScanner.scanForObjectSpecificList("Choose placement of " + this, game.getActivePlayers(null), 0, game.getActivePlayersCount(),  -1);

            if (bluePlacementTarget != null && bluePlacementTarget != game.getSheriffPlayer()) {
                super.playCardFromHand(game, sourcePlayer);
                bluePlacementTarget.placeInFrontCard(this);
            }
        }
    }

    @Override
    public void useCardInGame(Game game, GamePlayer ownerPlayer) {
        super.useCardInGame(game, ownerPlayer);
    }

    @Override
    public boolean canBePlayedFromHand(Game game, GamePlayer player) {
        return true;
    }

    @Override
    public boolean canBeUsedInGame(Game game) {
        return false;
    }
}
