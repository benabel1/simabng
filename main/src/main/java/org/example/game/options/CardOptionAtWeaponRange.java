package org.example.game.options;

import org.example.game.Game;
import org.example.game.GamePlayer;
import org.example.game.cards.GameCard;
import org.example.game.options.scaner.OptionScanner;
import org.example.game.wheel.PairPlayerDistance;

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

          for (PairPlayerDistance pair: potencialTargets) {
              System.out.println("\t\t" + potencialTargets.indexOf(pair) + " - [" + pair.getPlayerAtDistance() + "]" + pair.getPlayer());
          }

          PairPlayerDistance pairPlayer = OptionScanner
                  .scanForObjectSpecificList("Choose target at range", potencialTargets, 0, potencialTargets.size(), null);


          if (pairPlayer != null && pairPlayer.getPlayer() != null) {
            cardSource.playCardFromHand(game, , sourcePlayer, pairPlayer.getPlayer());
          }
      }
    }

    @Override
    public boolean canBeResolved(Game game) {
        return true;
    }

    @Override
    public String toString() {
        return cardSource + " - range(" + maxRange + ")" + sourcePlayer;
    }
}
