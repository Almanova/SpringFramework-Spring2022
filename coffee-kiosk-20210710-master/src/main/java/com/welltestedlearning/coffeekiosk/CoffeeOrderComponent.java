package com.welltestedlearning.coffeekiosk;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CoffeeOrderComponent {

    @Autowired
    public CoffeeOrderComponent(CoffeeOrderController coffeeOrderController) {
        System.out.println();
        System.out.println(coffeeOrderController.getClass().getName() + " has been instantiated.");
        System.out.println("CoffeeOrderComponent with @Component has been instantiated.");
        System.out.println();
    }

}
