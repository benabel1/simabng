package org.example.game.options;

import org.example.game.Game;
import org.example.game.GamePlayer;
import org.example.game.cards.GameCard;
import java.util.List;

public class CardOptionAtWeaponRange extends CardOption {
    protected int maxRange;

    public CardOptionAtWeaponRange(GameCard card, GamePlayer player, int maxRange) {
        super(card, player);
        this.maxRange = maxRange;
    }

    @Override
    public void resolveInThisGame(Game game) {
      if (canBeResolved(game)) {

          List<PairPlayerDistance> potencialTargets = game.getPlayersFromPlayerAtMaxDistance(sourcePlayer, maxRange);

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
