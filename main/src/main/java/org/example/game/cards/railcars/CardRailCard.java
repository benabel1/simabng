package org.example.game.cards.railcars;

import org.example.game.Game;
import org.example.game.cards.GameCard;
import org.example.game.cards.PokerValue;
import org.example.game.cards.Suit;

import static org.example.game.cards.CardBorderColor.GRAY;

public class CardRailCard extends GameCard {
    public CardRailCard(Suit s, PokerValue p) {
        super(s, p);

        color = GRAY;


    }

    @Override
    public boolean canBePlayedFromHand(Game game) {
        return false;
    }

}
