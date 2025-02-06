package org.example.game.cards.characters.basic;

import org.example.game.cards.characters.GameCharacter;

public class CharLuckyDuke extends GameCharacter {

    public CharLuckyDuke(){

        this.cardName = "LuckyDuke";
    }

    @Override
    public String getUniqueNameForRecording() {
        return "LuckyDuke";
    }
}
