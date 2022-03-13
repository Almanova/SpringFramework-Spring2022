package com.welltestedlearning.mealkiosk;

import java.util.Scanner;

public class MealKioskConsole {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("What toppings do you want on your Burger? none, cheese, bacon, avocado");
            String input = scanner.nextLine().toLowerCase();

            Burger burger = new Burger();
            if (input.contains("cheese"))
                burger.addTopping(BurgerTopping.CHEESE, 1);
            if (input.contains("bacon"))
                burger.addTopping(BurgerTopping.BACON, 1);
            if (input.contains("avocado"))
                burger.addTopping(BurgerTopping.AVOCADO, 1);

            System.out.println("What size of the drink would you like to add? regular, large");
            input = scanner.nextLine().toLowerCase();

            Drink drink = new Drink(input);

            MealOrder mealOrder = new MealOrder();
            mealOrder.addItem(drink);
            mealOrder.addItem(burger);
            mealOrder.display();
        }
    }
}
