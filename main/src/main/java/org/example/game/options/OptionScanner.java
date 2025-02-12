package org.example.game.options;

import java.util.Scanner;

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
}
