package search;

import java.util.List;
import java.util.Objects;

public class SearchEngine {

    private final String word;

    SearchEngine(String word) {
        this.word = word;
    }

    protected int searchWord(String sentence) {

        List<String> words = List.of(sentence.split(" "));
        return words.indexOf(word);
    }
}
