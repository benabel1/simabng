package org.example.game.options;

import org.example.game.Game;
import org.example.game.cards.GameCard;
import org.example.game.GamePlayer;

public class CardOption extends OptionOption {

    private final GameCard cardSource;
    private final GamePlayer sourcePlayer;

    public CardOption(GameCard card, GamePlayer player) {
        this.cardSource = card;
        this.sourcePlayer = player;
    }

    @Override
    public void resolveInThisGame(Game game) {
      if (canBeResolved(game)) {
          cardSource.playCardFromHand(game, sourcePlayer);
      }
    }

    @Override
    public boolean canBeResolved(Game game) {
        return true;
    }

    @Override
    public String toString() {
        return cardSource + " - " + sourcePlayer;
    }
}
