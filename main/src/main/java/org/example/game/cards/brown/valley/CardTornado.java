package org.example.game.cards.brown.valley;

import org.example.game.Game;
import org.example.game.GamePlayer;
import org.example.game.cards.*;
import org.example.game.cards.brown.BrownBorderCard;
import org.example.game.deck.DeckAble;
import org.example.game.options.CardOption;
import org.example.game.options.scaner.OptionScanner;

import java.util.ArrayList;
import java.util.List;

import static org.example.game.cards.DistanceAllowedTarget.ALL;

public class CardTornado extends BrownBorderCard {
    public CardTornado(Suit suit, PokerValue pokerValue) {
        super(suit, pokerValue);
        this.cardName = "Tornado";

        allowedTarget = ALL;
    }

    @Override
    public void playCardFromHand(Game game, CardOption option, GamePlayer sourcePlayer) {
        super.playCardFromHand(game, option, sourcePlayer);

        List<DeckAble> tornadoCards = new ArrayList<>();
        List<GamePlayer> tornadoPlayers = game.getPlayersFromACurrentToOthersInOrderSkippedEliminated(
                sourcePlayer,
                true);
        tornadoPlayers.add(0, sourcePlayer);

        if (tornadoPlayers.size() < 2) {
            System.err.println(this + " Not enough players to switch");
            return;
        }

        for (GamePlayer tornado: tornadoPlayers) {
            System.out.println("Player " + tornado + " select one card to move it to player on left");

            DeckAble tornadoCard = OptionScanner.scanForObjectSpecificList("Card to move ",
                    tornado.getAllCards(CARD_ATTRIBUTE.CAUSE_FOR_ANY, ZONE.HAND),
                    0,
                    tornado.getAllCards(CARD_ATTRIBUTE.CAUSE_FOR_ANY, ZONE.HAND).size(),
                    null);

            tornadoCards.add(tornadoCard);
        }

        for (int i = 0; i < tornadoPlayers.size(); i++) {
            GamePlayer player = tornadoPlayers.get(i);
            if (i == 0 ) {
                player.drawCard(tornadoCards.get(tornadoPlayers.size() -1), false);
            } else {
                //tornado card came from previous player(s)
                player.drawCard(tornadoCards.get(i - 1), false);
            }
        }

        sourcePlayer.drawCard(game.drawCard(), false);
    }
}
