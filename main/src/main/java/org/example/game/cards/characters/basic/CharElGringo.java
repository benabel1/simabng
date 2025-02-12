package org.example.game.cards.characters.basic;

import org.example.game.cards.characters.GameCharacter;

public class CharElGringo extends GameCharacter {

    public CharElGringo(){
        this.cardName = "ElGringo";

        this.maxHp = 3;
        this.startHp = 3;

        this.isPassiveAbility = true;
    }
}
