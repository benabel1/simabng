package org.example.game.cards.brown;

import org.example.game.Game;
import org.example.game.GamePlayer;
import org.example.game.cards.PokerValue;
import org.example.game.cards.Suit;
import org.example.game.cards.characters.GameCharacter;
import org.example.game.cards.orange.OrangeBorderCard;
import org.example.game.deck.DeckAble;
import org.example.game.deck.DeckName;
import org.example.game.options.scaner.OptionScanner;

import java.util.List;

public class BrownBorderCardBoostable extends BrownBorderCard {

    protected int boostCost;
    public BrownBorderCardBoostable(Suit s, PokerValue p) {
        super(s, p);
        this.boostCost = 4;
    }

    public void processBoosting(Game game, GamePlayer defendingPlayer) {
        if (defendingPlayer.getLoadCount() > boostCost) {

            boolean boostYes = OptionScanner.scanForYesOrNoDefaultIsNo("Do you want to boost this?");

            if (boostYes) {
                int costColected = 0;
                while (costColected != boostCost) {
                    List<DeckAble> sourcesOfLoad = defendingPlayer.getCardsWithLoad();

                    DeckAble ll = OptionScanner.scanForObjectSpecificList("Choose LOAD to take from",
                            sourcesOfLoad,
                            0, sourcesOfLoad.size(),
                            null);

                    if (ll != null) {
                        costColected++;
                        if (ll instanceof GameCharacter) {
                            GameCharacter from = (GameCharacter) ll;
                            from.takeLoad(1);
                        }
                        if (ll instanceof OrangeBorderCard) {
                            OrangeBorderCard from = (OrangeBorderCard) ll;
                            from.takeLoad(1);
                            if (from.getLoadCount() == 0) {
                                defendingPlayer.removeFromFront(from);
                                game.getPile(DeckName.DISCARD_PILE).putOnTop(from);
                            }
                        }
                    }
                }

                System.out.println("Boosted");
                game.log(2, "[" + defendingPlayer + "]"+ this + " was played and boosted");
                defendingPlayer.drawCard(this, true);

            } else {
                System.out.println("No Boosted");
                game.log(2, "[" + defendingPlayer + "]"+ this + " was played");
                game.getPile(DeckName.DISCARD_PILE).putOnTop(this);
            }

        } else {
            game.getPile(DeckName.DISCARD_PILE).putOnTop(this);
            game.log(2, "[" + defendingPlayer + "]"+ this + " was played");
        }
    }
}
