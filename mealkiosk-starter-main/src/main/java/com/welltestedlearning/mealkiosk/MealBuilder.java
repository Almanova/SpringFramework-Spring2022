package com.welltestedlearning.mealkiosk;

import java.util.Arrays;

public class MealBuilder {
    private MealOrder order = new MealOrder();
    private String drinkSize;
    private Burger burger = new Burger();

    public void addBurgerString(String burgerOrderText) {
        String[] items = burgerOrderText.split(",");

        Arrays.stream(items).forEach(item -> {
            switch (item) {
                case "cheese":
                    this.burger = new Burger(BurgerTopping.CHEESE, 1);
                case "avocado":
                    this.burger = new Burger(BurgerTopping.AVOCADO, 1);
                case "bacon":
                    this.burger = new Burger(BurgerTopping.BACON, 1);
            }
        });
    }

    public void withDrink(String size) {
        this.drinkSize = size;
    }

    public MealOrder build() {
        MealOrder mealOrder = new MealOrder();
        mealOrder.addItem(burger);
        mealOrder.addDrink(drinkSize);
        return mealOrder;
    }
}
