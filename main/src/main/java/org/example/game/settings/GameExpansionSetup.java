package org.example.game.settings;

import org.example.game.DeckName;
import org.example.game.Game;
import org.example.game.cards.DeckAble;
import org.example.game.cards.PokerValue;
import org.example.game.cards.Suit;

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

    protected abstract List<DeckAble> createListCardsCharacterDeck();

    protected abstract List<DeckAble> createListCardsSpecialDeck();

    //special partial decks
    protected abstract  void createBlueBorderCards(List<DeckAble> result);

    protected abstract void createBrownBorderCards(List<DeckAble> result);

    protected abstract void createGreenBorderCards(List<DeckAble> result);
}
