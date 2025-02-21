package org.example.game.cards.green.dodge;

import org.example.game.Game;
import org.example.game.GamePlayer;
import org.example.game.cards.GameCard;
import org.example.game.cards.IAvoidable;
import org.example.game.cards.PokerValue;
import org.example.game.cards.Suit;
import org.example.game.cards.green.GreenBorderCard;
import org.example.game.deck.DeckName;

public class CardBible extends GreenBorderCard implements IAvoidable {
    public CardBible(Suit s, PokerValue p) {
        super(s, p);
        this.cardName = "BIBLE";
    }

    @Override
    public boolean canBeUsed(Game game) {
        return turnOfPlay != game.geActiveTurn();
    }

    @Override
    public boolean processAvoidAction(Game game, GamePlayer defendingPlayer, GameCard cardBang) {
        defendingPlayer.removeFromHand(this);
        addRecordOfPlay();
        game.getPile(DeckName.DISCARD_PILE).putOnTop(this);
        game.log(2, "[" + defendingPlayer + "]"+ this + " was played");

        defendingPlayer.drawCard(game.drawCard(), false);

        return true;
    }
}
