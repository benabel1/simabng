package org.example.game.cards.brown.basic;

import org.example.game.Game;
import org.example.game.GamePlayer;
import org.example.game.cards.DeckAble;
import org.example.game.cards.PokerValue;
import org.example.game.cards.Suit;
import org.example.game.cards.brown.BrownBorderCard;

import java.util.ArrayList;
import java.util.List;

public class CardGeneralStore extends BrownBorderCard {
    public CardGeneralStore(Suit suit, PokerValue pokerValue) {
        super(suit, pokerValue);
        this.cardName = "GENERAL STORE";
    }

    @Override
    public void playCard(Game game, GamePlayer sourcePlayer) {
        super.playCard(game, sourcePlayer);

        List<DeckAble> generalStoreCards = new ArrayList<>();
        int  alivePlayersCount = game.getActivePlayers();

        for (int i = 0; i < alivePlayersCount; i++) {
            generalStoreCards.add(game.drawCard());
        }

    }
}
