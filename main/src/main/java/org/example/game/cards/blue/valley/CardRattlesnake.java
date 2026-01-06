package org.example.game.cards.blue.valley;

import org.example.game.cards.*;
import org.example.game.cards.blue.BlueBorderCard;

public class CardRattlesnake extends BlueBorderCard implements IsRevealAble {

    public CardRattlesnake(Suit s, PokerValue p) {
        super(s, p);
        this.cardName = "DYNAMITE";

        this.allowedTarget = DistanceAllowedTarget.ALL;
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
        return false;
    }
}
