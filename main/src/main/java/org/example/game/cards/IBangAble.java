package org.example.game.cards;

import org.example.game.Game;
import org.example.game.GamePlayer;

public interface IBangAble {
    boolean canBeUsed(Game game);

    default boolean mustBeDiscardedAfterSuccessBang() {
        return true;
    }
}
