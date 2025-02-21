package org.example.game.options;

import org.example.game.Game;

public class SkipOption extends OptionOption {

    public SkipOption() {
        super(sourcePlayer);
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
