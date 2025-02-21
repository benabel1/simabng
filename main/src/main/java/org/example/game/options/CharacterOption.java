package org.example.game.options;

import org.example.game.GamePlayer;
import org.example.game.cards.characters.GameCharacter;

public class CharacterOption extends OptionOption {
    private final GameCharacter characterSource;

    public CharacterOption(GameCharacter gameCharacter, GamePlayer player) {
        super(player);
        this.characterSource = gameCharacter;
    }

    @Override
    public String toString() {
        return characterSource.getCardName() + " - " + sourcePlayer;
    }
}
