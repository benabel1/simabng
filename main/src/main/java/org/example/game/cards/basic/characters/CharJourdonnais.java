package org.example.game.cards.basic.characters;

import org.example.game.cards.GameRecordAble;
import org.example.game.cards.GameCharacter;

public class CharJourdonnais extends GameCharacter implements GameRecordAble {

    public CharJourdonnais(){
        this.cardName = "Jourdonnais";
    }

    @Override
    public String getUniqueNameForRecording() {
        return "Jourdonnais";
    }
}
