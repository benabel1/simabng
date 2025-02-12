package org.example.game.cards.characters.basic;

import org.example.game.cards.GameRecordAble;
import org.example.game.cards.characters.GameCharacter;

public class CharBartCassidy extends GameCharacter implements GameRecordAble {

    public CharBartCassidy(){
        this.cardName = "BartCassidy";
        isPassiveAbility = true;
    }

    @Override
    public String getUniqueNameForRecording() {
        return "BartCassidy";
    }
}
