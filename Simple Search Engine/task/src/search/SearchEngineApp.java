package search;

import java.io.File;
import java.util.List;
import java.util.Scanner;

public class SearchEngineApp {

    private static final Scanner scanner =
            new Scanner(System.in);

    static void runApp(String inpCommand) {


        PhoneBook phoneBook = new PhoneBook(new File(inpCommand));
        phoneBook.loadPhoneBook();
        SearchEngine searchEngine = getSearchEngine(phoneBook.getEntries());

        runChoice(searchEngine, phoneBook.getEntries());

        //searchForPeople(phoneBook.getEntries());

    }

    /*private static int getNum(String detailsNeeded) {
        System.out.printf("%nEnter the number of %s:%n", detailsNeeded);
        return scanner.nextInt();
    }*/

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
                    System.out.println("\nBye!");
                    exit = true;
                    break;
                default:
                    System.out.println("\nIncorrect option! Try again.");
            }
        }
    }

    private static int getChoice() {
            displayMenu();
            return scanner.nextInt();
    }

    private static void displayMenu() {
        System.out.println("\n=== Menu ===");
        System.out.println("1. Find a person");
        System.out.println("2. Print all people");
        System.out.println("0. Exit");
    }

    /*private static void searchForPeople(String[] phoneBookEntries) {

        int numOfSearches = getNum("search queries");

        for (int i = 0; i < numOfSearches; i++) {
            System.out.println("\nEnter data to search people:");
            String searchQuery = scanner.next();
            display(searchPerson(phoneBookEntries, searchQuery), phoneBookEntries);
        }
    }*/

    private static void findAPerson(SearchEngine searchEngine, String[] phoneBookEntries) {
        scanner.nextLine();
        System.out.println("\nEnter a name or email to search all suitable people.");
        String searchQuery = scanner.nextLine();
        display(searchEngine.searchWord(searchQuery),
                phoneBookEntries);
    }

    private static SearchEngine getSearchEngine(String[] phoneBook) {
        return new SearchEngine(phoneBook);
    }

    /*private static List<Integer> searchPhoneBook(String[] phoneBook, String person) {

        SearchEngine searchEngine = new SearchEngine(person);
        return searchEngine.searchWord(phoneBook);
    }*/

    private static void display(List<Integer> foundEntries, String[] phoneBookEntries) {
        if (foundEntries.size() == 0) {
            System.out.println("No matching people found.");
        } else {
            System.out.printf("%d persons found:%n", foundEntries.size());
            for (Integer entry : foundEntries) {
                System.out.println(phoneBookEntries[entry]);
            }
        }
    }
    private static void display(String[] phoneBookEntries) {
        System.out.println("\n=== List of people ===");
        for (String entry : phoneBookEntries) System.out.println(entry);
    }
}
