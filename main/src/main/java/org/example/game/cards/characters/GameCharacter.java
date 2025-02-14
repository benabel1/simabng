package org.example.game.cards.characters;

import org.example.game.*;
import org.example.game.options.CharacterOption;
import org.example.game.deck.DeckAble;
import org.example.game.cards.GameCard;
import org.example.game.cards.GameRecordAble;
import org.example.game.options.OptionOption;

import java.util.ArrayList;
import java.util.List;

public class GameCharacter extends DeckAble implements GameRecordAble {
    protected int maxHp, startHp;
    protected int startHand;
    protected int drawInTurnCards;
    protected String charAbility;
    protected String activationAbility;

    protected boolean isAbilityPhase01;
    protected boolean isAbilityPhase02;
    protected boolean isAbilityPhase03;


    protected boolean isAbilityInTurnOfYour;
    protected boolean isAbilityOutTurnOfYour;

    protected boolean isPassiveAbility;
    protected boolean isaActiveAbility;
    protected boolean hasAbilityOfItsCost;

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
        if (isAbilityPhase02) {
            return new CharacterOption(this, gamePlayer);
        } else {
//            return null;
            return new CharacterOption(this, gamePlayer);
        }
    }

    @Override
    public boolean canBePlayedFromHand(Game game) {
        return false;
    }

    @Override
    public boolean canBeUsedInGame(Game game) {
        return false;
    }

    public void notifyP(String cardName, GamePlayer sourcePlayer) {

    }

    public List<DeckAble> resolveDrawingPhase(Game game) {
        List<DeckAble> drwanCards = new ArrayList<>();
        if (isAbilityPhase01) {

        } else {
            DeckAble card1 = game.drawCard();
            DeckAble card2 = game.drawCard();

            drwanCards.add(card1);
            drwanCards.add(card2);
        }

        return  drwanCards;
    }
}
