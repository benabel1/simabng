package org.example.game.options;

import org.example.game.Game;
import org.example.game.GamePlayer;
import org.example.game.cards.CARD_ATTRIBUTE;
import org.example.game.cards.GameCard;
import org.example.game.cards.ZONE;
import org.example.game.deck.DeckAble;
import org.example.game.options.scaner.OptionScanner;

import java.util.ArrayList;
import java.util.List;

public class CardOptionTargetOtherPlayerAndCardInFrontOrHandRange extends CardOption {
    private GamePlayer target;
    private ZONE zone;
    private GameCard stealCard;

    public CardOptionTargetOtherPlayerAndCardInFrontOrHandRange(GameCard card, GamePlayer player, GamePlayer target, ZONE zone, GameCard stealCard) {
        super(card, player);
        this.target = target;
        this.zone = zone;
        this.stealCard = card;
    }

    @Override
    public void collectData(Game game) {
        List<DeckAble> cards = new ArrayList<>();
        if (target == null) {
            List<GamePlayer> list = game.getPlayersFromACurrentToOthersInOrderSkippedEliminated(sourcePlayer, cardSource.canTargetEliminated());

            target = OptionScanner.scanForObjectSpecificList("Choose player to",
                    list,
                    0, list.size(), null);

            if (target != null) {
                System.out.println("Target player " + target +
                        " Hand:" + target.getAllCards(CARD_ATTRIBUTE.CAUSE_FOR_ANY, ZONE.HAND).size() +
                        ". Front: " + target.getAllCards(CARD_ATTRIBUTE.CAUSE_FOR_ANY, ZONE.HAND_FRONT));
            } else {
                System.out.println("None was selected");
                return;
            }
        }

        if (zone == null) {
            int choise = OptionScanner.scanInt("0: HAND, 1:FRONT", 0,1, -1);

            if (choise != -1) {
                zone = (choise == 1)? ZONE.FRONT: ZONE.HAND;

            } else {
                System.out.println("ZONE was not propretly selected");
                return;
            }
        }

        if (stealCard == null) {
            cards = target.getAllCards(CARD_ATTRIBUTE.CAUSE_FOR_ANY, zone);
            if (zone == ZONE.HAND) {
                if (cards.isEmpty()) {
                    stealCard = null;
                    return;
                } else {
                    stealCard = (GameCard) cards.get((int) (Math.random()* cards.size()));
                }
            } else {
                if (cards.isEmpty()) {
                    stealCard = null;
                    return;
                } else {
                    stealCard = (GameCard) OptionScanner.scanForObjectSpecificList("Pick up one card",
                            cards,
                            0, cards.size(), null);
                }
            }
        }
    }

    @Override
    public boolean canBeResolved(Game game) {
        return super.canBeResolved(game) && target != null && zone != null && stealCard != null;
    }

    public GameCard getStolenCards() {
         return stealCard;
    }

    public ZONE getZone() {
        return zone;
    }
}
