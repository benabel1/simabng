package org.example.game.cards.brown.basic;

import org.example.game.Game;
import org.example.game.GamePlayer;
import org.example.game.cards.DistanceAllowedTarget;
import org.example.game.cards.PokerValue;
import org.example.game.cards.Suit;
import org.example.game.cards.brown.BrownBorderCard;
import org.example.game.options.CardOption;

public class CardCatBalou extends BrownBorderCard {
    public CardCatBalou(Suit suit, PokerValue pokerValue) {
        super(suit, pokerValue);
        this.cardName = "CAT BALOU";

        this.allowedTarget = DistanceAllowedTarget.CARD_HAND_FRONT_ANY_DISTANCE;
    }

    @Override
    public void playCardFromHand(Game game, CardOption option, GamePlayer sourcePlayer) {
        super.playCardFromHand(game, option, sourcePlayer);

    }
}
