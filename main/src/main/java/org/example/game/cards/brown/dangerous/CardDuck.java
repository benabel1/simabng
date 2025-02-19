package org.example.game.cards.brown.dangerous;

import org.example.game.Game;
import org.example.game.GamePlayer;
import org.example.game.cards.IAvoidable;
import org.example.game.cards.PokerValue;
import org.example.game.cards.Suit;
import org.example.game.deck.DeckName;

public class CardDuck extends BrownBorderCardBoostable implements IAvoidable {
    public CardDuck(Suit suit, PokerValue pokerValue) {
        super(suit, pokerValue);
        this.cardName = "DUCK";

        this.boostCost = 2;
    }

    @Override
    public boolean canBeUsed(Game game) {
        return turnOfPlay != game.geActtiveTurn();
    }

    @Override
    public boolean processAvoidAction(Game game, GamePlayer defendingPlayer) {
        defendingPlayer.removeFromHand(this);
        addRecordOfPlay();

        if (defendingPlayer.getLoadCount() > boostCost) {
            game.getPile(DeckName.DISCARD_PILE).putOnTop(this);
            game.log(2, "[" + defendingPlayer + "]"+ this + " was played");
        } else {
            game.getPile(DeckName.DISCARD_PILE).putOnTop(this);
            game.log(2, "[" + defendingPlayer + "]"+ this + " was played");
        }

        return true;
    }
}
