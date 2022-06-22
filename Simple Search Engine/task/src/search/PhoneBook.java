package search;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PhoneBook {

    private String[] phoneBook;
    private final File file;

    protected PhoneBook(File file) {

        this.file = file;
        phoneBook = new String[5];
    }

    protected String[] getEntries() {
        return phoneBook;
    }

    private void expandArray() {
        String[] newArray = getNewArray();
        copyOldArray(newArray);
        phoneBook = newArray;
    }

    private void copyOldArray(String[] newArray) {

        for (int i = 0; i < phoneBook.length; i++) {
            if (phoneBook[i] == null) {
                break;
            }
            newArray[i] = phoneBook[i];
        }
    }

    private String[] getNewArray() {
        return new String[phoneBook.length * 2];
    }

    private String[] getNewArray(int len) {
        return new String[len];
    }

    private void shrinkArray() {

        int nonNullLen = getNonNullLen();
        String[] newArray = getNewArray(nonNullLen);
        copyOldArray(newArray);
        phoneBook = newArray;
    }

    private int getNonNullLen() {
        int count = 0;

        for (String str : phoneBook) {
            if (str == null) {
                break;
            }
            count++;
        }
        return count;
    }

    protected void loadPhoneBook() {
        //System.out.println("Enter all people:");
        int index = 0;

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                if (index >= phoneBook.length) {
                    expandArray();
                }
                phoneBook[index] = scanner.nextLine();
                index++;
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found, please enter the " +
                    "correct file path and try again");
        }
        shrinkArray();
    }
}
