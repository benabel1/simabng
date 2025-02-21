package org.example.game.options.scaner;

import org.example.game.Game;
import org.example.game.GamePlayer;
import org.example.game.wheel.PairPlayerCard;

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
            String enter = scanner.nextLine();

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

    public static <T>  T scanForObjectSpecificList(String instruction, List<T> selectionObjectList, int min, int max, T notValid){
        if (selectionObjectList == null || selectionObjectList.isEmpty()) {
            return null;
        } else {
            System.out.println(instruction + "<" + min+ ", " +  max + ">(" + notValid + ")");

            for (int i = 0; i < selectionObjectList.size(); i++) {

                T itemAtI = selectionObjectList.get(i);
                System.out.println("\t" + i + " :" + itemAtI);
            }

            int choice = scanInt( 0, selectionObjectList.size(), -1);

            if (choice == -1) {
                return null;
            } else {
                return selectionObjectList.get(choice);
            }
        }

    }

    private static int scanInt(int min, int max, int defVal) {
        int option = scanner.nextInt();

        if (option >= max || option < min) {
            option = defVal;
        }
        return option;
    }

}
