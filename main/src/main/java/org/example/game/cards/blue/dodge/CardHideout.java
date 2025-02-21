package org.example.game.cards.blue.dodge;

import org.example.game.cards.IsDistance;
import org.example.game.cards.PokerValue;
import org.example.game.cards.Suit;
import org.example.game.cards.blue.BlueBorderCard;

public class CardHideout extends BlueBorderCard implements IsDistance {
    public CardHideout(Suit suit, PokerValue pokerValue) {
        super(suit, pokerValue);
        this.cardName = "HIDEOUT";
    }
}
