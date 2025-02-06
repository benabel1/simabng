package org.example.game;

import org.example.game.cards.DeckAble;
import org.example.game.settings.BANGBasicGameSetup;
import org.example.game.settings.GameExpansionSetup;

import java.util.ArrayList;
import java.util.List;

public class Game {
    GameEngine engine;
    GameStep step;
    List<GameStep> steps;
    private List<GamePlayer> players;

    private List<DeckAble> allCharacters;
    private List<DeckAble> allPlayingCards;
    private GameExpansionSetup[] settings;

    public Game() {
        steps = new ArrayList<GameStep>();

        players = new ArrayList<GamePlayer>();

        settings = new GameExpansionSetup[1];
        settings[0] = new BANGBasicGameSetup();

        setupDecks();
    }

    private void setupDecks() {
        for (GameExpansionSetup setup: getSettings()) {
            if (setup.isTurnOn()){
                setup.applySetup(this);
            }
        }
    }

    private GameExpansionSetup[] getSettings() {
        return settings;
    }

    public boolean isSetupAndReadyTOStart() {
        return false;
    }

    public void setup() {
        setupPlayers();
    }

    private void setupPlayers() {
        int playersCount = OptionScanner.scanInt("How Many players will be in game?", 4, 8, 4 );

        for (int i = 0; i < playersCount; i++) {
                generatePlayerForPosition(i);
        }

    }

    private void generatePlayerForPosition(int i) {
        String name = OptionScanner.scanText("Write name of player");
        players.add(new GamePlayer(name, i));
    }

    public GameEngine getEngine() {
        return engine;
    }

    //only one gameEngine can be used
    public void setupEngine(GameEngine gameEngine) {
        //CHECK
        if (gameEngine != null && engine == null) {
            this.engine = gameEngine;
        }
    }

    public void insert(DeckName deck, List<DeckAble> generatedCards) {
        switch (deck) {
            case CHARACTERS:
                generatedCards.addAll(generatedCards);
                break;
            case PLAYING_CARDS:
                generatedCards.addAll(generatedCards);

            default:
                System.out.println("Insertion of cards failed. " + deck + " was  not recognised.");
        }
    }
}
