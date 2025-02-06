package org.example.game.cards.basic.characters;

import org.example.game.cards.GameRecordAble;
import org.example.game.cards.GameCharacter;

public class CharBartCassidy extends GameCharacter implements GameRecordAble {

    public CharBartCassidy(){
        this.cardName = "BartCassidy";
    }

    @Override
    public String getUniqueNameForRecording() {
        return "BartCassidy";
    }
}
