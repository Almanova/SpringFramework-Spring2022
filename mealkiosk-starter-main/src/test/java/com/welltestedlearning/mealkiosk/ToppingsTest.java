package com.welltestedlearning.mealkiosk;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ToppingsTest {

    @Test
    public void noToppingsIsZeroPrice() {
        Toppings toppings = new Toppings();
        assertThat(toppings.price()).isZero();
    }

    @Test
    public void baconAndCheeseCosts3() {
        Toppings toppings = new Toppings();
        toppings.add(BurgerTopping.CHEESE, 1);
        toppings.add(BurgerTopping.BACON, 1);
        assertThat(toppings.price())
                .isEqualTo(3);
    }
}
