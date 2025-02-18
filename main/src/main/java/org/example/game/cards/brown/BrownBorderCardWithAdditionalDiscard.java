package org.example.game.cards.brown;

import org.example.game.Game;
import org.example.game.GamePlayer;
import org.example.game.cards.PokerValue;
import org.example.game.cards.Suit;

public class BrownBorderCardWithAdditionalDiscard extends BrownBorderCard{
    private static final int CARD_TO_BE_PLAYABLE = 2;

    public BrownBorderCardWithAdditionalDiscard(Suit s, PokerValue p) {
        super(s, p);
    }

    @Override
    public boolean canBePlayedFromHand(Game game, GamePlayer player) {

        if(player == null) {
            return false;
        } else {
            return player.getAllTesting().size() > CARD_TO_BE_PLAYABLE;
        }

    }
}
