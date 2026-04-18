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

public class App {
    public static void main(String[] args) {
        ProductBasket basket = new ProductBasket();

        Product milk = new SimpleProduct("Milk", 123);
        Product bread = new DiscountedProduct("Bread", 300, 10);
        Product apple = new FixPriceProduct("Apple");
        Product cheese = new SimpleProduct("Cheese", 234);
        Product juice = new DiscountedProduct("Juice", 200, 20);
        Product tea = new SimpleProduct("Tea", 352);
        Product lime = new DiscountedProduct("lime", 200, 20);

        basket.addProdukt(milk);
        basket.addProdukt(bread);
        basket.addProdukt(apple);
        basket.addProdukt(cheese);
        basket.addProdukt(juice);

        basket.addProdukt(tea); // корзина переполнена

        basket.printBasket();

        System.out.println(basket.sumPrices());

        System.out.println(basket.searchProductBasket("Milk"));
        System.out.println(basket.searchProductBasket("Cola"));

        basket.cleanBasket();

        basket.printBasket();

        System.out.println(basket.sumPrices());
        System.out.println(basket.searchProductBasket("Milk"));
        SearchEngine engine = new SearchEngine(20);
        engine.add(new SimpleProduct("Телефон", 100));
        engine.add(apple);
        engine.add(new FixPriceProduct("Ноутбук"));
        engine.add(new Article("Java", "Язык програмирования которому мы учимся"));
        engine.add(new Article("Компьютер", "Я учусь и учу язык Java на ноутбуке, и иногда смотю уроки с телефона"));
        Searchable[] restult1 = engine.search("Java");
        Searchable[] restult2 = engine.search("Тел");
        Searchable[] restult3 = engine.search("ноут");
        try {
            Product p = new SimpleProduct("", 100);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Поиск: Java");
        for (Searchable s : engine.search("Java")) {
            if (s != null) {
                System.out.println(s.getStringRepresentation());
            }
        }
        System.out.println("Поиск: Ноут");
        for (Searchable s : engine.search("Ноут")) {
            if (s != null) {
                System.out.println(s.getStringRepresentation());
            }
        }
        System.out.println("Поиск: Тел");
        for (Searchable s : restult2) {
            if (s != null) {
                System.out.println(s.getStringRepresentation());
            }
        }
        System.out.println("Поиск: App");
        for (Searchable s : engine.search("App")) {
            if (s != null) {
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