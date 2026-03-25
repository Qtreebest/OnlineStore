package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

public class ProductBasket {
    private Product[] baskets = new Product[5];


    public void addProdukt(Product basket) {
        for (int i = 0; i < baskets.length; i++) {
            if (baskets[i] == null) {
                baskets[i] = basket;
                return;
            }
        }
        System.out.println("Невозможно добавить продукт");
    }


    public int sumPrices() {
        int summ = 0;
        for (Product e : baskets) {
            if (e != null) {
                summ += e.getPrice();
            }
        }
        return summ;
    }

    public void printBasket() {
        boolean isEmpty = true;
        int specialCount = 0;

        for (Product product : baskets) {
            if (product != null) {
                System.out.println(product);
                if (product.isSpecial()) {
                    specialCount++;
                }
                isEmpty = false;
            }
        }

        if (isEmpty) {
            System.out.println("В корзине пусто");
            return;
        }

        System.out.println("Итого: " + sumPrices());
        System.out.println("Специальных товаров в корзине: " + specialCount);
    }


    public boolean searchProductBasket(String name) {
        for (Product e : baskets) {
            if (e != null && e.getName().equals(name)) {
                return true;
            }

        }
        return false;
    }

    public void cleanBasket() {
        for (int i = 0; i < baskets.length; i++) {
            baskets[i] = null;
        }
    }
}
