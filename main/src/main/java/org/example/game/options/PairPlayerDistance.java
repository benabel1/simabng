package org.example.game.options;

import org.example.game.GamePlayer;

public class PairPlayerDistance {
    private GamePlayer playerFromMe;
    private int playerAtDistance;

    public PairPlayerDistance(GamePlayer playerFromMe, int playerAtDistance) {
        this.playerFromMe = playerFromMe;
        this.playerAtDistance = playerAtDistance;
    }

    public GamePlayer getPlayer() {
        return playerFromMe;
    }

    public int getPlayerAtDistance() {
        return playerAtDistance;
    }
}
