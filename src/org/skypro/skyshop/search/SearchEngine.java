package org.skypro.skyshop.search;

public class SearchEngine{
    private Searchable[] items;
    private int size;

    public SearchEngine(int capacity) {
        items = new Searchable[capacity];
    }

    public void add(Searchable item) {
        if (size < items.length) {
            items[size] = item;
            size++;
        }
    }
    public Searchable[] search (String query) {
        Searchable[] result = new Searchable[5];
        int count = 0;
        for (int i = 0; i < size; i++) {
            Searchable item = items[i];
            if (item.getSearchTerm().contains(query)) {
                result[count] = item;
                count++;
            }
            if (count == 5) {
                break;
            }
        }
        return result;
    }

    public Searchable findBestMatch(String search) throws BestResultNotFound {
        Searchable best = null;
        int maxCount = 0;

        for (Searchable item : items) {
            if (item == null) {
                continue;
            }

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