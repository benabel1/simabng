package org.example.game.cards.green;

import org.example.game.Game;
import org.example.game.GamePlayer;
import org.example.game.cards.DistanceAllowedTarget;
import org.example.game.cards.GameCard;
import org.example.game.cards.PokerValue;
import org.example.game.cards.Suit;
import org.example.game.deck.DeckAble;
import org.example.game.history.steps.GameStepPlayCardOnTargetPlayer;
import org.example.game.options.CardOption;
import org.example.game.options.CardOptionPlacementInFrontOfMe;
import org.example.game.options.OptionOption;

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
        return turnOfPlay != game.geActiveTurn();
    }

    @Override
    public void playCardFromHand(Game game, CardOption option, GamePlayer sourcePlayer) {
        if (allowedTarget == DistanceAllowedTarget.MYSELF) {
            sourcePlayer.removeFromHand(this);
            sourcePlayer.placeInFrontCard(this);
            turnOfPlay = game.geActiveTurn();
            if (!option.isOptionRecordedInStep()) {
                game.markStepAndCard(option, this, new GameStepPlayCardOnTargetPlayer(game, this, sourcePlayer, sourcePlayer));
            }
        }
        super.playCardFromHand(game, option, sourcePlayer);
    }

    @Override
    public OptionOption generateOption(DeckAble card, GamePlayer gamePlayer) {
        return new CardOptionPlacementInFrontOfMe((GameCard) card, gamePlayer);
    }
}



