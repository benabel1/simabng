package org.example.game.cards.railcars;

import org.example.game.cards.SelectionCardsStrategy;
import org.example.game.deck.DeckAble;

import java.util.List;

public class CharacterCardCreator {

    public static DeckAble onlyOnfFrom(DeckAble ... character) {

        if (character == null || character.length == 0) {
            return null;
        }
        if (character.length == 1) {return character[0];}
        else {
            int randSelected = (int) (Math.random()*character.length);

            return character[randSelected];
        }
    }

    public static DeckAble onlyOnfFrom(SelectionCardsStrategy ssssTrategy, DeckAble ... character) {

        if (character == null || character.length == 0) {
            return null;
        }
        if (character.length == 1) {return character[0];}
        else {
            int randSelected = (int) (Math.random()*character.length);

            return character[randSelected];
        }
    }

    public static void createOneForListFromAllPotion(List<DeckAble> result, DeckAble ... chars) {
        DeckAble toInsert = onlyOnfFrom(chars);

        if (toInsert == null) {
            result.add(toInsert);
        }
    }
}
