package com.welltestedlearning.mealkiosk;

public class Burger implements MenuItem {

    private Toppings toppings = new Toppings();

    public Burger() {
    }

    public Burger(BurgerTopping theBurgerTopping, int cnt) {
        this.toppings.add(theBurgerTopping, cnt);
    }

    public void addTopping(BurgerTopping theBurgerTopping, int cnt) {
        this.toppings.add(theBurgerTopping, cnt);
    }

    @Override
    public int price() {
        return 5 + toppings.price();
    }

    public void display() {
        System.out.println("Burger: " + toppings);
    }

    @Override
    public String toString() {
        return "Burger {" +
                "burgerOption=" + toppings +
                '}';
    }
}
