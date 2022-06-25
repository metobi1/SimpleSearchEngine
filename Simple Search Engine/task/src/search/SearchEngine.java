package search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SearchEngine {

    //private final String word;
    private final Map<String, List<Integer>> invertedIndex
            = new HashMap<>();

    SearchEngine(String[] phoneBook) {
        //this.word = word;
        invertedIndex(phoneBook);
    }

    /*SearchEngine(String word) {
        this.word = word;
    }*/

    protected void invertedIndex(String[] phoneBook) {

        for (int i = 0; i < phoneBook.length; i++) {

            String[] phoneEntry = phoneBook[i].split(" ");
            addEntry(phoneEntry, i);
        }
    }

    private void addEntry(String[] phoneEntry, int index) {

        for (String entry : phoneEntry) {
            String lowerCaseEntry = entry.toLowerCase();
            if (invertedIndex.containsKey(lowerCaseEntry)) {
                // the value is a list object, so just get it (arrayList)
                // and add the index to it, no need assigning to a reference variable
                invertedIndex.get(lowerCaseEntry).add(index);
            } else {
                List<Integer> value = new ArrayList<>();
                value.add(index);
                invertedIndex.put(lowerCaseEntry, value);
            }
        }

    }

    protected List<Integer> searchWord(String word) {

       if (invertedIndex.containsKey(word.toLowerCase())) {
           return invertedIndex.get(word.toLowerCase());
        }
        return new ArrayList<>();
    }

    /*protected List<Integer> searchWord(String[] phoneBook) {

        List<Integer> foundIndexes = new ArrayList<>();

        for (int i = 0; i < phoneBook.length; i++) {

            if (phoneBook[i].toLowerCase().contains(word.toLowerCase())) {
                foundIndexes.add(i);
            }
        }
        return foundIndexes;
    }*/
}
