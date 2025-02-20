package org.example.game.cards.brown.basic;

import org.example.game.Game;
import org.example.game.GamePlayer;
import org.example.game.cards.PokerValue;
import org.example.game.cards.Suit;
import org.example.game.cards.brown.BrownBorderCard;

public class CardBeer extends BrownBorderCard {
    public CardBeer(Suit suit, PokerValue pokerValue) {
        super(suit, pokerValue);
        this.cardName = "BEER";
    }

    @Override
    public void playCardFromHand(Game game, GamePlayer sourcePlayer) {
        super.playCardFromHand(game, sourcePlayer);

        if (game.canBeLifeRestoreBy(this)) {
            sourcePlayer.restoreLife(1);
        }
        game.notifyAllOther(this, sourcePlayer);
    }
}
