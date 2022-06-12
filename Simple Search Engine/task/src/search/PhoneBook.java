package search;

import java.util.Scanner;

public class PhoneBook {

    private final String[] phoneBook;
    private final Scanner scanner =
            new Scanner(System.in);

    protected PhoneBook(int numOfEntries) {
        this.phoneBook = new String[numOfEntries];
    }

    protected String[] getEntries() {
        return phoneBook;
    }

    protected void loadPhoneBook() {
        System.out.println("Enter all people:");
        for (int i = 0; i < phoneBook.length; i++) {
            phoneBook[i] = scanner.nextLine();
        }
    }
}
