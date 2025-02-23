package org.example.game.cards.brown.basic;

import org.example.game.Game;
import org.example.game.GamePlayer;
import org.example.game.cards.DistanceAllowedTarget;
import org.example.game.cards.PokerValue;
import org.example.game.cards.Suit;
import org.example.game.cards.brown.BrownBorderCard;
import org.example.game.deck.DeckAble;
import org.example.game.options.CardOption;
import org.example.game.options.CardOptionAtWeaponRange;
import org.example.game.options.OptionOption;

public class CardBang extends BrownBorderCard {

    public CardBang(Suit s, PokerValue p) {
        super(s, p);
        this.cardName = "BANG!";

        this.allowedTarget = DistanceAllowedTarget.WEAPON_RANGE;
    }

    @Override
    public boolean canBePlayedFromHand(Game game, GamePlayer player) {
        return game.wasPlayedLessThan(this, 1);
    }

    @Override
    public void playCardFromHand(Game game, CardOption option, GamePlayer sourcePlayer, GamePlayer targetPlayer) {
        super.playCardFromHand(game, option, sourcePlayer, targetPlayer);
        if (sourcePlayer != null && targetPlayer != null) {
            targetPlayer.responseToShotFromWithCard(game, sourcePlayer, this, sourcePlayer.getMissedNeed(this));
            game.increaseLimitTurnCount(this.getClass());
        }
    }

}
