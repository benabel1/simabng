package org.example.game.wheel;

import org.example.game.GamePlayer;

public class PositionPlayerStruct {
    GamePlayersWheel wheel;
    GamePlayer chair;

    PositionPlayerStruct leftSide;
    PositionPlayerStruct rightSide;

    public PositionPlayerStruct(GamePlayersWheel gamePlayersWheel, GamePlayer player) {
        wheel = gamePlayersWheel;
        chair = player;

    }
}
