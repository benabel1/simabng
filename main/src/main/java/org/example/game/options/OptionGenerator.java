package org.example.game.options;

import org.example.game.*;
import org.example.game.options.scaner.OptionScanner;

import java.util.ArrayList;
import java.util.List;

public class OptionGenerator {

    public void generateOptionAndChooseOne(Game game, GamePlayer player) {
        List<OptionOption> allOptions = new ArrayList<>();
        allOptions.add(new SkipOption(player));
        allOptions.addAll(game.generateGlobalOption());
        allOptions.addAll(player.generateALlOption(game));

        game.printAllSteps();

        showAllOptions(allOptions);

        int choice = OptionScanner.scanInt("Which option", 0,  allOptions.size(), 0);
        OptionOption option = allOptions.get(choice);

        game.resolveOption(option);
    }

    private void showAllOptions(List<OptionOption> allOptions) {
        for (int i = 0; i < allOptions.size(); i++) {
            System.out.format("\t%2d %s\n", i, allOptions.get(i));
        }
    }
}
