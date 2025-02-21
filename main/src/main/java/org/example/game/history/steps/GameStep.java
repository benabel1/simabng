package org.example.game.history.steps;

import org.example.game.Game;

public class GameStep {
    protected Game game;

    public GameStep(Game game) {
        this.game = game;
    }

    @Override
    public String toString() {
        return "SomeStep";
    }
}
