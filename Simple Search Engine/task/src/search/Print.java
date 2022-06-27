package search;

public class Print {
    static void displayMenu() {
        System.out.println("\n=== Menu ===");
        System.out.println("1. Find a person");
        System.out.println("2. Print all people");
        System.out.println("0. Exit");
    }

    static void displaySearchParam() {
        System.out.println("\nEnter a name or email to search all suitable people.");
    }

    static void displayStrategyMenuMsg() {
        System.out.println("\nSelect a matching strategy: ALL, ANY, NONE");
    }

    static void displayNotFoundMsg() {
        System.out.println("No matching people found.");
    }

    static void displayFoundMsg(int numPplFound) {
        System.out.printf("%d persons found:%n", numPplFound);
    }

    static void displayFoundEntry(String entry) {
        System.out.println(entry);
    }

    static void displayHeading() {
        System.out.println("\n=== List of people ===");
    }

    static void displayErrorMsg() {
        System.out.println("\nIncorrect option! Try again.");
    }

    static void displayGreetingMsg() {
        System.out.println("\nBye!");
    }
}
