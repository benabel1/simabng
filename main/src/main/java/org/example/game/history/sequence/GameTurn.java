package org.example.game.history.sequence;

import org.example.game.Game;
import org.example.game.GameConstatns;
import org.example.game.GamePlayer;
import org.example.game.cards.GameCard;
import org.example.game.history.steps.GameStep;
import org.example.game.history.steps.GameStepDiscardWeapon;

import java.util.HashMap;

public class GameTurn {
    private final GameRound round;
    GamePhase drawPhase;
    GamePhase playPhase;
    GamePhase excessPhase;
    private final GamePlayer player;
    private GamePhase currentPhase;
    int bangCount;
    int characterAbilityCount;
    public static HashMap<Integer,GameTurn> turnHistory = new HashMap<>();
    private final Integer turnCount;

    public GameTurn(GamePlayer player, GameRound round) {
        this.player = player;
        this.round = round;
        drawPhase = new GamePhaseDraw(this, player);
        currentPhase = drawPhase;

        turnCount = turnHistory.size();
        turnHistory.put(turnCount, this);
    }

    public GameRound getRound() {
        return round;
    }

    public int getQuantity(GameCard cardBang) {
        return bangCount;
    }

    public void goToDiscard(Game game, GamePlayer player) {
        if (excessPhase == null) {
            System.out.println("Excess cards");
            excessPhase = new GamePhaseDiscard(this, player);
            game.log(1, excessPhase.toString());
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
            playPhase = new GamePhasePlay(round, this, player);
            currentPhase = playPhase;
        }
    }

    public void increaseAbility() {
        characterAbilityCount++;
    }

    public void increaseLimit(Class aClass) {
        if (matchBangCategory(aClass)) {
            bangCount++;
        }
    }

    private boolean matchBangCategory(Class aClass) {
        if (aClass == null ){
            return false;
        }
        for (Class a : GameConstatns.bangCategoryCards) {
            if (a == aClass) {
                return true;
            }
        }
        return false;
    }

    public int getBangsCount() {
        return bangCount;
    }

    @Override
    public String toString() {
        return "Turn["+ turnHistory.get(turnCount).turnCount + "]:[" + player + "]"+ currentPhase;
    }

    public int getTurnCount() {
        return turnCount;
    }

    public void addStepAndCard(GameStep step, GameCard gameCard) {
        getCurrPhase().logPlayingCard(gameCard);
        getCurrPhase().logStep(step);
    }

    public void addStep(GameStep step) {
        getCurrPhase().logStep(step);
    }
}
