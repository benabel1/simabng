package org.example.game.cards.characters.dangerous;

import org.example.game.cards.characters.GameCharacter;

public class CharMsAbigail extends GameCharacter {

    public CharMsAbigail() {
        this.cardName = "MsAbigail";

        this.isPassiveAbility = true;
        this.isAbilityOutTurnOfYour = true;
        this.isAbilityPhase01 = false;
        this.isAbilityPhase02 = false;
        this.isAbilityPhase03 = false;
    }
}
