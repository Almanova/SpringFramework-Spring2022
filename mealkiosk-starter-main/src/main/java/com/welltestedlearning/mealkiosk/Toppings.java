package com.welltestedlearning.mealkiosk;

import java.util.HashMap;
import java.util.Map;

public class Toppings implements MenuItem {
    private Map<BurgerTopping, Integer> toppings = new HashMap<>();

    public Toppings() {
    }

    public void add(BurgerTopping topping, int cnt) {
        this.toppings.put(topping, toppings.get(topping) != null ?
                toppings.get(topping) + cnt : cnt);
    }

    @Override
    public int price() {
        if (toppings.size() == 0)
            return 0;
        return toppings.entrySet().stream()
                .mapToInt(topping ->
                        topping.getKey().price() * topping.getValue())
                .sum();
    }

    @Override
    public void display() {
        System.out.println("Toppings: " + toppings);
    }

    @Override
    public String toString() {
        return "Toppings{" +
                "toppings=" + toppings +
                '}';
    }
}
