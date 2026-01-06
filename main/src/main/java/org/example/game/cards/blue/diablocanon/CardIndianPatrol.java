package org.example.game.cards.blue.diablocanon;

import org.example.game.cards.PokerValue;
import org.example.game.cards.Suit;
import org.example.game.cards.blue.BlueBorderCard;
import org.example.game.cards.blue.BlueWeapon;

public class CardIndianPatrol extends BlueBorderCard {
    public CardIndianPatrol(Suit suit, PokerValue pokerValue) {
        super(suit, pokerValue);
        this.cardName = "Indian  Patrol";
        this.textOnCard = "You are immune to INDIAN";
    }
}
