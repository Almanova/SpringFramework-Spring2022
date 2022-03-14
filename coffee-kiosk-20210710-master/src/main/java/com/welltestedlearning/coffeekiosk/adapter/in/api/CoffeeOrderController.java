package com.welltestedlearning.coffeekiosk.adapter.in.api;

import com.welltestedlearning.coffeekiosk.domain.CoffeeItem;
import com.welltestedlearning.coffeekiosk.domain.CoffeeItemResponse;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CoffeeOrderController {

    @GetMapping(value = "/api/coffee/order")
    public CoffeeItemResponse getCoffeeItem() {
        CoffeeItem coffeeItem = new CoffeeItem("small", "latte", "milk");
        coffeeItem.setId(1L);
        return CoffeeItemResponse.from(coffeeItem);
    }
}
