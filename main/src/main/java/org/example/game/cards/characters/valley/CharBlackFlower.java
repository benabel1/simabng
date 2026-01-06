package org.example.game.cards.characters.valley;

import org.example.game.cards.characters.GameCharacter;

public class CharBlackFlower extends GameCharacter {

    public CharBlackFlower() {
        this.cardName = "BlackFlower";

        this.textForActivationAbilityText = "Discard card of ♣ to shot extra SHOT";
    }

    @Override
    public boolean isIsaActiveAbility() {
        return true;
    }
}
