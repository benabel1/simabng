package org.example.game.cards.blue.dodge;

import org.example.game.cards.IsReach;
import org.example.game.cards.PokerValue;
import org.example.game.cards.Suit;
import org.example.game.cards.blue.BlueBorderCard;

public class CardBinocular extends BlueBorderCard implements IsReach {
    public CardBinocular(Suit suit, PokerValue pokerValue) {
        super(suit, pokerValue);
        this.cardName = "BINOCULAR";
    }
}
