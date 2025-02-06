package org.example.game.cards.characters.basic;


import org.example.game.cards.characters.GameCharacter;

public class CharJourdonnias extends GameCharacter {

    public CharJourdonnias(){
        this.cardName = "Jourdonnais";
    }

    @Override
    public String getUniqueNameForRecording() {
        return "Jourdonnais";
    }
}
