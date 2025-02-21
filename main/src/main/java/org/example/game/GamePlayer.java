package org.example.game;

import org.example.game.cards.*;
import org.example.game.cards.brown.basic.CardBang;
import org.example.game.cards.characters.GameCharacter;
import org.example.game.cards.orange.OrangeBorderCard;
import org.example.game.deck.DeckAble;
import org.example.game.deck.DeckName;
import org.example.game.history.sequence.GameTurn;
import org.example.game.history.steps.GameStepDiscardWeapon;
import org.example.game.options.OptionOption;
import org.example.game.options.scaner.OptionScanner;

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

    /**
     * Extra parameters
     */
    private int loadCount;
    private int goldCount;
    private int baseReach;

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

        baseReach = 1;
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
        return currentHp > 0 || hasCardOfInFrontItSelf((ArrayList<Class>) GameConstatns.keepingAliveCards);
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

    public void showHandAndFront(Game game) {
        GameTurn turn = game.geActiveTurn();
        System.out.println("Turn " + turn + " BANGs: " + turn.getBangsCount());

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
            //TODO: setup up to character, not starting HP, e.x. Big Spencer
            playerHand.addAll(game.getEngine().drawCards(currentHp, game));
            game.log(1, "[" + getName() + "]<<InitialHand>>: " + playerHand);
        }
    }

    public void playedGameCard(Game game, GameCard card) {
        currentChar.playedCard(game, card);
    }

    public List<OptionOption> generateALlOption(Game game) {
        List<OptionOption> result = new ArrayList<>();

        for (DeckAble card : playerHand) {
            if (card.canBePlayedFromHand(game, null)) {
                result.add(card.generateOption(card, this));
            }
        }

        for (DeckAble card : playerFront) {
            if (card.canBeUsedInGame(game)) {
                result.add(card.generateOption(card, this));
            }
        }

        generateCharacterOption(result);

        return result;
    }

    private void generateCharacterOption(List<OptionOption> result) {
        if (currentChar != null) {

            if (currentChar.isIsaActiveAbility() && currentChar.isAbilityPhase02()) {
                OptionOption charOption = currentChar.generateOption(currentChar, this);
                if (charOption != null) {
                    result.add(charOption);
                }
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

    public void notifyYouAboutPlayerCardBy(Game game, GameCard card, GamePlayer sourcePlayer) {
        currentChar.notifyP(card, sourcePlayer, game);
    }

    public void removeCard(DeckAble card) {
        removeFromHand(card);
        removeFromFront(card);
    }

    public void removeFromHand(DeckAble handCard) {
        if (handCard != null) {
            playerHand.remove(handCard);
        }
    }

    public void removeFromFront(DeckAble frontCard) {
        if(frontCard != null) {
            playerFront.remove(frontCard);
        }
    }


    public void placeInFrontCard(DeckAble frontCard) {
        playerFront.add(frontCard);
    }

    public void drawCard(DeckAble drawnCard, boolean wasShown) {
        playerHand.add(drawnCard);
        drawnCard.startNewRecordForHand(wasShown);
    }

    public void drawCards(List<DeckAble> drawnCard, boolean wasShown) {
        for (DeckAble card: drawnCard) {
            playerHand.add(card);
            card.startNewRecordForHand(card.wasShown());
        }
        System.out.println("Drawn cards: " + drawnCard);
    }

    private void stealCard(DeckAble card, GamePlayer previousOwner, boolean see) {
        playerHand.add(card);
        previousOwner.removeFromHand(card);
        previousOwner.removeFromFront(card);
        card.startNewRecordForHand(see);
        card.setPreviousOwnerKnown(previousOwner);
        card.addRecordOfSteal();
    }
    public int getAllCardsCount(CARD_ATTRIBUTE cardAttribute, ZONE zone) {
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

    public List<DeckAble> getAllCards(CARD_ATTRIBUTE cardAttribute, ZONE zone) {
        List<DeckAble> handSnapShot = new ArrayList<>();
        switch (zone) {
            case HAND_FRONT:
                handSnapShot.addAll(playerHand);
                handSnapShot.addAll(playerFront);
                break;
            case HAND:
                handSnapShot.addAll(playerHand);
                break;
            case FRONT:
                handSnapShot.addAll(playerFront);
                break;
            case GOLD_REWARD:
                break;
        }

        return handSnapShot;
    }

    public DeckAble getRandomCard(ZONE zone) {
        switch (zone) {
            case HAND:
                return playerHand.get((int) (playerHand.size() * Math.random()));
        }

        return null;
    }

    public void stealCardFromPlayer(DeckAble card, GamePlayer player, boolean wasInFront) {
        if (card != null && player != null) {
            this.stealCard(card, player, wasInFront);
        }
    }

    public void discardCardFromPlayer(DeckAble card, GamePlayer player, boolean wasInFront) {
        if (card != null && player != null) {
            removeFromFront(card);
            removeFromHand(card);
        }
    }

    public List<DeckAble> getAllTesting() {
        List<DeckAble> re = new ArrayList<>();

        Comparator<IsRevealAble> comparator = (x, y) -> (x.getPriority() > y.getPriority()) ? 1 : -1;

        return re;
    }

    public boolean hasCardOfInFrontItSelf(ArrayList<Class> classes) {
        for (DeckAble frontCard: playerFront) {
            if (classes.contains(frontCard.getClass())) {
                return true;
            }
        }
        return false;
    }

    public int getWeaponRange() {
        for (DeckAble frontCard: playerFront) {
            if (frontCard instanceof IsWeapon) {
                return ((IsWeapon) frontCard).getMaxWeaponRange();
            }
        }

        return 1;
    }

    public void responseToShotFromWithCard(Game game, GamePlayer sourcePlayer, CardBang cardBang, int missedNeeded) {
        List<DeckAble> missOptions = getAllCardsWithMissed(game);

        if (missOptions.isEmpty()) {
            takeDamage(1);
            return;
        }

        DeckAble miss = OptionScanner.scanForObjectSpecificList("Choice missed option", missOptions, 0, missOptions.size(), null);

        if (miss != null) {
            boolean wasSuccess = ((IAvoidable) miss).processAvoidAction(game, this);
        } else {
            takeDamage(1);
        }
    }

    private void takeDamage(int i) {
        currentHp--;
    }

    public List<DeckAble> getAllCardsWithMissed(Game game) {
        List<DeckAble> missOtionCard = new ArrayList<>();

        for (DeckAble handCard: playerHand) {
            if (handCard instanceof IAvoidable) {
                IAvoidable miss = ((IAvoidable) handCard);
                if (miss.canBeUsed(game)) {
                    missOtionCard.add(handCard);
                }
            }
        }

        for (DeckAble frontCard: playerFront) {
            if (frontCard instanceof IAvoidable) {
                IAvoidable miss = ((IAvoidable) frontCard);
                if (miss.canBeUsed(game)) {
                    missOtionCard.add(frontCard);
                }
            }
        }

        return missOtionCard;
    }

    public int getLoadCount() {
        return loadCount + getLoadCountAmongDangerous();
    }

    private int getLoadCountAmongDangerous() {
        int totalLoadCounters = 0;

        for (DeckAble front: playerFront) {
            if (front instanceof OrangeBorderCard) {
                OrangeBorderCard orange = (OrangeBorderCard) front;
                totalLoadCounters += orange.getLoadCount();
            }
        }
        return 0;
    }

    public DeckAble discardCardByChoice(Game game) {

        DeckAble discarded = OptionScanner.scanForObjectSpecificList("Which card should" + this + " to discard",
                playerHand,
                0, playerHand.size(),
                null);

        if (discarded != null) {
            game.getPile(DeckName.DISCARD_PILE).putOnTop(discarded);
            playerHand.remove(discarded);
            discarded.addRecordOfDiscard();
        }

        return  discarded;
    }

    public void replaceOldWeapon(Game game, DeckAble newGun) {
        List<DeckAble> oldWeapons = new ArrayList<>();

        for (DeckAble frontCard: playerFront) {
            if (frontCard == newGun) {
                continue;
            }
            if (frontCard instanceof IsWeapon) {
                oldWeapons.add(frontCard);
            }
        }

        for (DeckAble oldGun : oldWeapons) {
            game.getPile(DeckName.DISCARD_PILE).putOnTop(oldGun);
            playerFront.remove(oldGun);
            game.markStep(new GameStepDiscardWeapon(game, this, (GameCard) oldGun, (GameCard) newGun));
        }
    }

    public int getMissedNeed(GameCard shootCard) {
        return currentChar.howManyMissedNeededVs(shootCard);
    }

    public void print(GameEngine gameEngine, Game game, GamePlayer active, GamePlayer previous, GamePlayer next) {
        printSeparation(previous, this, active, "-", "=");

        System.out.println(getName() + " " + getCurrentRole() + " " + getCurrentCharacter().getCardName() + "[" + getCurrentHp()+"/"+ getCurrentMaxHp()+"]Hand:["+ getAllCardsCount(CARD_ATTRIBUTE.CAUSE_FOR_ANY, ZONE.HAND)+"/" + getCurrentHp() +"]");

        System.out.println("Front[" + playerFront.size() + "]");

        for (DeckAble front: playerFront) {
            System.out.println("\t" + front);
        }

        printSeparation(this, next, active, "-", "=");
        
    }

    private void printSeparation(GamePlayer previous, GamePlayer next, GamePlayer active, String signNormal, String signActive) {
        String paint = signNormal;

        if (this== active) {
            paint = signActive;
        }

        if (previous == null && next != null) {

            for (int i = 0; i < 7; i++) {
                System.out.print("+");
                for (int j = 0; j < 5; j++) {
                    System.out.print(paint);
                }
            }
            System.out.print("+");
            System.out.println();
        }

        if (previous == this && next != null) {
            for (int i = 0; i < 7; i++) {
                System.out.print("+");
                for (int j = 0; j < 5; j++) {
                    System.out.print(paint);
                }
            }
            System.out.print("+");
            System.out.println();
        }

        if (previous != null && next == null) {
            for (int i = 0; i < 7; i++) {
                System.out.print("+");
                for (int j = 0; j < 5; j++) {
                    System.out.print(paint);
                }
            }
            System.out.print("+");
            System.out.println();
        }
    }

    public int getMaxReach() {
        return calculateCurrentReach();
    }

    private int calculateCurrentReach() {
        int reach = baseReach;

        for (DeckAble front: playerFront) {
            if (front instanceof IsReach) {
                IsReach isReach = (IsReach) front;
                baseReach += isReach.getReachInc();
            }
        }

        return reach;
    }
}

