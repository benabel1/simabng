package org.example.game.settings;

import org.example.game.deck.DeckName;
import org.example.game.Game;
import org.example.game.deck.DeckAble;

import java.util.List;

public abstract class GameExpansionSetup {
    protected boolean isTurnOn;

    public void applySetup(Game game) {
    }

    public boolean isTurnOn() {
        return isTurnOn;
    }

    public abstract void insertCardsForDeck(Game game, DeckName characters);

    protected abstract List<DeckAble> createListCardsPlayingDeck();

    protected abstract List<DeckAble> createListCardsCharacterDeck(Game game);

    protected abstract List<DeckAble> createListCardsSpecialDeck();

    //special partial decks
    protected abstract  void createBlueBorderCards(List<DeckAble> result);

    protected abstract void createBrownBorderCards(List<DeckAble> result);

    protected abstract void createGreenBorderCards(List<DeckAble> result);
}
