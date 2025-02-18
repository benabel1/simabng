package org.example.game.cards.blue.basic;

import org.example.game.Game;
import org.example.game.GamePlayer;
import org.example.game.cards.IAvoidable;
import org.example.game.cards.PokerValue;
import org.example.game.cards.Suit;
import org.example.game.cards.blue.BlueBorderCard;

public class CardBarrel extends BlueBorderCard implements IAvoidable {

    public CardBarrel(Suit s, PokerValue p) {
        super(s, p);
        this.cardName = "BARREL";
    }

    @Override
    public boolean canBeUsed(Game game) {
        return true;
    }

    @Override
    public boolean processAvoidAction(Game game, GamePlayer defendingPlayer) {
        addRecordOfUsageInPlay();
        game.log(2, "[" + defendingPlayer + "]"+ this + " was played");

        return true;
    }
}
