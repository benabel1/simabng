package org.example.game.cards.brown.valley;

import org.example.game.Game;
import org.example.game.GamePlayer;
import org.example.game.cards.PokerValue;
import org.example.game.cards.Suit;
import org.example.game.cards.brown.BrownBorderCard;
import org.example.game.options.CardOption;

public class CardFanning extends BrownBorderCard {
    public CardFanning(Suit suit, PokerValue pokerValue) {
        super(suit, pokerValue);
        this.cardName = "FANNING";
    }

    @Override
    public void playCardFromHand(Game game, CardOption option, GamePlayer sourcePlayer) {
        super.playCardFromHand(game, option, sourcePlayer);

        if (game.canBeLifeRestoreBy(this)) {
            sourcePlayer.restoreLife(1);
        }
        game.notifyAllOther(this, sourcePlayer);
    }
}
