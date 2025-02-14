package org.example.game;

import org.example.game.cards.blue.valley.CardGhost;
import org.example.game.cards.railcars.CardGhostCar;

import java.util.Arrays;
import java.util.List;

public class Consta {
    public final static List<Class> survive = Arrays.asList(
            CardGhost.class,
            CardGhostCar.class
    );
}
