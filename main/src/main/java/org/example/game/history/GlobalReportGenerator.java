package org.example.game.history;

import org.example.game.Game;
import org.example.game.GamePlayer;
import org.example.game.cards.characters.GameCharacter;

public class GlobalReportGenerator {
    GamePlayer [] gamePlayers;

    public String finalRecord(Game game){
        String total = "";

        total += getGameId(game) + "\t";

        total += gamePlayers.length + "\t" + getWinningSize(game);

        return total;
    }

    private String getWinningSize(Game game) {
        return game.whoIsWinnerAsString();
    }

    private String getGameId(Game game) {
        if (game == null) {
            return "";
        } else {
            return game.getUniqueId();
        }
    }
}
