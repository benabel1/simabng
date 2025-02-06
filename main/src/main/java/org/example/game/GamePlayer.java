package org.example.game;

import org.example.game.cards.DeckAble;
import org.example.game.cards.GameCharacter;

import java.util.ArrayList;
import java.util.List;

public class GamePlayer {
    private final String name;
    private final int order;

    private boolean isEliminated;
    private int orderElimination;

    private int currentHp;

    private GameCharacter startChar;
    private GameCharacter currentChar;

    private List<DeckAble> playerHand;
    private List<DeckAble> playerFront;

    public GamePlayer(String name, int orderNumber) {
        this.name= name;
        this.order = orderNumber;

        initPlayerGameElements();

        System.out.println("Player " + name + " was created with order: " + orderNumber);
    }

    private void initPlayerGameElements() {
        playerHand = new ArrayList<>();
        playerFront = new ArrayList<>();
    }

    private void assignStartingCharacter(GameCharacter character) {
        if (this.startChar == null &&  character != null) {
            this.startChar = character;
        }
    }

    public int getCurrentHp() {
        return currentHp;
    }

    public GamePlayer setCurrentHp(int currentHp) {
        this.currentHp = currentHp;
        return this;
    }
}
