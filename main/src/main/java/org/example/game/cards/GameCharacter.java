package org.example.game.cards;

import org.example.game.Game;
import org.example.game.GameEngine;
import org.example.game.cards.DeckAble;

import java.util.List;

public class GameCharacter extends DeckAble {
    protected int maxHp, startHp;
    protected int startHand;
    protected int drawInTurnCards;
    protected String charAbility;

    public GameCharacter() {
        //default values
        this.charAbility = "None Name Set";
        this.maxHp = 4;
        this.startHp = 4;
        this.startHand = 4;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public int getStartHp() {
        return startHp;
    }

    //TODO Need implementation
    public List<DeckAble> drawInitialHand(Game game) {
        return game.getEngine().drawCards(startHand);
    }

    //TODO Need implementation
    public List<DeckAble> drawInTurn(GameEngine engine) {
        return null;
    }
}
