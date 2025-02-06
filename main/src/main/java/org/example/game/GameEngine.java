package org.example.game;

import org.example.game.cards.DeckAble;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.example.game.Roles.*;
import static org.example.game.Roles.RENEGADE;

public class GameEngine {

    public void playGame(Game game) {
        setupEngine(game);
        setupGame(game);

        while (game.isNotEnded()) {
            game.executeOneInteration();
        }

    }

    private void setupEngine(Game game) {
        game.setupEngine(this);
    }

    private void setupGame(Game game) {
        if(game.isSetupAndReadyTOStart()){

        } else {
            game.setup();
        }
    }

    public List<DeckAble> drawCards(int startHand) {
        return null;
    }

    public List<Roles> randomSelected(int playerCount) {
        Roles[] roles = {SHERIFF, RENEGADE, OUTLAW, OUTLAW, VICE, OUTLAW, VICE, RENEGADE};
        List<Roles> pool = new ArrayList<>();
        List<Roles> result = new ArrayList<>();

        for (int i = 0; i <playerCount ; i++) {
            pool.add(roles[i]);
        }

        for (int i = 0; i <playerCount ; i++) {
            int index = (int) (Math.random() * pool.size());
            Roles addedRoleAtRandom = pool.get(index);
            pool.remove(index);

            result.add(addedRoleAtRandom);
            System.out.println("Role " + addedRoleAtRandom);
        }

        return result;
    }

    public <T> List<T> randomSelected(int playerCount, List<T> fromDeck) {
        List<T> pool = new ArrayList<>(fromDeck);
        List<T> result = new ArrayList<>();


        for (int i = 0; i <playerCount ; i++) {
            int index = (int) (Math.random() * pool.size());
            T addedRoleAtRandom = pool.get(index);
            pool.remove(index);

            result.add(addedRoleAtRandom);
            System.out.println("Selected " + addedRoleAtRandom);
        }

        return result;
    }
}
