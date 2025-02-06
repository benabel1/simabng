package org.example.game.cards.characters;

import org.example.game.GamePlayer;
import org.example.game.options.OptionOption;

public class CharacterOption extends OptionOption {
    private final GameCharacter characterSource;
    private final GamePlayer sourcePlayer;

    public CharacterOption(GameCharacter gameCharacter, GamePlayer gamePlayer) {
        super();
        this.characterSource = gameCharacter;
        this.sourcePlayer = gamePlayer;
    }
}
