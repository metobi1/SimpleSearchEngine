package search;

import java.util.Scanner;

public class SearchEngineApp {

    private static final Scanner scanner =
            new Scanner(System.in);

    static void runApp() {
        int searchResult = searchWord();
        chooseDisplay(searchResult);
    }

    private static int searchWord() {

        String sentence = scanner.nextLine();
        String word = scanner.next();

        SearchEngine searchEngine = new SearchEngine(word);
        return searchEngine.searchWord(sentence);
    }

    private static void display(String output) {
        System.out.println(output);
    }

    private static void chooseDisplay(int searchResult) {
        if (searchResult == -1) {
            display("Not found");
        } else {
            searchResult++;
            display(String.valueOf(searchResult));
        }
    }
}
