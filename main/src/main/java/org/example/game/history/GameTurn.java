package org.example.game.history;

import org.example.game.Game;
import org.example.game.GameConstatns;
import org.example.game.GamePlayer;
import org.example.game.cards.GameCard;

import java.util.HashMap;

public class GameTurn {
    private GameRound round;
    GamePhase drawPhase;
    GamePhase playPhase;
    GamePhase excessPhase;
    private final GamePlayer player;
    private GamePhase currentPhase;
    int bangCount;
    int characterAbilityCount;
    public static HashMap<Integer,GameTurn> turnHistory = new HashMap<>();
    private Integer turnCount;

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

    public void increaseLimit(Class<? extends GameCard> aClass) {
        if (matchBangCategory(aClass)) {
            bangCount++;
        }
    }

    private boolean matchBangCategory(Class<? extends GameCard> aClass) {
        for (Class<? extends GameCard> a : GameConstatns.bangCategoryCards) {
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
}
