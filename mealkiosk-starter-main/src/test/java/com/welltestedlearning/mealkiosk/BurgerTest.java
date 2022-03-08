package com.welltestedlearning.mealkiosk;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BurgerTest {

    @Test
    public void burgerWithNoToppingsCosts5() throws Exception {
        Burger burger = new Burger();

        int price = burger.price();

        assertThat(price)
                .isEqualTo(5);
    }

    @Test
    public void cheeseburgerCosts6() throws Exception {
        Burger burger = new Burger(BurgerTopping.CHEESE, 1);

        assertThat(burger.price())
                .isEqualTo(6);
    }

    @Test
    public void baconCheeseburgerCost8() throws Exception {
        Burger burger = new Burger();

        burger.addTopping(BurgerTopping.BACON, 1);
        burger.addTopping(BurgerTopping.CHEESE, 1);

        assertThat(burger.price())
                .isEqualTo(8);
    }

    @Test
    public void doubleCheeseBurgerCost7() throws Exception {
        Burger burger = new Burger();

        burger.addTopping(BurgerTopping.CHEESE, 2);

        assertThat(burger.price())
                .isEqualTo(7);
    }
}