package org.skypro.skyshop.basket;

import java.util.*;

import org.skypro.skyshop.product.Product;


public class ProductBasket {
    private Map <String, List<Product>> baskets = new HashMap();


    public void addProdukt(Product basket) {
        baskets
                .computeIfAbsent(basket.getName(), k-> new LinkedList<>())
                .add(basket);
    }


    public int sumPrices() {
        int summ = 0;
        for (List<Product> list : baskets.values()) {
            for (Product e: list) {
                summ += e.getPrice();
            }
        }
        return summ;
    }

    public void printBasket() {
        if (baskets.isEmpty()) {
            System.out.println("В корзине пусто");
            return;
        }

        int specialCount = 0;

        for (List<Product> list : baskets.values()) {
            for (Product product : list) {
                System.out.println(product);
                if (product.isSpecial()) {
                    specialCount++;
                }
            }
        }

        System.out.println("Итого: " + sumPrices());
        System.out.println("Специальных товаров в корзине: " + specialCount);
    }


    public boolean searchProductBasket(String name) {
        return baskets.containsKey(name);
    }

    public void cleanBasket() {
        baskets.clear();
    }

    public List<Product> removeByName(String name) {
        List<Product> removed = baskets.remove(name);

        if (removed == null) {
            return new LinkedList<>();
        }
        return removed;
    }
}

