package org.example.game.cards.orange;

import org.example.game.Game;
import org.example.game.GamePlayer;
import org.example.game.cards.GameCard;
import org.example.game.cards.IsWeapon;
import org.example.game.cards.PokerValue;
import org.example.game.cards.Suit;
import org.example.game.deck.DeckName;
import org.example.game.options.CardOption;
import org.example.game.options.OptionOption;

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
    public void playCardFromHand(Game game, CardOption option, GamePlayer sourcePlayer) {
        super.playCardFromHand(game, option, sourcePlayer);
        this.loadCount = 3;
        addRecordOfPlay();
        sourcePlayer.placeInFrontCard(this);
        sourcePlayer.removeFromHand(this);

        if (this instanceof IsWeapon) {
            sourcePlayer.replaceOldWeapon(game, this);
        }
    }

    @Override
    public void useCardInGame(Game game, OptionOption option, GamePlayer ownerPlayer) {
        super.useCardInGame(game, option, ownerPlayer);

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

    public void takeLoad(int loadTaken) {
        loadCount = loadCount - loadTaken;
        loadCount = Math.max(loadCount, 0);
    }


}
