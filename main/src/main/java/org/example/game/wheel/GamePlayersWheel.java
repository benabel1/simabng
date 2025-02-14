package org.example.game.wheel;

import org.example.game.Game;
import org.example.game.GamePlayer;
import org.example.game.cards.Roles;

import java.util.ArrayList;
import java.util.List;

public class GamePlayersWheel {
    private final Game gameWheel;
    private List<GamePlayer> playersInWheel;
    private GamePlayer startPlayer;
    private GamePlayer currPlayer;
    private boolean clockwiseTurning;

    PositionPlayerStruct structPointingOnSheriff;

    public GamePlayersWheel(Game game) {
        this.gameWheel = game;
        playersInWheel = new ArrayList<>();
        resetClockWiseTurning();
    }

    public void resetClockWiseTurning() {
        this.clockwiseTurning = true;
    }

    public void addPlayerAndSetStartingOne(GamePlayer player, Roles role) {
        PositionPlayerStruct previous = null;
        PositionPlayerStruct first = null;

        if (player != null && !playersInWheel.contains(player)) {
            playersInWheel.add(player);

            if (role == Roles.SHERIFF && startPlayer == null) {
                startPlayer = player;
            }
        }
    }

    public List<GamePlayer> getPlayersInOrderFromNowSkippingEliminated(GamePlayer currentPlayer, boolean b) {
        List<GamePlayer> playersInOrderFromCurrToOthers = new ArrayList<>();

        if (clockwiseTurning) {

        } else {

        }

        return playersInOrderFromCurrToOthers;
    }

    public void makeInitialStructure(GamePlayer sheriffPlayer) {
        PositionPlayerStruct first = null;
        PositionPlayerStruct curr = null;
        PositionPlayerStruct previousOrLastOne = null;

        if (playersInWheel == null || playersInWheel.isEmpty()) {
            System.err.println("Cannot create WHEEL for players");
        } else {
            for (int i = 0; i < playersInWheel.size(); i++) {
                GamePlayer p = playersInWheel.get(i);
                curr = new PositionPlayerStruct(this, p);

                if (first == null) {
                    first = curr;
                    //reassigned latter to proper position
                    structPointingOnSheriff = first;
                }

                if (previousOrLastOne != null) {
                    previousOrLastOne.leftSide = curr;
                    curr.rightSide = previousOrLastOne;
                }
                //move
                previousOrLastOne = curr;

                if (p.getCurrentRole() == Roles.SHERIFF) {
                    structPointingOnSheriff = curr;
                }
            }

            //pair first with last one
            if (first != null && previousOrLastOne != null && first != previousOrLastOne) {
                previousOrLastOne.leftSide = first;
                first.rightSide = previousOrLastOne;
            }
        }
    }
}
