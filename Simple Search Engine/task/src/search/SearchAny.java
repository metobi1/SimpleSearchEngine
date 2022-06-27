package search;

import java.util.*;

public class SearchAny extends SearchStrategy{
    @Override
    protected List<Integer> subClassProcess(List<Set<Integer>> allPos, Map<String,
            List<Integer>> invertedIndex) {

        return addAll(allPos);
    }

    private List<Integer> addAll(List<Set<Integer>> allPos) {

        Set<Integer> searchAnyPos = new HashSet<>();

        for (Set<Integer> pos : allPos) {
            if (searchAnyPos.size() == 0) {
                searchAnyPos.addAll(pos);
            }
            searchAnyPos.addAll(pos);
        }
        return new ArrayList<>(searchAnyPos);
    }
}
