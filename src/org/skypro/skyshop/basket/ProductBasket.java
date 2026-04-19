package org.skypro.skyshop.basket;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;

import org.skypro.skyshop.product.Product;


public class ProductBasket {
    private List<Product> baskets = new LinkedList<>();


    public void addProdukt(Product basket) {
        baskets.add(basket);
    }


    public int sumPrices() {
        int summ = 0;
        for (Product e : baskets) {
            summ += e.getPrice();
        }
        return summ;
    }

    public void printBasket() {
        if (baskets.isEmpty()) {
            System.out.println("В корзине пусто");
            return;
        }

        int specialCount = 0;

        for (Product product : baskets) {
            System.out.println(product);
            if (product.isSpecial()) {
                specialCount++;
            }
        }

        System.out.println("Итого: " + sumPrices());
        System.out.println("Специальных товаров в корзине: " + specialCount);
    }


    public boolean searchProductBasket(String name) {
        for (Product e : baskets) {
            if (e.getName().equals(name)) {
                return true;
            }

        }
        return false;
    }

    public void cleanBasket() {
        baskets.clear();
    }

    public List<Product> removeByName(String name) {
        List<Product> removedProducts = new ArrayList<>();

        Iterator<Product> iterator = baskets.iterator();

        while (iterator.hasNext()) {
            Product product = iterator.next();

            if (product.getName().equals(name)) {
                removedProducts.add(product);
                iterator.remove();
            }
        }
        return removedProducts;
    }
}

