package org.example.game.cards.brown.basic;

import org.example.game.Game;
import org.example.game.GamePlayer;
import org.example.game.cards.PokerValue;
import org.example.game.cards.Suit;
import org.example.game.cards.brown.BrownBorderCard;

public class CardCatBalou extends BrownBorderCard {
    public CardCatBalou(Suit suit, PokerValue pokerValue) {
        super(suit, pokerValue);
        this.cardName = "CAT BALO";
    }

    @Override
    public void playCard(Game game, GamePlayer sourcePlayer) {
        super.playCard(game, sourcePlayer);

    }
}
