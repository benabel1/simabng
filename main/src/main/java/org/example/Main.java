package org.example;

import org.example.game.Game;
import org.example.game.GameEngine;

public class Main {
    public static void main(String[] args) {

        GameEngine engine = new GameEngine();
        engine.playGame(new Game());
    }

}