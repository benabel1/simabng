package org.example.game.history.sequence;

import org.example.game.Game;
import org.example.game.GamePlayer;
import org.example.game.cards.CARD_ATTRIBUTE;
import org.example.game.cards.GameCard;
import org.example.game.cards.ZONE;
import org.example.game.deck.DeckAble;
import org.example.game.deck.DeckName;
import org.example.game.history.steps.GameStep;
import org.example.game.options.scaner.OptionScanner;

import java.util.ArrayList;
import java.util.List;

public class GamePhase {
    protected GamePlayer player;
    protected GameRound round;
    protected GameTurn turn;
    protected List<GameStep> steps;
    protected List<DeckAble> playedCards;

    public GamePhase(GameRound round, GameTurn gameTurn, GamePlayer player) {
        this.player = player;

        this.round = round;
        this.turn = gameTurn;

        this.steps = new ArrayList<>();
        this.playedCards = new ArrayList<>();
    }

    public void reDiscard(Game game, GamePlayer player) {
        if (player.getAllCardsCount(CARD_ATTRIBUTE.CAUSE_FOR_ANY, ZONE.HAND) > player.getCurrentHp()) {

            List<DeckAble> willBeDiscarded = new ArrayList<>();

            do {
                List<DeckAble> hand = player.getAllCards(CARD_ATTRIBUTE.CAUSE_FOR_ANY, ZONE.HAND);

                DeckAble discardChoice = OptionScanner
                        .scanForObjectSpecificList("Which card to discard at end of phase",
                        hand,
                        0, hand.size(), null);

                if (discardChoice != null) {
                    willBeDiscarded.add(discardChoice);
                    game.getPile(DeckName.DISCARD_PILE).putOnTop(discardChoice);
                    player.removeFromHand(discardChoice);
                    game.log(2, discardChoice + " is excess card and is discarded");
                }

            } while (player.getAllCardsCount(CARD_ATTRIBUTE.CAUSE_FOR_ANY, ZONE.HAND) > player.getCurrentHp());

            game.log(2, willBeDiscarded + " were all cards discarded");
        }
    }

    public void logPlayingCard(GameCard gameCard) {
        if (gameCard != null) {
            playedCards.add(gameCard);
        }
    }

    public void logStep(GameStep step) {
        if (step != null) {
            steps.add(step);
        }
    }

    public void printSteps() {
        for (GameStep step: steps) {
            System.out.println(step);
        }
    }
}
