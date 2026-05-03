package org.skypro.skyshop.Article;

import org.skypro.skyshop.search.Searchable;

import java.util.Objects;

public class Article implements Searchable {
    private final String title;
    private final String text;

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    public Article (String title, String text){
        this.title = title;
        this.text = text;
    }

        @Override
    public String toString() {
        return title + "/n" + text;
    }

    @Override
    public String getSearchTerm() {
        return title + " " + text;
    }

    @Override
    public String getType() {
        return "ARTICLE";
    }

    @Override
    public String getName() {
        return title;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) return true;
        if (!(o instanceof Article)) return false;
        Article article = (Article) o;
        return getName().equals(article.getName());
    }

    @Override
    public int hashCode() {
        return getName().hashCode();
    }
}
