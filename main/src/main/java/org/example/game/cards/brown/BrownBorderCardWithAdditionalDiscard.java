package org.example.game.cards.brown;

import org.example.game.Game;
import org.example.game.GamePlayer;
import org.example.game.cards.PokerValue;
import org.example.game.cards.Suit;
import org.example.game.deck.DeckAble;

import java.util.ArrayList;
import java.util.List;

public class BrownBorderCardWithAdditionalDiscard extends BrownBorderCard{
    private static final int CARD_TO_BE_PLAYABLE = 2;
    private final List<DeckAble> cardsAsPayments;

    public BrownBorderCardWithAdditionalDiscard(Suit s, PokerValue p) {
        super(s, p);
        cardsAsPayments = new ArrayList<>();
    }

    @Override
    public boolean canBePlayedFromHand(Game game, GamePlayer player) {

        if(player == null) {
            return false;
        } else {
            return player.getAllTesting().size() > CARD_TO_BE_PLAYABLE;
        }

    }

    @Override
    public void playCardFromHand(Game game, GamePlayer sourcePlayer, GamePlayer targetPlayer) {
        super.playCardFromHand(game, sourcePlayer, targetPlayer);

        DeckAble card = sourcePlayer.discardCardByChoice(game);
        this.cardsAsPayments.add(card);

    }
}
