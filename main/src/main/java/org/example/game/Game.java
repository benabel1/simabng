package org.example.game;

import org.example.game.cards.DeckAble;
import org.example.game.cards.characters.GameCharacter;
import org.example.game.settings.BANGBasicGameSetup;
import org.example.game.settings.BANGDodgeCityGameSetup;
import org.example.game.settings.GameExpansionSetup;

import java.util.ArrayList;
import java.util.List;

import static org.example.game.Roles.*;

public class Game {
    GameEngine engine;
    GameStep step;
    List<GameStep> steps;
    private List<GamePlayer> players;

    private List<DeckAble> allCharacters;
    private List<DeckAble> allPlayingCards;
    private List<DeckAble> allDiscardedCards;
    private GameExpansionSetup[] settings;
    private GamePlayer activePlayer;

    public Game() {
        steps = new ArrayList<GameStep>();

        players = new ArrayList<GamePlayer>();

        settings = new GameExpansionSetup[2];
        settings[0] = new BANGBasicGameSetup();
        settings[1] = new BANGDodgeCityGameSetup();

        setupDecks();
    }

    private void setupDecks() {
        allPlayingCards = new ArrayList<>();
        allDiscardedCards = new ArrayList<>();
        allCharacters = new ArrayList<>();

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
        setupInitialHands();
    }

    private void setupInitialHands() {
        for (GamePlayer player: players) {
            player.drawInitialHand(this);
        }
    }

    private void setupPlayers() {
        int playersCount = OptionScanner.scanInt("How Many players will be in game?", 4, 8, 4 );

        List<Roles> roles = getEngine().randomSelected(playersCount);

        List<DeckAble> characters = engine.randomSelected(playersCount, allCharacters);

        for (int i = 0; i < playersCount; i++) {
               GamePlayer player = generatePlayerForPosition(i, roles.get(i));
               player.assignStartingCharacter((GameCharacter) characters.get(i));
        }

        activePlayer = players.get(0);

    }

    private GamePlayer generatePlayerForPosition(int i, Roles role) {
        String name = OptionScanner.scanText("Write name of player");

        GamePlayer newPlayer = new GamePlayer(name, i, role);
        players.add(newPlayer);

        return newPlayer;
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

    public void insert(DeckName deck, List<DeckAble> listOfCards) {
        switch (deck) {
            case CHARACTERS:
                allCharacters.addAll(listOfCards);
                break;
            case PLAYING_CARDS:
                allPlayingCards.addAll(listOfCards);

            default:
                System.out.println("Insertion of cards failed. " + deck + " was  not recognised.");
        }
    }

    public boolean isNotEnded() {
        boolean winOutlaws = calculateOutlawWin();
        boolean winRenegade = calculateRenegadeWin();
        boolean winLaw = calculateLawWin();
        boolean mathEnd = Math.random() < 0.95;

        return !(winLaw || winOutlaws || winRenegade) || mathEnd;
    }

    private boolean calculateLawWin() {
        int aliveSheriff = countPlayersWithRoleAndAliveStatus(SHERIFF, true);
        int aliveRene = countPlayersWithRoleAndAliveStatus(RENEGADE, true);
        int aliveOutlaw = countPlayersWithRoleAndAliveStatus(OUTLAW, true);;

        return aliveSheriff > 0 && aliveRene == 0 && aliveOutlaw == 0;
    }


    private boolean calculateRenegadeWin() {
        int aliveSheriff = countPlayersWithRoleAndAliveStatus(SHERIFF, true);
        int aliveVices = countPlayersWithRoleAndAliveStatus(VICE, true);
        int aliveRene = countPlayersWithRoleAndAliveStatus(RENEGADE, true);
        int aliveOutlaws = countPlayersWithRoleAndAliveStatus(OUTLAW, true);;

        return aliveSheriff == 0 && aliveVices == 0 && aliveRene == 1 && aliveOutlaws == 0;
    }

    private boolean calculateOutlawWin() {
        int aliveSheriff = countPlayersWithRoleAndAliveStatus(SHERIFF, true);
        int aliveVices = countPlayersWithRoleAndAliveStatus(VICE, true);
        int aliveRene = countPlayersWithRoleAndAliveStatus(RENEGADE, true);
        int aliveOutlaws = countPlayersWithRoleAndAliveStatus(OUTLAW, true);

        boolean winWithOutlaw = aliveSheriff == 0 && aliveOutlaws > 0;
        boolean winWithoutOutlaw = aliveSheriff == 0 && aliveOutlaws == 0 && (aliveRene > 1 || aliveVices > 0);

        return winWithoutOutlaw || winWithOutlaw;
    }

    public void executeOneInteration() {
        for (GamePlayer p: players) {
            System.out.println("+-------+----+-----+----+-----+");
            System.out.println(p.getName() + " " + p.getCurrentRole() + " " + p.getCurrentCharacter().getCardName() + "[" + p. getCurrentHp()+"/"+ p.getCurrentMaxHp()+"]");
        }
        System.out.println("+-------+----+-----+----+-----+");
        System.out.println("iteration1");

        showOption();

        OptionScanner.scanInt("Write option", 0, 3, 2);
    }

    private void showOption() {
        if (activePlayer != null) {
            activePlayer.showHandAndFront();
        }
    }

    private int countPlayersWithRoleAndAliveStatus(Roles role, boolean isAlive) {
        int total = 0;
        for (GamePlayer player:players) {
            total += player.matchRoleAndAliveStat(role, isAlive) ;
        }
        return total;
    }

    public List<DeckAble> getDecks() {
        return allPlayingCards;
    }

    public DeckAble drawCard(Game game) {
        DeckAble card;

        if (!allPlayingCards.isEmpty()) {
            card = allPlayingCards.remove(0);

        } else if(!allDiscardedCards.isEmpty()) {
            //TODO: make random reshuffling
            allPlayingCards.addAll(allDiscardedCards);
            card = allPlayingCards.remove(0);
        } else {
            System.out.println("Both deck are empty");
            card = null;
        }

        return card;
    }
}
