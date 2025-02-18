package org.example.game.cards.brown.basic;

import org.example.game.Game;
import org.example.game.GamePlayer;
import org.example.game.deck.DeckAble;
import org.example.game.cards.PokerValue;
import org.example.game.cards.Suit;
import org.example.game.cards.brown.BrownBorderCard;
import org.example.game.options.OptionScanner;

import java.util.ArrayList;
import java.util.List;

import static org.example.game.cards.DistanceAllowedTarget.ALL;

public class CardGeneralStore extends BrownBorderCard {

    public CardGeneralStore(Suit suit, PokerValue pokerValue) {
        super(suit, pokerValue);
        this.cardName = "GENERAL STORE";

        this.allowedTarget = ALL;
    }

    @Override
    public void playCardFromHand(Game game, GamePlayer sourcePlayer) {
        super.playCardFromHand(game, sourcePlayer);

        List<DeckAble> generalStoreCards = new ArrayList<>();
        int  alivePlayersCount = game.getActivePlayersCount();

        for (int i = 0; i < alivePlayersCount; i++) {
            generalStoreCards.add(game.drawCard());
        }

        List<GamePlayer> activesInOrderIToCloc = game.getPlayersFromACurrentToOthersInOrderSkippedEliminated(sourcePlayer, true);

        for (int i = 0; i < generalStoreCards.size(); i++) {
            DeckAble pickedCard = null;

            OptionScanner.scanForObjectSpecificList("Select one card from " + this , generalStoreCards, 0, generalStoreCards.size(), -1);
        }

    }
}
