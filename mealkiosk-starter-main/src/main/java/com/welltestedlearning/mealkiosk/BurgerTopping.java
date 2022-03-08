package com.welltestedlearning.mealkiosk;

public enum BurgerTopping {
    CHEESE(1),
    BACON(2),
    AVOCADO(3);

    private final int price;

    private BurgerTopping(int price) {
        this.price = price;
    }

    public int price() {
        return price;
    }
}
