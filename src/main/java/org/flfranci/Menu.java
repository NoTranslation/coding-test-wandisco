package org.flfranci;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.flfranci.Util.tryParseInt;

public class Menu {
    public static int getMenu(String text, List<String> options) {
        Scanner userInput = new Scanner(System.in);
        System.out.println(text);
        String optionPicked = null;
        do {
            System.out.println("Pick Value:");
            String formatedOptions = formatOptions(options);
            System.out.println(formatedOptions);
            optionPicked = userInput.nextLine();
            int optionAsNum = tryParseInt(optionPicked,-1);
            if (optionAsNum > 0 && optionAsNum < options.size()) {
                return optionAsNum;
            }
            System.out.println("Invalid option picked");
        } while (true);
    }

    private static String formatOptions(List<String> options) {
        return IntStream.range(1, options.size())
                .mapToObj(x -> String.format("%d. %s", x, options.get(x)))
                .collect(Collectors.joining("\n"));
    }
}
