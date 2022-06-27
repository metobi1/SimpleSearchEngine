package search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InvertedIndex {

    private final Map<String, List<Integer>> invertedIndex
            = new HashMap<>();

    InvertedIndex(String[] phoneBook) {
        invertedIndex(phoneBook);
    }

    public Map<String, List<Integer>> getInvertedIndex() {
        return invertedIndex;
    }

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
}
