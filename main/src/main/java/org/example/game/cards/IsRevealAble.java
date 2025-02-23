package org.example.game.cards;

public interface IsRevealAble {
    public default int getPriority() {
        return 100;
    }

    public default int TopPriority(IsRevealAble a) {
        switch (a.getPriorityType()) {
            case "DYNAMITE": return 0;
            case "JAIL": return 1;
            case "RATTLESNAKE": return 2;
            default: return this.getPriority();
        }
    }

    String getPriorityType();

    boolean matchSuitAndPoker(GameCard deckAble);
}
