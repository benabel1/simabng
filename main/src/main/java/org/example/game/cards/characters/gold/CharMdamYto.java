package org.example.game.cards.characters.gold;

import org.example.game.Game;
import org.example.game.GamePlayer;
import org.example.game.cards.GameCard;
import org.example.game.cards.brown.basic.CardBeer;
import org.example.game.cards.characters.GameCharacter;

public class CharMdamYto extends GameCharacter {

    public CharMdamYto() {
        this.cardName = "MadamYto";
    }

    @Override
    public void notifyP(GameCard card, GamePlayer sourcePlayer, Game game) {
      if (card instanceof CardBeer) {
          sourcePlayer.drawCard(game.drawCard(), false);
      }

    }
}
