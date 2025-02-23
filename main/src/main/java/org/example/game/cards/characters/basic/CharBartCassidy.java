package org.example.game.cards.characters.basic;

import org.example.game.cards.IsGameRecordAble;
import org.example.game.cards.characters.GameCharacter;

public class CharBartCassidy extends GameCharacter implements IsGameRecordAble {

    public CharBartCassidy(){
        this.cardName = "BartCassidy";
        isPassiveAbility = true;
    }

    @Override
    public String getUniqueNameForRecording() {
        return "BartCassidy";
    }
}
