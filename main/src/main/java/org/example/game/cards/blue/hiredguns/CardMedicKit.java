package org.example.game.cards.blue.hiredguns;

import org.example.game.cards.GameCard;
import org.example.game.cards.IsRevealAble;
import org.example.game.cards.PokerValue;
import org.example.game.cards.Suit;
import org.example.game.cards.blue.BlueBorderCard;

public class CardMedicKit extends BlueBorderCard implements IsRevealAble {

    public CardMedicKit(Suit s, PokerValue p) {
        super(s, p);
        this.cardName = "CardMedicKit";
    }

    @Override
    public int getPriority() {
        return 0;
    }

    @Override
    public String getPriorityType() {
        return getCardName();
    }

    @Override
    public boolean matchSuitAndPoker(GameCard deckAble) {

        return deckAble.getSuit() == Suit.HEARTHS;
    }
}
