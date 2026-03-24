package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;

public class App {
    public static void main(String[] args) {
        ProductBasket basket = new ProductBasket();

        Product milk = new Product("Milk", 100);
        Product bread = new Product("Bread", 80);
        Product apple = new Product("Apple", 60);
        Product cheese = new Product("Cheese", 200);
        Product juice = new Product("Juice", 120);
        Product tea = new Product("Tea", 90);

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
    }
}