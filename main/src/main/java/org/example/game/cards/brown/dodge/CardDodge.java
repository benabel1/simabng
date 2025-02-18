package org.example.game.cards.brown.dodge;

import org.example.game.Game;
import org.example.game.GamePlayer;
import org.example.game.cards.IAvoidable;
import org.example.game.cards.PokerValue;
import org.example.game.cards.Suit;
import org.example.game.cards.brown.BrownBorderCard;
import org.example.game.deck.DeckName;

public class CardDodge extends BrownBorderCard implements IAvoidable {
    public CardDodge(Suit s, PokerValue p) {
        super(s, p);
        this.cardName = "DODGE";

        this.canPlayedOnSideOfTurn = false;
        this.canPlayedOutSideOfTurn = true;
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

        //second effect
        defendingPlayer.drawCard(game.drawCard(), false);

        return true;
    }


}
