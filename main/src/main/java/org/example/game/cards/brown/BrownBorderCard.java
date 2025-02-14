package org.example.game.cards.brown;

import org.example.game.Game;
import org.example.game.GamePlayer;
import org.example.game.cards.DistanceAllowedTarget;
import org.example.game.cards.GameCard;
import org.example.game.cards.PokerValue;
import org.example.game.cards.Suit;
import org.example.game.deck.DeckName;

import static org.example.game.cards.CardBorderColor.BROWN;

public class BrownBorderCard extends GameCard {
    public BrownBorderCard(Suit s, PokerValue p) {
        super(s, p);
        //default setup values
        this.color = BROWN;
        this.canPlayedOnSideOfTurn = true;
        this.canPlayedOutSideOfTurn = false;
    }

    @Override
    public boolean canBePlayedFromHand(Game game) {
        return canPlayedOnSideOfTurn;
    }

    @Override
    public void playCardFromHand(Game game, GamePlayer sourcePlayer) {
        //card without target
        if (allowedTarget == DistanceAllowedTarget.NONE) {
            sourcePlayer.removeFromHand(this);
            addRecordOfPlay();
            game.getPile(DeckName.DISCARD_PILE).putOnTop(this);
            game.log(2, "[" + sourcePlayer + "]"+ this + " was played");
        }

        if (allowedTarget == DistanceAllowedTarget.ALL) {
            sourcePlayer.removeFromHand(this);
            addRecordOfPlay();
            game.getPile(DeckName.DISCARD_PILE).putOnTop(this);
            game.log(2, "[" + sourcePlayer + "]"+ this + " was played");
        }

        if (allowedTarget == DistanceAllowedTarget.OTHERS) {
            sourcePlayer.removeFromHand(this);
            addRecordOfPlay();
            game.getPile(DeckName.DISCARD_PILE).putOnTop(this);
            game.log(2, "[" + sourcePlayer + "]"+ this + " was played");

            for (GamePlayer other: game.getActivePlayers(sourcePlayer)) {
                applyPartOfEffectOnOtherPlayer(game, sourcePlayer, other);
            }
        }

        if (allowedTarget == DistanceAllowedTarget.OTHER) {
            sourcePlayer.removeFromHand(this);
            addRecordOfPlay();
            game.getPile(DeckName.DISCARD_PILE).putOnTop(this);
            game.log(2, "[" + sourcePlayer + "]"+ this + " was played");

        }

        if (allowedTarget == DistanceAllowedTarget.WEAPON_RANGE) {
            sourcePlayer.removeFromHand(this);
            addRecordOfPlay();
            game.getPile(DeckName.DISCARD_PILE).putOnTop(this);
            game.log(2, "[" + sourcePlayer + "]"+ this + " was played");
        }
    }
    @Override
    public void applyPartOfEffectOnOtherPlayer(Game game, GamePlayer sourcePlayer, GamePlayer other) {
    }
}
