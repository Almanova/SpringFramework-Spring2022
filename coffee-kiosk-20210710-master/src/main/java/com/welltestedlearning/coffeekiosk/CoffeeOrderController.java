package com.welltestedlearning.coffeekiosk;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class CoffeeOrderController {

    @Autowired
    public CoffeeOrderController(CoffeeOrderService coffeeOrderService) {
        System.out.println();
        System.out.println(this.getClass().getName() + " has been instantiated.");
        System.out.println(" --> Was passed a reference to a dependency: " + coffeeOrderService);
        System.out.println();
    }
}
