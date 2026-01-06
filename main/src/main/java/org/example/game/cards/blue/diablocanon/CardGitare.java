package org.example.game.cards.blue.diablocanon;

import org.example.game.cards.IsReach;
import org.example.game.cards.PokerValue;
import org.example.game.cards.Suit;
import org.example.game.cards.blue.BlueBorderCard;
import org.example.game.cards.blue.BlueWeapon;

public class CardGitare extends BlueWeapon {
    public CardGitare(Suit suit, PokerValue pokerValue) {
        super(suit, pokerValue);
        this.cardName = "Gitare";
        this.textOnCard = "You cannot play #BANG! cards";

        this.maxRange = 0;
    }
}
