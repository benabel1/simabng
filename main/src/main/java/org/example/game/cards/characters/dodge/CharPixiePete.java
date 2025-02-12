package org.example.game.cards.characters.dodge;

import org.example.game.cards.characters.GameCharacter;

public class CharPixiePete extends GameCharacter {

    public CharPixiePete() {
        this.cardName = "PixiePete";

        this.maxHp = 3;
        this.startHp = 3;

        drawInTurnCards = 3;
    }
}
