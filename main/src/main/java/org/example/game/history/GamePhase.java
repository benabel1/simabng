package org.example.game.history;

import org.example.game.Game;
import org.example.game.GamePlayer;
import org.example.game.cards.CARD_ATTRIBUTE;
import org.example.game.cards.ZONE;
import org.example.game.deck.DeckAble;
import org.example.game.deck.DeckName;
import org.example.game.options.scaner.OptionScanner;

import java.util.ArrayList;
import java.util.List;

public class GamePhase {
    protected GamePlayer player;
    protected GameTurn turn;
    protected List<GameStep> steps;

    public GamePhase(GameTurn gameTurn, GamePlayer player) {
        this.player = player;
        this.turn = gameTurn;

        steps = new ArrayList<>();
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
}
