package org.example.game.cards;

public enum Suit {
    HEARTHS("♥"),
    DIAMONDS("♦"),
    CLUBS("♣"),
    SPADE("♠");

    private String uudString;

    private Suit(String uudCode) {
        this.uudString = uudCode;
    }

    @Override
    public String toString() {
        return getUudString();
    }

    public String getUudString() {
        return uudString;
    }
}
