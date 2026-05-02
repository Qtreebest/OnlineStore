package org.skypro.skyshop.search;
import java.util.LinkedList;
import java.util.List;
import java.util.Arrays;

public class SearchEngine{
    private List<Searchable> items = new LinkedList<>();
    private int size;

    public void add(Searchable item) {
        items.add(item);
    }

    public List<Searchable> search (String query) {
        List<Searchable> result = new LinkedList<>();
        for (Searchable item : items) {
            if (item.getSearchTerm().contains(query)) {
                result.add(item);
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