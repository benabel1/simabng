package org.example.game.cards.characters.dangerous;

import org.example.game.cards.characters.GameCharacter;

public class CharMexicaliKid extends GameLoadCharacter {

    public CharMexicaliKid() {
        this.cardName = "MexicaliKid";

        this.isAbilityInTurnOfYour = true;
        this.isAbilityPhase02 = true;

        this.abilityLoadCost = 2;
    }


}
