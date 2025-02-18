package org.example.game.cards.green;

import org.example.game.Game;
import org.example.game.GamePlayer;
import org.example.game.cards.DistanceAllowedTarget;
import org.example.game.cards.GameCard;
import org.example.game.cards.PokerValue;
import org.example.game.cards.Suit;

import static org.example.game.cards.CardBorderColor.GREEN;

public class GreenBorderCard extends GameCard {

    public GreenBorderCard(Suit s, PokerValue p) {
        super(s, p);
        //default setup values
        this.color = GREEN;
        this.allowedTarget = DistanceAllowedTarget.MYSELF;

        this.canPlayedOnSideOfTurn = true;
        this.canPlayedOutSideOfTurn = false;
    }

    @Override
    public boolean canBePlayedFromHand(Game game, GamePlayer player) {
        return true;
    }

    @Override
    public boolean canBeUsedInGame(Game game) {
        return turnOfPlay != game.geActtiveTurn();
    }

    @Override
    public void playCardFromHand(Game game, GamePlayer sourcePlayer) {
        if (allowedTarget == DistanceAllowedTarget.MYSELF) {
            super.playCardFromHand(game, sourcePlayer);
            sourcePlayer.placeInFrontCard(this);
            turnOfPlay = game.geActtiveTurn();
        }
    }
}



