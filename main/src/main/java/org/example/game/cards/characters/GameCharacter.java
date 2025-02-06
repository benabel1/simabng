package org.example.game.cards.characters;

import org.example.game.*;
import org.example.game.cards.DeckAble;
import org.example.game.cards.GameRecordAble;

import java.util.List;

public class GameCharacter extends DeckAble implements GameRecordAble {
    protected int maxHp, startHp;
    protected int startHand;
    protected int drawInTurnCards;
    protected String charAbility;

    protected boolean isAbilityPhase01;
    protected boolean isAbilityPhase02;
    protected boolean isAbilityPhase03;


    protected boolean isAbilityInTurnOfYour;
    protected boolean isAbilityOutTurnOfYour;

    protected boolean isPassiveAbility;
    protected boolean isaActiveAbility;

    public GameCharacter() {
        //default values
        this.cardName ="set name for " + this.getClass().getCanonicalName();
        this.charAbility = "None Name Set";

        this.maxHp = 4;
        this.startHp = 4;
        this.startHand = 4;

        this.drawInTurnCards = 2;


    }

    public void playedCard(Game game, GameCard card) {

    }

    public int getMaxHp() {
        return maxHp;
    }

    public int getStartHp() {
        return startHp;
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
        return new CharacterOption(this, gamePlayer);
    }

    @Override
    public boolean canBePlay() {
        return false;
    }
}
