package org.example.game.options;

import org.example.game.Game;
import org.example.game.cards.GameCard;
import org.example.game.GamePlayer;

public class CardOption extends OptionOption {
    protected final GameCard cardSource;

    public CardOption(GameCard card, GamePlayer player) {
        super(player);
        this.cardSource = card;
    }

    @Override
    public void resolveInThisGame(Game game) {
      if (canBeResolved(game)) {
          cardSource.playCardFromHand(game,this, sourcePlayer);
      }
    }

    @Override
    public boolean canBeResolved(Game game) {
        return !wasUndo && cardSource != null && sourcePlayer != null;
    }

    @Override
    public String toString() {
        return cardSource + " - " + sourcePlayer;
    }

}
