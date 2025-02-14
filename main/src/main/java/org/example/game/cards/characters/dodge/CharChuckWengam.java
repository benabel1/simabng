package org.example.game.cards.characters.dodge;

import org.example.game.GamePlayer;
import org.example.game.cards.DeckAble;
import org.example.game.cards.characters.GameCharacter;
import org.example.game.options.CharacterOption;
import org.example.game.options.OptionOption;

public class CharChuckWengam extends GameCharacter {

    public CharChuckWengam() {
        this.cardName = "ChuckWengam";
    }

    @Override
    public OptionOption generateOption(DeckAble card, GamePlayer gamePlayer) {

        if (gamePlayer.getCurrentHp() > 1) {
            return new CharacterOption(gamePlayer, this);
        } else {
            return null;
        }
    }
}
