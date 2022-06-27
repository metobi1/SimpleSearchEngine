package search;

import java.io.File;
import java.util.List;
import java.util.Scanner;

import static search.Print.*;

public class SearchEngineApp {

    private static final Scanner scanner =
            new Scanner(System.in);

    static void runApp(String inpCommand) {

        PhoneBook phoneBook = new PhoneBook(new File(inpCommand));
        phoneBook.loadPhoneBook();
        SearchEngine searchEngine = getSearchEngine(phoneBook.getEntries());

        runChoice(searchEngine, phoneBook.getEntries());
    }

    private static void runChoice(SearchEngine searchEngine, String[] phoneBookEntries) {

        boolean exit = false;

        while (!exit) {
            int choice = getChoice();
            switch (choice) {
                case 1:
                    findAPerson(searchEngine, phoneBookEntries);
                    break;
                case 2:
                    display(phoneBookEntries);
                    break;
                case 0:
                    displayGreetingMsg();
                    exit = true;
                    break;
                default:
                    displayErrorMsg();
            }
        }
    }

    private static int getChoice() {
            displayMenu();
            return scanner.nextInt();
    }

    private static void findAPerson(SearchEngine searchEngine, String[] phoneBookEntries) {

        displayStrategyMenuMsg();
        String input = scanner.next();

        if (wrongInput(input)) {
            return;
        }

        scanner.nextLine();
        displaySearchParam();
        String searchQuery = scanner.nextLine();
        SearchStrategy selectedStrategy = selectedStrategy(input);

        display(searchEngine.searchStrategy(selectedStrategy, searchQuery),
                phoneBookEntries);
    }

    private static boolean wrongInput(String input) {
        return !input.equals("ALL") && !input.equals("ANY") && !input.equals("NONE");
    }

    private static SearchStrategy selectedStrategy(String selectedStrategy) {
        if ("ALL".equals(selectedStrategy)) {
            return new SearchAll();
        } else if ("ANY".equals(selectedStrategy)) {
            return new SearchAny();
        } else if ("NONE".equals(selectedStrategy)) {
            return new SearchNone();
        }
        return null;
    }

    private static SearchEngine getSearchEngine(String[] phoneBook) {
        return new SearchEngine(phoneBook);
    }

    private static void display(List<Integer> foundEntries, String[] phoneBookEntries) {
        if (foundEntries.size() == 0) {
            displayNotFoundMsg();
        } else {
            displayFoundMsg(foundEntries.size());
            for (Integer entry : foundEntries) {
                displayFoundEntry(phoneBookEntries[entry]);
            }
        }
    }
    private static void display(String[] phoneBookEntries) {
        displayHeading();
        for (String entry : phoneBookEntries) displayFoundEntry(entry);
    }
}
