package org.example.game.cards.brown.hiredguns;

import org.example.game.Game;
import org.example.game.GamePlayer;
import org.example.game.cards.GameCard;
import org.example.game.cards.IAvoidable;
import org.example.game.cards.PokerValue;
import org.example.game.cards.Suit;
import org.example.game.cards.brown.BrownBorderCard;
import org.example.game.deck.DeckAble;
import org.example.game.deck.DeckName;
import org.example.game.options.OptionOption;
import org.example.game.options.scaner.OptionScanner;

public class CardMysticDec extends BrownBorderCard implements IAvoidable {
    public CardMysticDec(Suit suit, PokerValue pokerValue) {
        super(suit, pokerValue);
        this.cardName = "MYSTIC DEN";
    }

    @Override
    public boolean canBeUsed(Game game) {
        return false;
    }

    @Override
    public boolean processAvoidAction(Game game, GamePlayer defendingPlayer, GameCard cardBang) {
        defendingPlayer.removeFromHand(this);
        addRecordOfPlay();
        game.getPile(DeckName.DISCARD_PILE).putOnTop(this);
        game.log(2, "[" + defendingPlayer + "]"+ this + " was played");

        int option = OptionScanner.scanInt("Choose 0 - none, 1 - you, 2 - attacker, 3 for both(starting you)", 0, 3,0);

        if (option == 0) {
            return true;
        }

        if (option == 1 || option == 3) {
            DeckAble myMysteryCard = game.drawCard();

            if (myMysteryCard != null) {
                game.getPile(DeckName.DISCARD_PILE).putOnTop(myMysteryCard);
            }
        }

        if (option == 2 || option == 3) {
            DeckAble hisMysteryCard = game.drawCard();

            if (hisMysteryCard != null) {
                game.getPile(DeckName.DISCARD_PILE).putOnTop(hisMysteryCard);
            }
        }

        return true;
    }
}
