package org.example.game.history.steps;

import org.example.game.Game;
import org.example.game.GamePlayer;
import org.example.game.cards.GameCard;
import org.example.game.cards.ZONE;

public class GameStepPlayCardOnTargetPlayerHanfFrontCArd extends GameStepPlayCardOnTargetPlayer {
    private final ZONE zone;
    private final GameCard targetCard;

    public GameStepPlayCardOnTargetPlayerHanfFrontCArd(Game game, GameCard card, GamePlayer played, GamePlayer target, ZONE zone, GameCard targetCard) {
        super(game, card, played, target);
        this.zone = zone;
        this.targetCard = targetCard;
    }

    @Override
    public String toString() {
        return "GameStep{" +
                "player=" + player +
                "target=" + target +
                ", zone=" + zone +
                ", targetCard=" + targetCard +
                '}';
    }
}
