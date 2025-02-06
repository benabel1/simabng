package org.example.game.cards;

public enum PokerValue {
    _02,
    _03,
    _04,
    _05,
    _06,
    _07,
    _08,
    _09,
    _10,
    __J,
    __Q,
    __K,
    __A;

    public static boolean isRoyal(PokerValue p) {
        if (p == null) {
            return false;
        } else {
            switch (p) {
                case __A:
                case __K:
                case __Q:
                case __J:
                    return true;
                default: return false;
            }
        }

    }
}
