package org.example.game.cards.orange.dangerous;

import org.example.game.Game;
import org.example.game.GamePlayer;
import org.example.game.wheel.PairPlayerCard;
import org.example.game.cards.PokerValue;
import org.example.game.cards.Suit;
import org.example.game.cards.orange.OrangeBorderCard;
import org.example.game.options.scaner.OptionScanner;

import static org.example.game.cards.ZONE.HAND;

public class CardLockPick extends OrangeBorderCard {
    public CardLockPick(Suit s, PokerValue p) {
        super(s, p);
        this.cardName = "LOCK PICK";

        this.costOfActivation = 3;
    }

    @Override
    public void useCardInGame(Game game, GamePlayer ownerPlayer) {
        super.useCardInGame(game, ownerPlayer);

        if (canBeUsedInGame(game)) {

            if (game.isThereCardInGameAtAnyDistanceToBeStolen(ownerPlayer, HAND)) {

                PairPlayerCard lockPickedPair = OptionScanner.scanForPlayerOtherThanDistance(game, ownerPlayer, 100);

                if (lockPickedPair != null) {
                    ownerPlayer.stealCardFromPlayer(lockPickedPair.getCard(), lockPickedPair.getPlayer());
                }
            }
        }
    }
}
