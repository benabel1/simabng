package org.example.game.cards;

import org.example.game.Game;
import org.example.game.deck.DeckAble;

/**
 * Generation strategy from given list of adjusted characters versions
 */
public class SelectionCardsStrategyForRandom extends SelectionCardsStrategy {

    @Override
    public DeckAble choiceOne(Game game, DeckAble ... listOptions) {
        int randIndex = -1;

        if (listOptions == null || listOptions.length < 1) {
            return null;
        }

        randIndex = (int) (Math.random() * listOptions.length);

        return listOptions[randIndex];
    }
}
