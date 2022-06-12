package search;

import java.util.List;
import java.util.Scanner;

public class SearchEngineApp {

    private static final Scanner scanner =
            new Scanner(System.in);

    static void runApp() {

        PhoneBook phoneBook = getPhoneBook();
        phoneBook.loadPhoneBook();

        searchForPeople(phoneBook.getEntries());

    }

    private static PhoneBook getPhoneBook() {
        int numOfPeople = getNum("people");
        return new PhoneBook(numOfPeople);
    }

    private static int getNum(String detailsNeeded) {
        System.out.printf("%nEnter the number of %s:%n", detailsNeeded);
        return scanner.nextInt();
    }

    private static void searchForPeople(String[] phoneBookEntries) {

        int numOfSearches = getNum("search queries");

        for (int i = 0; i < numOfSearches; i++) {
            System.out.println("%nEnter data to search people:");
            String searchQuery = scanner.next();
            display(searchPerson(phoneBookEntries, searchQuery), phoneBookEntries);
        }
    }

    private static List<Integer> searchPerson(String[] phoneBook, String person) {

        SearchEngine searchEngine = new SearchEngine(person);
        return searchEngine.searchWord(phoneBook);
    }

    private static void display(List<Integer> foundEntries, String[] phoneBookEntries) {
        if (foundEntries.size() == 0) {
            System.out.println("No matching people found.");
        } else {
            System.out.println("%nFound people:");
            for (Integer entry : foundEntries) {
                System.out.println(phoneBookEntries[entry]);
            }
        }
    }
}
