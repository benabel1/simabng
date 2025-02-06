package org.example.game.cards;

import org.example.game.*;
import org.example.game.options.OptionOption;
import org.example.game.options.OptionScanner;

import java.util.ArrayList;
import java.util.List;

public class OptionGenerator {

    public void generateOptionAndChooseOne(Game game, GamePlayer player) {
        List<OptionOption> allOptions = new ArrayList<>();
        allOptions.add(new SkipOption());
        allOptions.addAll(game.generateGlobalOption());
        allOptions.addAll(player.generateALlOption());

        for (int i = 0; i < allOptions.size(); i++) {
            System.out.format("\t%2d %15s\n", i, allOptions.get(i));

        }

        int choice = OptionScanner.scanInt("Which option", 0,  allOptions.size(), 0);
        OptionOption option = allOptions.get(choice);

        game.resolveOption(option);
    }
}
