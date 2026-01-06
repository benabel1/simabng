package org.example.game.cards;

import org.example.game.Game;
import org.example.game.GamePlayer;

public interface IAvoidable {
    boolean canBeUsed(Game game);
    boolean processAvoidAction(Game game, GamePlayer defendingPlayer, GameCard cardBang);

    default boolean mustBeDiscardedAfterSuccessMiss() {
        return true;
    }
}
