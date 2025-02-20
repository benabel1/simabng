package org.example.game.history;

import org.example.game.GamePlayer;
import org.example.game.deck.DeckAble;

import java.util.ArrayList;
import java.util.List;

public class GamePhaseDraw extends GamePhase {
    protected List<DeckAble> testedCards;
    protected List<DeckAble> drawnCards;
    public GamePhaseDraw(GameTurn gameTurn, GamePlayer player) {
        super(gameTurn.getRound(), gameTurn, player);
        drawnCards = new ArrayList<>();
        testedCards = new ArrayList<>();
    }

    public void prefillSteps() {

        fillAllTests();
    }

    private void fillAllTests() {
        List<DeckAble> tested = player.getAllTesting();
    }

    @Override
    public String toString() {
        return "GamePhaseDraw{" +
                "testedCards=" + testedCards +
                ", drawnCards=" + drawnCards +
                ", player=" + player +
                '}';
    }

    public void addDrawnCards(List<DeckAble> drawn) {
        for (DeckAble card: drawn) {
            if (card != null) {
                drawnCards.add(card);
            }
        }
    }
}
