package org.example.game.options;

import org.example.game.Game;
import org.example.game.GamePlayer;
import org.example.game.cards.GameCard;

public class CardOptionPlacementInFrontOfMe extends CardOption {
    public CardOptionPlacementInFrontOfMe(GameCard card, GamePlayer gamePlayer) {
        super(card, gamePlayer);
    }

    @Override
    public void resolveInThisGame(Game game) {
        if (canBeResolved(game)) {
            cardSource.playCardFromHand(game, this, sourcePlayer);
        }
    }
}
