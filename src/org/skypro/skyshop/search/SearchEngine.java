package org.skypro.skyshop.search;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.Comparator;


public class SearchEngine {

    private Set<Searchable> items = new HashSet<>();

    public void add(Searchable item) {
        items.add(item);
    }

    public Set<Searchable> search(String query) {
        Set<Searchable> result = new TreeSet<>(new Comparator<Searchable>() {
            @Override
            public int compare(Searchable o1, Searchable o2) {
                String name1 = o1.getName();
                String name2 = o2.getName();

                int lengthCompare = Integer.compare(name2.length(), name1.length());

                if (lengthCompare != 0) {
                    return lengthCompare;
                }

                return name1.compareTo(name2);
            }
        });
        for (Searchable item : items) {
            if (item.getSearchTerm().toLowerCase().contains(query.toLowerCase())) {
                result.add(item);
            }
        }
        return result;
    }

        public Searchable findBestMatch (String search) throws BestResultNotFound {
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

