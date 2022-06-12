package search;

import java.util.ArrayList;
import java.util.List;

public class SearchEngine {

    private final String word;

    SearchEngine(String word) {
        this.word = word;
    }

    protected List<Integer> searchWord(String[] phoneBook) {

        List<Integer> foundIndexes = new ArrayList<>();

        for (int i = 0; i < phoneBook.length; i++) {

            if (phoneBook[i].toLowerCase().contains(word.toLowerCase())) {
                foundIndexes.add(i);
            }
        }
        return foundIndexes;
    }
}
