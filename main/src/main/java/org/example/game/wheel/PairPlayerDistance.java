package org.example.game.wheel;

import org.example.game.GamePlayer;

public class PairPlayerDistance {
    private final GamePlayer playerFromMe;
    private final int playerAtDistance;

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

    @Override
    public String toString() {
        return "[" + playerFromMe + "][" + playerAtDistance + "]";
    }
}
