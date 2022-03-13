package com.welltestedlearning.mealkiosk;

public class ChickenSandwich implements MenuItem {
    private boolean spicy = true;

    public ChickenSandwich() {
    }

    public ChickenSandwich(boolean spicy) {
        this.spicy = spicy;
    }

    @Override
    public int price() {
        return 6;
    }

    @Override
    public void display() {

    }

    public boolean isSpicy() {
        return spicy;
    }
}
