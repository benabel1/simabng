package org.example.game.cards.green.duel;

import org.example.game.Game;
import org.example.game.GamePlayer;
import org.example.game.cards.*;
import org.example.game.cards.green.GreenBorderCard;

public class CardPardner extends GreenBorderCard implements IBangAble, IAvoidable {

    public CardPardner(Suit s, PokerValue p) {
        super(s, p);
        this.cardName = "Pardner";
    }

    @Override
    public boolean processAvoidAction(Game game, GamePlayer defendingPlayer, GameCard cardBang) {
        return false;
    }

    @Override
    public boolean mustBeDiscardedAfterSuccessMiss() {
        return IAvoidable.super.mustBeDiscardedAfterSuccessMiss();
    }

    @Override
    public boolean canBeUsed(Game game) {
        return false;
    }

    @Override
    public boolean mustBeDiscardedAfterSuccessBang() {
        return IBangAble.super.mustBeDiscardedAfterSuccessBang();
    }
}
