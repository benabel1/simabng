package org.example.game.options;

import org.example.game.GamePlayer;
import org.example.game.cards.characters.GameCharacter;
import org.example.game.cards.characters.dodge.CharChuckWengam;

public class CharacterOption extends OptionOption {


    private final GamePlayer sourcePlayer;
    private final GameCharacter charrrr;

    public CharacterOption(GamePlayer gamePlayer, GameCharacter sourceCharacter) {
        super();
        this.sourcePlayer = gamePlayer;
        this.charrrr = sourceCharacter;
    }
}
