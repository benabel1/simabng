package org.example.game.options;

import org.example.game.GamePlayer;
import org.example.game.cards.GameCard;

public class CardOptionPlacementInFrontOfNoneSheriff extends CardOption {
    GamePlayer target;
    public CardOptionPlacementInFrontOfNoneSheriff(GameCard card, GamePlayer gamePlayer, GamePlayer target) {
        super(card, gamePlayer);
        this.target = target;
    }
}
