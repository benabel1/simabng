package org.example.game.options;

import org.example.game.Game;
import org.example.game.GamePlayer;

public class OptionOption {
    protected final GamePlayer sourcePlayer;
    protected boolean wasUndo;

    protected boolean wasRecorded;

    public OptionOption(GamePlayer sourcePlayer) {
        this.sourcePlayer = sourcePlayer;
    }

    public GamePlayer getSourcePlayer() {
        return sourcePlayer;
    }

    public boolean isWasUndo() {
        return wasUndo;
    }

    public void resolveInThisGame(Game game) {
    }

    public boolean canBeResolved(Game game) {
        return true;
    }

    public boolean isOptionRecordedInStep() {
        return wasRecorded;
    }

    public void markAsRecorded() {
        wasRecorded = true;
    }


    public void collectData(Game game) {
        System.out.println("I don t have any datas");
    }
}
