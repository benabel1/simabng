package org.example.game.options;

import org.example.game.Game;

public class SkipOption extends OptionOption {

    @Override
    public void resolveInThisGame(Game game) {
        game.passPhasePlay();
    }

    @Override
    public String toString() {
        return "Skip option";
    }
}
