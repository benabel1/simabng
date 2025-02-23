package org.example.game.history.steps;

import org.example.game.Game;
import org.example.game.GamePlayer;
import org.example.game.cards.GameCard;

public class GameStepDiscardWeapon extends GameStep{
    private final GamePlayer player;
    private final GameCard newGun;
    private final GameCard oldGun;

    public GameStepDiscardWeapon(Game game, GamePlayer player, GameCard newGun, GameCard oldGun) {
        super(game);
        this.player = player;
        this.newGun = newGun;
        this.oldGun = oldGun;
    }
}
