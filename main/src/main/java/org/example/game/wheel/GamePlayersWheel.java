package org.example.game.wheel;


import org.example.game.Game;
import org.example.game.GamePlayer;
import org.example.game.cards.Roles;
import org.example.game.options.PairPlayerDistance;

import java.util.ArrayList;
import java.util.List;

public class GamePlayersWheel {
    private final Game gameWheel;
    private List<GamePlayer> playersInWheel;
    private GamePlayer startPlayer;
    private GamePlayer currPlayer;
    private boolean clockwiseTurning;

    PositionPlayerStruct structPointingOnSheriff;
    PositionPlayerStruct moving;

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
                    moving = structPointingOnSheriff;
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

    public GamePlayer whoGoesNext(boolean mustBeAlive) {
        PositionPlayerStruct ff = moving;
        int maxTurn = 10;

        if (mustBeAlive) {
            do{
                if(clockwiseTurning) {
                    ff = ff.leftSide;
                } else {
                    ff = ff.rightSide;
                }
                maxTurn--;
            } while (!ff.chair.isAlive(gameWheel) && maxTurn > 0);

            return ff.chair;

        } else {
            return moving.leftSide.chair;
        }
    }

    public void moveToNext() {
        if (clockwiseTurning) {
            moving = moving.leftSide;
        } else {
            moving = moving.rightSide;

        }

        currPlayer = moving.chair;
    }

    public GamePlayer getActive() {
        return currPlayer;
    }

    public List<PairPlayerDistance> calculateDistancesFromDeadCount(GamePlayer sourcePlayer, boolean deadCounts) {
        List<PairPlayerDistance> distanceResult = new ArrayList<>();

        for (GamePlayer playerAtDistance : playersInWheel) {
            if (sourcePlayer == playerAtDistance) {
                distanceResult.add(new PairPlayerDistance(sourcePlayer, 0));
            } else {
                int distanceLeft = calDistToLeft(sourcePlayer, playerAtDistance, false);
                int distanceRight = calDistToRight(sourcePlayer, playerAtDistance, false);

                int mixDistance = Math.min(distanceLeft, distanceRight);
                distanceResult.add(new PairPlayerDistance(playerAtDistance, mixDistance));
            }
        }

        return distanceResult;
    }

    private int calDistToLeft(GamePlayer from, GamePlayer to, boolean deathCounts) {
        PositionPlayerStruct counting =  moving;
        int distance = 0;

        if (from == null || to == null) {
            return -1;
        }

        if (from == to) {
            return 0;
        }


        while(counting.chair != from) {
            counting = counting.leftSide;
        }

        while(counting.chair != to) {
            if (deathCounts) {
                counting = counting.leftSide;
                distance++;
            } else {
                counting = counting.leftSide;
                if (counting.chair.isAlive(gameWheel)) {
                    distance++;
                }
            }
        };


        return distance;
    }

    private int calDistToRight(GamePlayer from, GamePlayer to, boolean deathCounts) {
        PositionPlayerStruct counting =  moving;
        int distance = 0;

        if (from == null || to == null) {
            return -1;
        }

        if (from == to) {
            return 0;
        }

        while(counting.chair != from) {
            counting = counting.rightSide;
        }

        while(counting.chair != to) {
            if (deathCounts) {
                counting = counting.rightSide;
                distance++;
            } else {
                counting = counting.rightSide;
                if (counting.chair.isAlive(gameWheel)) {
                    distance++;
                }
            }
        }

        return distance;
    }
}
