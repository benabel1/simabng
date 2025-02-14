package org.example.game.options;

import org.example.game.GamePlayer;
import org.example.game.cards.characters.GameCharacter;
import org.example.game.options.OptionOption;

public class CharacterOption extends OptionOption {
    private final GameCharacter characterSource;
    private final GamePlayer sourcePlayer;

    public CharacterOption(GameCharacter gameCharacter, GamePlayer gamePlayer) {
        super();
        this.characterSource = gameCharacter;
        this.sourcePlayer = gamePlayer;
    }

    @Override
    public String toString() {
        return characterSource.getCardName() + " - " + sourcePlayer;
    }
}
