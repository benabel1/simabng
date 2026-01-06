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

    public static int matchValue(PokerValue pv) {
        if (pv == null) {
            return -1;
        } else {
            switch (pv) {
                case _02: return 2;
                case _03: return 3;
                case _04: return 4;
                case _05: return 5;
                case _06: return 6;
                case _07: return 7;
                case _08: return 8;
                case _09: return 9;
                case _10: return 10;
                case __J: return 11;
                case __Q: return 12;
                case __K: return 13;
                case __A: return 14;
            }
        }
        return -1;
    }
}
