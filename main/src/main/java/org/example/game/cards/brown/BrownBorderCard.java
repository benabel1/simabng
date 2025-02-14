package org.example.game.cards.brown;

import org.example.game.Game;
import org.example.game.GamePlayer;
import org.example.game.cards.GameCard;
import org.example.game.cards.PokerValue;
import org.example.game.cards.Suit;
import org.example.game.deck.DeckName;

import static org.example.game.cards.CardBorderColor.BROWN;

public class BrownBorderCard extends GameCard {
    public BrownBorderCard(Suit s, PokerValue p) {
        super(s, p);
        //default setup values
        this.color = BROWN;
        this.canPlayedOnSideOfTurn = true;
        this.canPlayedOutSideOfTurn = false;
    }

    @Override
    public void playCard(Game game, GamePlayer sourcePlayer) {
        sourcePlayer.removeFromHand(this);
        game.getPile(DeckName.DISCARD_PILE).putOnTop(this);

    }
}
