package org.example.game.cards.brown.basic;

import org.example.game.Game;
import org.example.game.GamePlayer;
import org.example.game.cards.DistanceAllowedTarget;
import org.example.game.cards.IAvoidable;
import org.example.game.cards.PokerValue;
import org.example.game.cards.Suit;
import org.example.game.cards.brown.BrownBorderCard;
import org.example.game.deck.DeckName;

public class CardMissed extends BrownBorderCard implements IAvoidable {
    public CardMissed(Suit suit, PokerValue pokerValue) {
        super(suit, pokerValue);
        this.cardName = "MISSED!";
        this.canPlayedOnSideOfTurn = false;
        this.canPlayedOutSideOfTurn = true;

        this.allowedTarget = DistanceAllowedTarget.MYSELF;
    }

    @Override
    public boolean canBeUsed(Game game) {
        return true;
    }

    @Override
    public boolean processAvoidAction(Game game, GamePlayer defendingPlayer) {
        defendingPlayer.removeFromHand(this);
        addRecordOfPlay();
        game.getPile(DeckName.DISCARD_PILE).putOnTop(this);
        game.log(2, "[" + defendingPlayer + "]"+ this + " was played");

        return true;
    }
}
