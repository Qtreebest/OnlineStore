package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;

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
    }
}