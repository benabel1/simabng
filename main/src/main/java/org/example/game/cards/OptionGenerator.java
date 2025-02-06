package org.example.game.cards;

import org.example.game.*;
import org.example.game.options.OptionOption;
import org.example.game.options.OptionScanner;

import java.util.ArrayList;
import java.util.List;

public class OptionGenerator {

    public void generateOption(Game game, GamePlayer player) {
        List<OptionOption> allOptions = new ArrayList<>();
        allOptions.add(new SkipOption());
        allOptions.addAll(game.generateGlobalOption());
        allOptions.addAll(player.generateALlOption());

        for (OptionOption option: allOptions) {
            System.out.println("\t" + option);
        }

        OptionScanner.scanInt("Which option", 0, 10, 0);
    }
}
