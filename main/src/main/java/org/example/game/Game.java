package org.example.game;

import org.example.game.cards.ZONE;
import org.example.game.deck.DeckAble;
import org.example.game.cards.GameCard;
import org.example.game.cards.OptionGenerator;
import org.example.game.cards.characters.GameCharacter;
import org.example.game.deck.DeckName;
import org.example.game.deck.DeckOfCards;
import org.example.game.history.GameTurn;
import org.example.game.history.HistoryTracker;
import org.example.game.options.OptionOption;
import org.example.game.options.OptionScanner;
import org.example.game.settings.BANGArmedAndDangerous;
import org.example.game.settings.BANGBasicGameSetup;
import org.example.game.settings.BANGDodgeCityGameSetup;
import org.example.game.settings.GameExpansionSetup;
import org.example.game.wheel.GamePlayersWheel;

import java.util.ArrayList;
import java.util.List;

import static org.example.game.CARD_ATTRIBUTE.CAUSE_FOR_ANY;
import static org.example.game.CARD_ATTRIBUTE.CAUSE_FOR_STEAL;
import static org.example.game.Roles.*;
import static org.example.game.cards.ZONE.HAND;

public class Game {
    private final OptionGenerator generator;
    GameEngine engine;
    GameStep step;
    List<GameStep> steps;
    private List<GamePlayer> players;

    private List<DeckAble> allCharacters;
    private List<DeckAble> allPlayingCards;
    private List<DeckAble> allGoldRewards;
    private List<DeckAble> allHighNoonCards;
    private DeckOfCards playingCardDeck;
    private DeckOfCards discardCardDeck;
    private GameExpansionSetup[] settings;
    private GamePlayer activePlayer;

    private HistoryTracker historyTracker;
    private GamePlayer sheriffPlayer;
    private GamePlayersWheel gamePlayersWheel;

    public Game() {
        this.gamePlayersWheel = new GamePlayersWheel(this);
        historyTracker = new HistoryTracker(this);

        steps = new ArrayList<GameStep>();

        players = new ArrayList<GamePlayer>();

        settings = new GameExpansionSetup[3];
        settings[0] = new BANGBasicGameSetup();
        settings[1] = new BANGDodgeCityGameSetup();
        settings[2] = new BANGArmedAndDangerous();

        setupDecks();

        generator = new OptionGenerator();
    }

    private void setupDecks() {
        allPlayingCards = new ArrayList<>();
        allCharacters = new ArrayList<>();
        allGoldRewards = new ArrayList<>();
        allHighNoonCards = new ArrayList<>();

        for (GameExpansionSetup setup: getSettings()) {
            if (setup.isTurnOn()){
                setup.applySetup(this);
            }
        }

        playingCardDeck = new DeckOfCards(allPlayingCards);
        playingCardDeck.reshuffle();

        discardCardDeck = new DeckOfCards(new ArrayList<>());

        playingCardDeck.setPairDeck(discardCardDeck);
        discardCardDeck.setPairDeck(playingCardDeck);
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
        setRound();
        setTurn(sheriffPlayer);
    }

    private void setTurn(GamePlayer sheriffPlayer) {
        historyTracker.createTurn(sheriffPlayer);
    }

    private void setRound() {
        historyTracker.createRound();
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
               Roles role = roles.get(i);
               GamePlayer player = generatePlayerForPosition(i, roles.get(i));
               player.assignStartingCharacter((GameCharacter) characters.get(i));
               gamePlayersWheel.addPlayerAndSetStartingOne(player, role);

               if (role == SHERIFF) {
                   sheriffPlayer = player;
               }
        }

        gamePlayersWheel.makeInitialStructure(sheriffPlayer);

        activePlayer = sheriffPlayer;
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
                break;
            case GOLD_REWARDS:
                allGoldRewards.addAll(listOfCards);
                break;
            case HIGH_NOON:
                allHighNoonCards.addAll(listOfCards);
                break;
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
    }

    private void showOption() {
        if (activePlayer != null) {
           //DEBUG
            activePlayer.showHandAndFront();

            generator.generateOptionAndChooseOne(this, activePlayer);

        }
    }

    private int countPlayersWithRoleAndAliveStatus(Roles role, boolean isAlive) {
        int total = 0;
        for (GamePlayer player:players) {
            total += player.matchRoleAndAliveStat(role, isAlive, this) ;
        }
        return total;
    }

    public List<DeckAble> getAllPlayingCards() {
        return allPlayingCards;
    }

    public DeckAble drawCard() {
        DeckAble card = playingCardDeck.draw();

        System.out.println("\tCard" + card + " was drawn");

        return card;
    }

    public List<OptionOption> generateGlobalOption() {
        List<OptionOption> optionOptions = new ArrayList<>();
        return optionOptions;
    }

    public void resolveOption(OptionOption option) {
        option.resolveInThisGame(this);
    }

    public boolean wasPlayedLessThan(GameCard cardBang, int i) {
        return getGameHistory().getCurrentTurn().getQuantity(cardBang) < i;
    }

    private HistoryTracker getGameHistory() {
        return historyTracker;
    }

    public void notifyAllOther(String cardName, GamePlayer sourcePlayer) {
        for (GamePlayer player: players) {
            if (player == sourcePlayer) {
                continue;
            }
            player.notifyYouAboutPlayerCardBy(cardName, sourcePlayer);
        }
    }

    public DeckOfCards getPile(DeckName deckName) {
        switch (deckName) {
            case DISCARD_PILE:
                return discardCardDeck;
            case PLAYING_CARDS:
                return playingCardDeck;
            case CHARACTERS:
                //TODO
                return null;
        }
        return null;
    }

    public int getActivePlayersCount() {
        int totalActivePlayer = 0;

        for (GamePlayer player: players) {
            if (player.isAlive(this)) {
                totalActivePlayer++;
            }
        }

        return totalActivePlayer;
    }

    public boolean isThereCardInGameAtAnyDistanceToBeStolen(GamePlayer ownerPlayer, ZONE hand) {
        int totalCards = getTotalCardsOtherOfCause(ownerPlayer, CAUSE_FOR_STEAL, hand);

        return totalCards > 0;
    }

    private int getTotalCardsOtherOfCause(GamePlayer ownerPlayer, CARD_ATTRIBUTE cardAttribute, ZONE zone) {
        int total = 0;
        for (GamePlayer player: players) {
            total += player.getAllCards(cardAttribute, zone);
        }

        return total;
    }

    public List<GamePlayer> getPlayersWithHandOtherThan(GamePlayer ownerPlayer) {
        ArrayList<GamePlayer> a = new ArrayList<>();

        for (GamePlayer player: getActivePlayers(ownerPlayer)) {
            if (player.getAllCards(CAUSE_FOR_ANY, HAND)> 0) {
                a.add(player);
            }
        }

        return a;
    }

    public List<GamePlayer> getActivePlayers(GamePlayer ownerPlayer) {
        List<GamePlayer> allActivePlayers = new ArrayList<>();

        for (GamePlayer testPlayer: players) {
            if (ownerPlayer != testPlayer && testPlayer.isAlive(this)) {
                allActivePlayers.add(testPlayer);
            }
        }

        return allActivePlayers;
    }

    public GameTurn geActtiveTurn() {
        return historyTracker.getCurrentTurn();
    }

    public GamePlayer getSheriffPlayer() {
        return sheriffPlayer;
    }

    public List<GamePlayer> getPlayersFromACurrentToOthersInOrderSkippedEliminated(GamePlayer currentPlayer, boolean b) {
        List<GamePlayer> a = gamePlayersWheel.getPlayersInOrderFromNowSkippingEliminated(currentPlayer, b);

        return a;
    }
}
