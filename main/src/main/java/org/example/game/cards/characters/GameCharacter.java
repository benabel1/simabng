package org.example.game.cards.characters;

import org.example.game.*;
import org.example.game.options.CharacterOption;
import org.example.game.deck.DeckAble;
import org.example.game.cards.GameCard;
import org.example.game.cards.IsGameRecordAble;
import org.example.game.options.OptionOption;

import java.util.ArrayList;
import java.util.List;

public class GameCharacter extends DeckAble implements IsGameRecordAble {
    protected int maxHp, startHp;
    protected int startHand;
    protected int drawInTurnCards;
    protected String textForCharAbility;
    protected String textForActivationAbilityText;

    protected boolean isAbilityPhase01;


    protected boolean isAbilityPhase02;
    protected boolean isAbilityPhase03;


    protected boolean isAbilityInTurnOfYour;
    protected boolean isAbilityOutTurnOfYour;

    protected boolean isPassiveAbility;
    protected boolean isaActiveAbility;
    protected boolean hasAbilityOfItsCost;
    protected int loadCounters;

    public GameCharacter() {
        //default values
        this.cardName ="set name for " + this.getClass().getCanonicalName();
        this.textForCharAbility = "None Name Set";

        this.maxHp = 4;
        this.startHp = 4;
        this.startHand = startHp;

        this.drawInTurnCards = 2;
    }

    public boolean isAbilityPhase02() {
        return isAbilityPhase02;
    }

    public boolean isIsaActiveAbility() {
        return isaActiveAbility;
    }
    public void playedCard(Game game, GameCard card) {

    }

    public int getMaxHp() {
        return maxHp;
    }

    public int getStartHp() {
        return startHp;
    }

    public int getHandLimitSize(GamePlayer player) {
        return player.getCurrentHp();
    }

    //TODO Need implementation
    public List<DeckAble> drawInitialHand(Game game) {
        return game.getEngine().drawCards(startHand, game);
    }

    //TODO Need implementation
    public List<DeckAble> drawInTurn(GameEngine engine) {
        return null;
    }

    @Override
    public String getUniqueNameForRecording() {
        return this.getClass().getName().replaceFirst("Char","");
    }

    @Override
    public String toString() {
        return getCardName();
    }

    @Override
    public OptionOption generateOption(DeckAble card, GamePlayer gamePlayer) {
        if (isAbilityPhase02) {
            return new CharacterOption(this, gamePlayer);
        } else {
//            return null;
            return new CharacterOption(this, gamePlayer);
        }
    }

    @Override
    public boolean canBePlayedFromHand(Game game, GamePlayer player) {
        return false;
    }

    @Override
    public boolean canBeUsedInGame(Game game) {
        return false;
    }

    public void notifyP(GameCard card, GamePlayer sourcePlayer, Game game) {

    }

    public List<DeckAble> resolveDrawingPhase(Game game) {
        List<DeckAble> drawnCardsPhaseOne = new ArrayList<>();
        if (isAbilityPhase01) {

        } else {
            DeckAble card1 = game.drawCard();
            DeckAble card2 = game.drawCard();

            drawnCardsPhaseOne.add(card1);
            drawnCardsPhaseOne.add(card2);
        }

        return  drawnCardsPhaseOne;
    }

    public int howManyMissedNeededVs(GameCard shootingCard) {
        return 1;
    }

    public int getloadCount() {
        return loadCounters;
    }

    public void takeLoad(int i) {
        loadCounters -= i;
        loadCounters = Math.max(loadCounters, 0);
    }
}
