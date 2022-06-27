package search;

import java.util.*;

public class SearchNone extends SearchStrategy{
    @Override
    protected List<Integer> subClassProcess(List<Set<Integer>> allPos, Map<String,
            List<Integer>> invertedIndex) {

        Set<Integer> searchNonePos = getValues(invertedIndex);
        return removeAll(allPos, searchNonePos);
    }

    private List<Integer> removeAll(List<Set<Integer>> allPos, Set<Integer> searchNonePos) {

        for (Set<Integer> pos : allPos) {
            searchNonePos.removeAll(pos);
        }
        return new ArrayList<>(searchNonePos);
    }

    private Set<Integer> getValues(Map<String, List<Integer>> invertedIndex) {

        Set<Integer> values = new HashSet<>();

        for (List<Integer> value : invertedIndex.values()) {
            values.addAll(value);
        }
        return values;
    }
}
