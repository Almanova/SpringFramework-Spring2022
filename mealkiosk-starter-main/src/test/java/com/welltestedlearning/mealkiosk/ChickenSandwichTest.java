package com.welltestedlearning.mealkiosk;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ChickenSandwichTest {

    @Test
    public void sandwichWithNoToppingsCost6() {
        ChickenSandwich chickenSandwich = new ChickenSandwich();

        assertThat(chickenSandwich.price())
                .isEqualTo(6);
    }
}
