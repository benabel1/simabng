package org.example.game.options;

import org.example.game.Game;
import org.example.game.GamePlayer;

public class SkipOption extends OptionOption {

    public SkipOption(GamePlayer sourcePlayer) {
        super(sourcePlayer);
    }

    @Override
    public boolean canBeResolved(Game game) {
        return true;
    }

    @Override
    public void resolveInThisGame(Game game) {
        game.passPhasePlay();
    }

    @Override
    public String toString() {
        return "Skip option";
    }
}
