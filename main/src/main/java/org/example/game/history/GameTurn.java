package org.example.game.history;

import org.example.game.Game;
import org.example.game.cards.GameCard;
import org.example.game.GamePlayer;

public class GameTurn {

    GamePhase drawPhase;
    GamePhase playPhase;
    GamePhase excessPhase;
    private final GamePlayer player;
    private GamePhase currentPhase;
    int bangCount;

    public GameTurn(GamePlayer player) {
        this.player = player;
        drawPhase = new GamePhaseDraw(this, player);
        currentPhase = drawPhase;
    }

    public int getQuantity(GameCard cardBang) {
        return bangCount;
    }

    public void goToDiscard(Game game, GamePlayer player) {
        if (excessPhase == null) {
            System.out.println("Excess cards");
            excessPhase = new GamePhaseDiscard(this, player);
            currentPhase = excessPhase;

            excessPhase.reDiscard(game, player);

            game.nextPlayerOrTurn(player);
        }
    }

    public GamePhase getCurrPhase() {
        return currentPhase;
    }

    public void addPlayPhase(GamePlayer player) {
        if (playPhase == null) {
            playPhase = new GamePhasePlay(this, player);
            currentPhase = playPhase;
        }
    }
}
