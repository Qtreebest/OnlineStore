package org.skypro.skyshop;

import org.skypro.skyshop.Article.Article;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.search.BestResultNotFound;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.Searchable;

import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) {
        ProductBasket basket = new ProductBasket();

        basket.addProdukt(new SimpleProduct("Молоко", 123));
        basket.addProdukt(new DiscountedProduct("Хлеб", 300, 10));
        basket.addProdukt(new FixPriceProduct("Яблоко"));
        basket.addProdukt(new SimpleProduct("Сыр", 234));
        basket.addProdukt(new DiscountedProduct("Сок", 200, 20));
        basket.addProdukt(new SimpleProduct("Чай", 352));
        basket.addProdukt(new DiscountedProduct("Лайм", 200, 20));

        basket.printBasket();
        System.out.println(basket.sumPrices());

        List<Product> removed = basket.removeByName("Чай");

        for (Product product : removed) {
            System.out.println("Удален: " + product);
        }
        System.out.println("\n" + "печатаем содержимое корзины" + "\n");
        basket.printBasket();

        List<Product> removed2 = basket.removeByName("Коклюш");
        if (removed2.isEmpty()) {
            System.out.println("Список пустой");
        } else {
            for (Product product : removed2) {
                System.out.println("Удален: " + product);
            }
        }


        System.out.println(basket.searchProductBasket("Молоко"));
        System.out.println(basket.searchProductBasket("Кола"));

        basket.cleanBasket();

        basket.printBasket();

        System.out.println(basket.sumPrices());
        System.out.println(basket.searchProductBasket("Молоко"));

        SearchEngine engine = new SearchEngine();
        engine.add(new SimpleProduct("Телефон", 100));
        engine.add(new FixPriceProduct("Ноутбук"));
        engine.add(new Article("Java", "Язык програмирования которому мы учимся"));
        engine.add(new Article("Компьютер", "Я учусь и учу язык Java на ноутбуке, и иногда смотю уроки с телефона"));
        Map<String, Searchable> result1 = engine.search("Java");
        Map<String, Searchable> result2 = engine.search("Тел");
        Map<String, Searchable> result3 = engine.search("ноут");
        Map<String, Searchable> result4 = engine.search("App");

        try {
            Product p = new SimpleProduct("", 100);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Поиск: Java");
        if (result1.isEmpty()) {
            System.out.println("Ничего не найдено");
        } else {
            for (Searchable s : result1.values()) {
                System.out.println(s.getStringRepresentation());
            }
        }
        System.out.println("Поиск: Ноут");
        if (result3.isEmpty()) {
            System.out.println("Ничего не найдено");
        } else {
            for (Searchable s : result3.values()) {
                System.out.println(s.getStringRepresentation());
            }
        }
        System.out.println("Поиск: Тел");
        if (result2.isEmpty()) {
            System.out.println("Ничего не найдено");
        } else {
            for (Searchable s : result2.values()) {
                System.out.println(s.getStringRepresentation());
            }
        }

        System.out.println("Поиск: App");
        if (result4.isEmpty()) {
            System.out.println("Ничего не найдено");
        } else {
            for (Searchable s : result4.values()) {
                System.out.println(s.getStringRepresentation());
            }
        }

        try {
            Searchable result = engine.findBestMatch("Java");
            System.out.println("Найдено: " + result.getStringRepresentation());
        } catch (BestResultNotFound e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
        try {
            Searchable result = engine.findBestMatch("Холодильник");
            System.out.println("Найдено: " + result.getStringRepresentation());
        } catch (BestResultNotFound e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}