package org.example.game.cards.brown.basic;

import org.example.game.Game;
import org.example.game.GamePlayer;
import org.example.game.cards.DistanceAllowedTarget;
import org.example.game.cards.PokerValue;
import org.example.game.cards.Suit;
import org.example.game.cards.brown.BrownBorderCard;
import org.example.game.deck.DeckAble;
import org.example.game.deck.DeckName;
import org.example.game.options.CardOption;
import org.example.game.options.scaner.OptionScanner;

import java.util.List;

public class CardDuel extends BrownBorderCard {
    public CardDuel(Suit suit, PokerValue pokerValue) {
        super(suit, pokerValue);
        this.cardName = "DUEL";

        this.allowedTarget = DistanceAllowedTarget.OTHER;
        this.canPlayedOnSideOfTurn = true;

        this.cardDamage = 1;
    }

    @Override
    public void playCardFromHand(Game game, CardOption option, GamePlayer sourcePlayer, GamePlayer targetPlayer) {
        DeckAble bangCard = null;
        GamePlayer next = targetPlayer;

        if (sourcePlayer == null || targetPlayer == null) {
            return;
        } else {
            super.playCardFromHand(game, option, sourcePlayer, targetPlayer);

            do {
                List<DeckAble> bangInHand = next.getAllCardsWithBangs(game);
                bangCard = OptionScanner.scanForObjectSpecificList(next + " choose which BNAG to discard: ", bangInHand, 0, bangInHand.size(), null);

                if (bangCard != null) {
                    game.getPile(DeckName.DISCARD_PILE).putOnTop(bangCard);
                    next.removeFromFront(bangCard);
                    next = next != sourcePlayer? sourcePlayer: targetPlayer;
                }
            }
            while(bangCard != null);
            next.takeDamage(getCardDamage());

            option.setAsResolved();
        }
    }
}
