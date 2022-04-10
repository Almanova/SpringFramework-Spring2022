package com.welltestedlearning.mealkiosk;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class MealOrderApiController {

    @PostMapping(value = "/api/mealorder", consumes = MediaType.APPLICATION_JSON_VALUE)
    public MealOrderResponse mealOrder(@RequestBody MealOrderRequest mealOrderRequest) {
        String mealOrderText = mealOrderRequest.getBurger();
        MealBuilder mealBuilder = new MealBuilder();
        mealBuilder.addBurgerString(mealOrderText);
        MealOrder order = mealBuilder.build();
        int price = order.price();

        MealOrderResponse mealOrderResponse = new MealOrderResponse();
        mealOrderResponse.setPrice(price);
        return mealOrderResponse;
    }
}
