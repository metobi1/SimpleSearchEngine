package search;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SearchEngineApp {

    private static final Scanner scanner =
            new Scanner(System.in);

    static void runApp() {

        PhoneBook phoneBook = getPhoneBook();
        phoneBook.loadPhoneBook();

        runChoice(phoneBook.getEntries());

        //searchForPeople(phoneBook.getEntries());

    }

    private static PhoneBook getPhoneBook() {
        int numOfPeople = getNum("people");
        return new PhoneBook(numOfPeople);
    }

    private static int getNum(String detailsNeeded) {
        System.out.printf("%nEnter the number of %s:%n", detailsNeeded);
        return scanner.nextInt();
    }

    private static void runChoice(String[] phoneBookEntries) {

        boolean exit = false;

        while (!exit) {
            int choice = getChoice();
            switch (choice) {
                case 1:
                    findAPerson(phoneBookEntries);
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

    private static void findAPerson(String[] phoneBookEntries) {
        System.out.println("\nEnter a name or email to search all suitable people.");
        String searchQuery = scanner.next();
        display(searchPhoneBook(phoneBookEntries, searchQuery),
                phoneBookEntries);
    }

    private static List<Integer> searchPhoneBook(String[] phoneBook, String person) {

        SearchEngine searchEngine = new SearchEngine(person);
        return searchEngine.searchWord(phoneBook);
    }

    private static void display(List<Integer> foundEntries, String[] phoneBookEntries) {
        if (foundEntries.size() == 0) {
            System.out.println("No matching people found.");
        } else {
            //System.out.println("\nFound people:");
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
