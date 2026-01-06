package org.example.game;

import org.example.game.cards.GameCard;
import org.example.game.cards.blue.basic.CardDynamit;
import org.example.game.cards.blue.basic.CardJail;
import org.example.game.cards.blue.hiredguns.CardMedicKit;
import org.example.game.cards.blue.valley.CardGhost;
import org.example.game.cards.blue.valley.CardRattlesnake;
import org.example.game.cards.brown.basic.CardBang;
import org.example.game.cards.brown.train.CardTrainRobbery;
import org.example.game.cards.brown.valley.CardFanning;
import org.example.game.cards.railcars.CardGhostCar;

import java.util.Arrays;
import java.util.List;

public class GameConstatns {
    public final static List<Class> keepingAliveCards = Arrays.asList(
            CardGhost.class,
            CardGhostCar.class
    );
    public static List<Class> bangCategoryCards = Arrays.asList(
            CardBang.class,
            CardFanning.class,
            CardTrainRobbery.class
    );

    public static List<Class> testingCards = Arrays.asList(
            CardDynamit.class,
            CardJail.class,
            CardRattlesnake.class,
            CardMedicKit.class
    );
}
