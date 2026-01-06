package org.example.game.cards.blue.basic;

import org.example.game.Game;
import org.example.game.GamePlayer;
import org.example.game.cards.*;
import org.example.game.cards.blue.BlueBorderCard;

public class CardBarrel extends BlueBorderCard implements IAvoidable, IsRevealAble {
    GameCard lastCardAvoided;

    public CardBarrel(Suit s, PokerValue p) {
        super(s, p);
        this.cardName = "BARREL";
    }

    @Override
    public boolean canBeUsed(Game game) {
        return true;
    }

    @Override
    public boolean processAvoidAction(Game game, GamePlayer defendingPlayer, GameCard cardBang) {
        if (cardBang != lastCardAvoided) {
            addRecordOfUsageInPlay();
            this.lastCardAvoided = cardBang;
            game.log(2, "[" + defendingPlayer + "]"+ this + " was played");

            boolean success = game.revealCard((IsRevealAble) this, defendingPlayer.getCountOfReveal());
            if (success) {
                addRecordOfSuccess();
            }

            return success;
        } else {
            return false;
        }
    }

    @Override
    public boolean matchSuitAndPoker(GameCard deckAble) {
        return deckAble.getSuit() == Suit.HEARTHS;
    }
    @Override
    public String getPriorityType() {
        return "NONE";
    }

    @Override
    public boolean mustBeDiscardedAfterSuccessMiss() {
        return false;
    }
}
