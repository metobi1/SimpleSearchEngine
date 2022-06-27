package search;

import java.util.List;

public class SearchEngine {

    private final InvertedIndex invertedIndex;

    SearchEngine(String[] phoneBook) {
        this.invertedIndex = new InvertedIndex(phoneBook);
    }

    protected List<Integer> searchStrategy(SearchStrategy searchStrategy, String words) {
        return searchStrategy.search(words, invertedIndex.getInvertedIndex());
    }
}
