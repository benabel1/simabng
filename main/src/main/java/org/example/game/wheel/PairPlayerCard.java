package org.example.game.wheel;

import org.example.game.GamePlayer;
import org.example.game.deck.DeckAble;

public class PairPlayerCard {
    final GamePlayer player;
    final DeckAble card;

    public PairPlayerCard(GamePlayer player, DeckAble card) {
        this.player = player;
        this.card = card;
    }
    public GamePlayer getPlayer() {
        return player;
    }

    public DeckAble getCard() {
        return card;
    }

    @Override
    public String toString() {
        return "[" + player + "][" + card + "]";
    }
}
