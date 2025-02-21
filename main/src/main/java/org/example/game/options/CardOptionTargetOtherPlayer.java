package org.example.game.options;

import org.example.game.GamePlayer;
import org.example.game.cards.GameCard;
import org.example.game.deck.DeckAble;

public class CardOptionTargetOtherPlayer extends CardOption {
    private final GamePlayer target;
    private final int maxDistanceOtherThanZero;

    public CardOptionTargetOtherPlayer(DeckAble card, GamePlayer gamePlayer, GamePlayer otherTarget, int distanceMax) {
        super((GameCard) card, gamePlayer);
        this.target = otherTarget;
        this.maxDistanceOtherThanZero = distanceMax;
    }
}
