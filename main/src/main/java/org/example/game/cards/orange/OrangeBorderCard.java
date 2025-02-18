package org.example.game.cards.orange;

import org.example.game.Game;
import org.example.game.GamePlayer;
import org.example.game.cards.GameCard;
import org.example.game.cards.PokerValue;
import org.example.game.cards.Suit;
import org.example.game.deck.DeckName;

import static org.example.game.cards.CardBorderColor.ORANGE;

public class OrangeBorderCard extends GameCard {
    protected int loadCount;
    protected int costOfActivation;
    public OrangeBorderCard(Suit s, PokerValue p) {
        super(s, p);
        //default setup values
        this.color = ORANGE;
        this.canPlayedOnSideOfTurn = true;
        this.canPlayedOutSideOfTurn = false;
        this.canUsedOnSideOfTurn = true;
        this.canUsedOutSideOfTurn = true;
    }

    @Override
    public void playCardFromHand(Game game, GamePlayer sourcePlayer) {
        super.playCardFromHand(game, sourcePlayer);
        this.loadCount = 3;
        addRecordOfPlay();
    }

    @Override
    public void useCardInGame(Game game, GamePlayer ownerPlayer) {
        super.useCardInGame(game, ownerPlayer);

        if (canBeUsedInGame(game)) {
            loadCount -= costOfActivation;
            addRecordOfUsageInPlay();
            if (loadCount <= 0) {
                game.getPile(DeckName.DISCARD_PILE).putOnTop(this);
            }
        }
    }

    @Override
    public boolean canBeUsedInGame(Game game) {
        return this.loadCount >= this.costOfActivation;
    }

    @Override
    public boolean canBePlayedFromHand(Game game, GamePlayer player) {
        return true;
    }

    @Override
    public String toString() {
        return "[" + suit + poker +"]" + cardName + "-[" + loadCount + "/4]";
    }

    public int getLoadCount() {
        return loadCount;
    }
}
