package org.skypro.skyshop.product;

import javax.xml.namespace.QName;

public class DiscountedProduct extends Product {
    private int basePrice;
    private float discount;

    public DiscountedProduct(String name, int basePrice, int discount) {
        super(name);
        if (basePrice <= 0) {
            throw new IllegalArgumentException("Базовая цена должна быть > 0");
        }
        if (discount < 0 || discount > 100) {
            throw new IllegalArgumentException("Скидка должна быть от 0 до 100 ");
        }
        this.basePrice = basePrice;
        this.discount = discount;
    }

    @Override
    public int getPrice() {
        return this.basePrice = (int) (basePrice * (1 - discount / 100));
    }

    @Override
    public String toString() {
        return getName() + ": " + getPrice() + " (скидка " + discount + "%)";
    }

    @Override
    public boolean isSpecial() {
        return true;
    }
}
