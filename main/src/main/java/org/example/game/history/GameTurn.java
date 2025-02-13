package org.example.game.history;

import org.example.game.cards.GameCard;
import org.example.game.GamePlayer;

public class GameTurn {


    private final GamePlayer player;
    int bangCount;

    public GameTurn(GamePlayer player) {
        this.player = player;
    }

    public int getQuantity(GameCard cardBang) {
        return bangCount;
    }
}
