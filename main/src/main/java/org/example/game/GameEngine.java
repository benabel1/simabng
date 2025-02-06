package org.example.game;

import org.example.game.cards.DeckAble;

import java.util.List;

public class GameEngine {

    public void playGame(Game game) {
        setupEngine(game);
        setupGame(game);

    }

    private void setupEngine(Game game) {
        game.setupEngine(this);
    }

    private void setupGame(Game game) {
        if(game.isSetupAndReadyTOStart()){

        } else {
            game.setup();
        }
    }

    public List<DeckAble> drawCards(int startHand) {
        return null;
    }
}
