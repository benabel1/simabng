package org.example.game.cards.characters.dodge;

import org.example.game.GamePlayer;
import org.example.game.cards.characters.GameCharacter;

public class CharSeanMallory extends GameCharacter {

    public CharSeanMallory() {
        this.cardName = "SeanMallory";

        this.maxHp = 3;
        this.startHp = 3;

        isPassiveAbility = true;
    }

    @Override
    public int getHandLimitSize(GamePlayer player) {
        return 10;
    }
}
