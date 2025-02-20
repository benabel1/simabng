package org.example.game.cards;

import org.example.game.Game;
import org.example.game.deck.DeckAble;

/**
 * Generation strategy from given list of adjusted characters versions
 */
public class SelectionCardsStrategyForFirst extends SelectionCardsStrategy {

    @Override
    public DeckAble choiceOne(Game game, DeckAble ... listOptions) {
        if (listOptions == null || listOptions.length < 1) {
            return null;
        }

        return listOptions[0];
    }
}
