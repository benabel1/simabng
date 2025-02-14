package org.example.game.options;

import org.example.game.Game;
import org.example.game.GamePlayer;
import org.example.game.PairPlayerCard;

import java.util.List;
import java.util.Scanner;

import static org.example.game.cards.ZONE.HAND;

public class OptionScanner {
    public static Scanner scanner = new Scanner(System.in);

    public static int scanInt(String question, int min, int max, int defaultValue) {
        if (question == null) {
            System.out.println("Select option between " + min + " " + max);
        } else {
            System.out.println(question);
        }

        try {
            int scannedInt = scanner.nextInt();
            return (scannedInt >= min && scannedInt <= max)? scannedInt : defaultValue;
        }
        catch (Exception e) {
            return defaultValue;
        }
    }

    public static String scanText(String writeNameOfPlayer) {
        return scanner.nextLine();
    }

    public static PairPlayerCard scanForPlayerOtherThanDistance(Game game, GamePlayer ownerPlayer, int distance) {
        List<GamePlayer> playerWithHands = game.getPlayersWithHandOtherThan(ownerPlayer);

        int choice = scanInt("Choose Player", 0, playerWithHands.size(), -1);

        if (choice != -1) {
            return null;
        } else {
            return new PairPlayerCard(playerWithHands.get(choice), playerWithHands.get(choice).getRandomCard(HAND));
        }

    }

    public static <T>  T scanForObjectSpecificList(String instruction, List<T> selectionObjectList, int min, int max, int notValid){
        if (selectionObjectList == null || selectionObjectList.isEmpty()) {
            return null;
        } else {
            int choice = scanInt(instruction + ": " + selectionObjectList, 0, selectionObjectList.size(), -1);

            if (choice == -1) {
                return null;
            } else {
                return selectionObjectList.get(choice);
            }
        }

    }

}
