package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {
    private int basePrice;
    private float discount;

    public DiscountedProduct(String name, int basePrice, int discount) {
        super(name);
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
