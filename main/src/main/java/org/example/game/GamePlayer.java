package org.example.game;

import org.example.game.cards.*;
import org.example.game.cards.characters.GameCharacter;
import org.example.game.deck.DeckAble;
import org.example.game.options.OptionOption;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.example.game.cards.Roles.SHERIFF;

public class GamePlayer {
    private final String name;
    private final int order;

    private boolean isEliminated;
    private int orderElimination;

    private int currentHp;
    private int maxHp;

    private GameCharacter startChar;
    private GameCharacter currentChar;

    private List<DeckAble> playerHand;
    private List<DeckAble> playerFront;
    private Roles currentRole, startingRole;

    public GamePlayer(String name, int orderNumber, Roles role) {
        this.name = name;
        this.order = orderNumber;
        this.startingRole = this.currentRole = role;

        initPlayerGameElements();

        System.out.println("Player " + name + " was created with order: " + orderNumber);
    }

    private void initPlayerGameElements() {
        playerHand = new ArrayList<>();
        playerFront = new ArrayList<>();
    }

    public void assignStartingCharacter(GameCharacter character) {
        if (this.startChar == null && character != null) {
            this.startChar = this.currentChar = character;

            maxHp = this.startChar.getMaxHp();
            currentHp = this.startChar.getStartHp();

            if (startingRole == SHERIFF) {
                maxHp++;
                currentHp++;
            }
        }
    }

    public int getCurrentHp() {
        return currentHp;
    }

    public GamePlayer setCurrentHp(int currentHp) {
        this.currentHp = currentHp;
        return this;
    }

    public String getName() {
        return this.name;
    }

    public int matchRoleAndAliveStat(Roles role, boolean isAlive, Game game) {
        if (role == null) {
            return 0;
        } else {
            return (currentRole == role && isAlive(game) == isAlive) ? 1 : 0;
        }
    }

    public boolean isAlive(Game game) {
        return currentHp > 0;
    }

    public Roles getCurrentRole() {
        return currentRole;
    }

    public int getCurrentMaxHp() {
        return maxHp;
    }

    public GameCharacter getCurrentCharacter() {
        return currentChar;
    }

    public void showHandAndFront() {
        System.out.println("HAND");
        for (DeckAble hand : playerHand) {
            System.out.println("\t" + hand);
        }

        System.out.println("FRONT");
        for (DeckAble front : playerFront) {
            System.out.println("\t" + front);
        }
    }

    public void drawInitialHand(Game game) {
        if (game != null && game.getEngine() != null) {
            playerHand.addAll(game.getEngine().drawCards(currentHp, game));
        }
    }

    public void playedGameCard(Game game, GameCard card) {
        currentChar.playedCard(game, card);
    }

    public List<OptionOption> generateALlOption(Game game) {
        List<OptionOption> result = new ArrayList<>();

        for (DeckAble card : playerHand) {
            if (card.canBePlayedFromHand(game)) {
                result.add(card.generateOption(card, this));
            }
        }

        for (DeckAble card: playerFront) {
            if (card.canBeUsedInGame(game)) {
                result.add(card.generateOption(card, this));
            }
        }

        generateCharacterOption(result);

        return result;
    }

    private void generateCharacterOption(List<OptionOption> result) {
        if (currentChar != null) {
            OptionOption charOption = currentChar.generateOption(currentChar, this);
            if (charOption != null) {
                result.add(charOption);
            }
        }
    }

    @Override
    public String toString() {
        return name;
    }

    public void restoreLife(int restoredAmountHp) {
        if (currentHp < maxHp) {
            if (currentHp + restoredAmountHp <= maxHp) {
                currentHp = currentHp + restoredAmountHp;
            } else {
                currentHp = maxHp;
            }
        }
    }

    public void notifyYouAboutPlayerCardBy(String cardName, GamePlayer sourcePlayer) {
        currentChar.notifyP(cardName, sourcePlayer);
    }

    public void removeFromHand(DeckAble handCard) {
        if (handCard != null) {
            playerHand.remove(handCard);
        }
    }

    public void placeInFrontCard(DeckAble frontCard) {
        playerFront.add(frontCard);
    }

    public void drawCard(DeckAble drawnCard, boolean wasShown) {
        playerHand.add(drawnCard);
        drawnCard.startNewRecordForHand(wasShown);
    }

    private void stealCard(DeckAble card, boolean see, GamePlayer previousOwner) {
        playerHand.add(card);
        card.startNewRecordForHand(see);
        card.setPreviousOwnerKnown(previousOwner);
        card.addRecordOfSteal();

    }

    public int getAllCards(CARD_ATTRIBUTE cardAttribute, ZONE zone) {
        switch (zone) {
            case HAND_FRONT:
                return playerHand.size() + playerFront.size();
            case HAND:
                return playerHand.size();
            case FRONT:
                return playerFront.size();

            default:
                return 0;
        }
    }

    public DeckAble getRandomCard(ZONE zone) {
        switch (zone) {
            case HAND:
                return playerHand.get((int) (playerHand.size() * Math.random()));
        }

        return null;
    }

    public void stealCardFromPlayer(DeckAble card, GamePlayer player) {
        if (card != null && player != null) {
            this.stealCard(card, false, player);
        }
    }

    public List<DeckAble> getAllTesting() {
        List<DeckAble> re = new ArrayList<>();

        Comparator<RevealAble> comparator = (x,y) -> (x.getPriority() > y.getPriority()) ? 1: -1;

        return re;
    }
}

