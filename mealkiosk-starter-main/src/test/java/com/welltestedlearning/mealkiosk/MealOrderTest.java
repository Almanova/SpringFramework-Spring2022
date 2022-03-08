package com.welltestedlearning.mealkiosk;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MealOrderTest {

    @Test
    public void emptyMealIsZeroPrice() throws Exception {
        MealOrder mealOrder = new MealOrder();

        assertThat(mealOrder.price())
                .isZero();
    }

    @Test
    public void mealWithCheeseBurgerIs6() throws Exception {
        MealOrder mealOrder = new MealOrder(BurgerTopping.CHEESE);

        assertThat(mealOrder.price())
                .isEqualTo(6);
    }

//    @Test
//    public void mealWithRegularBurgerLargeDrinkCosts7() throws Exception {
//        MealOrder mealOrder = new MealOrder(BurgerOption.REGULAR, DrinkOption.LARGE);
//
//        assertThat(mealOrder.price())
//                .isEqualTo(7);
//    }

}
