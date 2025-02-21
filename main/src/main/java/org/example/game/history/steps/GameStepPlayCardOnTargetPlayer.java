package org.example.game.history.steps;

import org.example.game.Game;
import org.example.game.GamePlayer;
import org.example.game.cards.GameCard;

public class GameStepPlayCardOnTargetPlayer extends  GameStep {

    protected final GameCard card;
    protected final GamePlayer player;
    protected final GamePlayer target;

    public GameStepPlayCardOnTargetPlayer(Game game, GameCard card, GamePlayer played, GamePlayer target) {
        super(game);
        this.card = card;
        this.player = played;
        this.target = target;
    }

    public GameCard getCard() {
        return card;
    }

    public GamePlayer getPlayer() {
        return player;
    }

    public GamePlayer getTarget() {
        return target;
    }

    @Override
    public String toString() {
        return "GameStepPlayCardOnTargetPlayer{" +
                "card=" + card +
                ", player=" + player +
                ", target=" + target +
                '}';
    }
}
