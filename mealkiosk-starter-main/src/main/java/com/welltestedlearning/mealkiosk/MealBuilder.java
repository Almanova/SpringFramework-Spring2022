package com.welltestedlearning.mealkiosk;

import java.util.Arrays;

public class MealBuilder {
    private MealOrder order = new MealOrder();

    public void addBurgerString(String burgerOrderText) {
        String[] items = burgerOrderText.split(",");

        Arrays.stream(items).forEach(item -> {
            switch (item) {
                case "cheese":
                    order.addBurger(BurgerTopping.CHEESE);
                case "avocado":
                    order.addBurger(BurgerTopping.AVOCADO);
                case "bacon":
                    order.addBurger(BurgerTopping.BACON);
            }
        });
    }

    public MealOrder build() {
        return order;
    }
}
