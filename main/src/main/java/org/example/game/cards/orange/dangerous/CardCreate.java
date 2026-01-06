package org.example.game.cards.orange.dangerous;

import org.example.game.Game;
import org.example.game.GamePlayer;
import org.example.game.cards.GameCard;
import org.example.game.cards.IAvoidable;
import org.example.game.cards.PokerValue;
import org.example.game.cards.Suit;
import org.example.game.cards.orange.OrangeBorderCard;

public class CardCreate extends OrangeBorderCard implements IAvoidable {
    public CardCreate(Suit s, PokerValue p) {
        super(s, p);
        this.cardName = "CREATE";

        this.costOfActivation = 2;
    }

    @Override
    public boolean canBeUsed(Game game) {
        return this.loadCount >= this.costOfActivation;
    }

    @Override
    public boolean processAvoidAction(Game game, GamePlayer defendingPlayer, GameCard cardBang) {
        return false;
    }


}
