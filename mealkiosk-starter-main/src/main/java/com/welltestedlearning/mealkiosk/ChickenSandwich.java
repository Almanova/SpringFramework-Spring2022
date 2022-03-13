package com.welltestedlearning.mealkiosk;

public class ChickenSandwich implements MenuItem {
    private boolean spicy = true;
    private Toppings toppings = new Toppings();

    public ChickenSandwich() {
    }

    public ChickenSandwich(boolean spicy) {
        this.spicy = spicy;
    }

    public void addTopping(BurgerTopping theBurgerTopping, int cnt) {
        this.toppings.add(theBurgerTopping, cnt);
    }

    @Override
    public int price() {
        return 6 + toppings.price();
    }

    @Override
    public void display() {

    }

    public boolean isSpicy() {
        return spicy;
    }
}
