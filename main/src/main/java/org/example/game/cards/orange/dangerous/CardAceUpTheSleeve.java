package org.example.game.cards.orange.dangerous;

import org.example.game.Game;
import org.example.game.GamePlayer;
import org.example.game.cards.PokerValue;
import org.example.game.cards.Suit;
import org.example.game.cards.orange.OrangeBorderCard;
import org.example.game.deck.DeckAble;
import org.example.game.options.CardOption;
import org.example.game.options.OptionOption;

public class CardAceUpTheSleeve extends OrangeBorderCard {
    public CardAceUpTheSleeve(Suit s, PokerValue p) {
        super(s, p);
        //AceUpTheSleeve
        this.cardName = "ACE UP THE SLEEVE";

        this.costOfActivation = 2;
    }

    @Override
    public void playCardFromHand(Game game, CardOption option, GamePlayer sourcePlayer) {
    }

    @Override
    public void useCardInGame(Game game, OptionOption option, GamePlayer ownerPlayer) {
        super.useCardInGame(game, option, ownerPlayer);

        if (canBeUsedInGame(game)) {
            DeckAble drawnCard = game.drawCard();
            ownerPlayer.drawCard(drawnCard,false);
        }
    }
}
