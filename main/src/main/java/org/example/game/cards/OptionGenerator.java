package org.example.game.cards;

import org.example.game.Game;
import org.example.game.GamePlayer;
import org.example.game.OptionOption;
import org.example.game.OptionScanner;

import java.util.ArrayList;
import java.util.List;

public class OptionGenerator {

    public void generateOption(Game game, GamePlayer player) {
        List<OptionOption> allOptions = new ArrayList<>();

        allOptions.addAll(game.generateGlobalOption());
        allOptions.addAll(player.generateALlOption());

        for (OptionOption option: allOptions) {
            System.out.println(option);
        }

        OptionScanner.scanInt("Which option", 0, 10, 0);
    }
}
