package org.example.game.deck;

import org.example.game.Game;
import org.example.game.GamePlayer;
import org.example.game.history.GameTurn;
import org.example.game.options.OptionOption;

public abstract class DeckAble {
    protected String cardName;
    /**
     * Visibility of card for others and one previous owner
     */
    boolean cardWasShown;
    private GamePlayer previousOwner;
    protected GameTurn turnOfPlay;

    private long playedCount;
    private long handAppearence;
    private long playAppearence;
    private long handHolding;
    private long usageInPlayCount;
    private long stolenCount;
    private long discardCount;
    private long excessDiscardCount;

    public String getCardName() {
        return cardName;
    }

    public boolean canBePlayedFromHand(Game game) {
        return true;
    }

    public abstract boolean canBeUsedInGame(Game game);

    public OptionOption generateOption(DeckAble card, GamePlayer gamePlayer) {
        return null;
    }

    /**
     * Represent start recording hand values
     */
    public void startNewRecordForHand(boolean wasShown) {
        this.cardWasShown = wasShown;
        this.handAppearence++;
    }

    protected void addRecordOfPlay() {
        playedCount++;
    }

    protected void addRecordOfUsageInPlay() {
        usageInPlayCount++;
    }

    public void addRecordOfSteal() {
        stolenCount++;
    }

    public void addRecordOfDiscard() {
        discardCount++;
    }

    public void addRecordOfExcessDiscard() {
        excessDiscardCount++;
    }
    public void setPreviousOwnerKnown(GamePlayer previousOwner) {
        this.previousOwner = previousOwner;
    }

    public boolean wasShown() {
        return cardWasShown;
    }
}
