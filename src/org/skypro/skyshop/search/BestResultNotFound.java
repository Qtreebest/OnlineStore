package org.skypro.skyshop.search;

public class BestResultNotFound extends Exception {
    public BestResultNotFound(String search) {
        super("Не найден резаультат для запроса " + search);
    }
}
