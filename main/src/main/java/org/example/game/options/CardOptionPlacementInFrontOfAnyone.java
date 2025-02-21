package org.example.game.options;

import org.example.game.GamePlayer;
import org.example.game.cards.GameCard;

public class CardOptionPlacementInFrontOfAnyone extends CardOption {
    private final GamePlayer target;

    public CardOptionPlacementInFrontOfAnyone(GameCard card, GamePlayer gamePlayer, GamePlayer o) {
        super(card, gamePlayer);
        this.target = o;
    }
}
