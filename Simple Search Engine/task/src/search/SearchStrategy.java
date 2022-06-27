package search;

import java.util.*;

abstract class SearchStrategy {

    private List<Integer> searchWord(String word, Map<String,
            List<Integer>> invertedIndex) {

        if (invertedIndex.containsKey(word.toLowerCase())) {
            return invertedIndex.get(word.toLowerCase());
        }
        return new ArrayList<>();
    }

    protected List<Integer> search(String words, Map<String,
            List<Integer>> invertedIndex) {

        String[] wordArray = words.split(" ");
        List<Set<Integer>> posList = new ArrayList<>();

        for (String word : wordArray) {
            Set<Integer> pos = new HashSet<>(searchWord(word, invertedIndex));
            posList.add(pos);
        }
        return subClassProcess(posList, invertedIndex);
    }

    protected abstract List<Integer> subClassProcess(List<Set<Integer>> allPos, Map<String,
            List<Integer>> invertedIndex);
}
