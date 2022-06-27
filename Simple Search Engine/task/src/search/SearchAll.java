package search;

import java.util.*;

public class SearchAll extends SearchStrategy {
    @Override
    protected List<Integer> subClassProcess(List<Set<Integer>> allPos, Map<String,
            List<Integer>> invertedIndex) {
        return retainAll(allPos);
    }

    private List<Integer> retainAll(List<Set<Integer>> allPos) {

        Set<Integer> searchAllPos = new HashSet<>();

        for (Set<Integer> pos : allPos) {
            if (searchAllPos.size() == 0) {
                searchAllPos.addAll(pos);
            }
            searchAllPos.retainAll(pos);
        }
        return new ArrayList<>(searchAllPos);
    }
}
