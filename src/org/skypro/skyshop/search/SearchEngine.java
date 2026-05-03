package org.skypro.skyshop.search;

import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;
import java.util.List;

public class SearchEngine{
    private List<Searchable> items = new LinkedList<>();

    public void add(Searchable item) {
        items.add(item);
    }

    public Map<String, Searchable> search (String query) {
        Map<String, Searchable> result = new TreeMap<>();
        for (Searchable item : items) {
            if (item.getSearchTerm().toLowerCase().contains(query.toLowerCase())) {
                result.put(item.getSearchTerm(), item);
            }
        }
        return result;
    }

    public Searchable findBestMatch(String search) throws BestResultNotFound {
        Searchable best = null;
        int maxCount = 0;

        for (Searchable item : items) {
            String text = item.getSearchTerm();

            int count = 0;
            int index = 0;

            int fountIndex = text.indexOf(search, index);
            while (fountIndex != -1) {
                count++;
                index = fountIndex + search.length();
                fountIndex = text.indexOf(search, index);
            }
            if (count > maxCount) {
                maxCount = count;
                best = item;
            }
        }
        if (best == null) {
            throw new BestResultNotFound("Не найдено для: " + search);
        }
        return best;
    }
}