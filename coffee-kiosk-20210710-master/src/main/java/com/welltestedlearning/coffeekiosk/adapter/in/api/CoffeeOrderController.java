package com.welltestedlearning.coffeekiosk.adapter.in.api;

import com.welltestedlearning.coffeekiosk.domain.CoffeeItem;
import com.welltestedlearning.coffeekiosk.domain.CoffeeItemResponse;
import com.welltestedlearning.coffeekiosk.domain.CoffeeOrder;
import com.welltestedlearning.coffeekiosk.domain.CoffeeOrderRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Optional;

@RestController
public class CoffeeOrderController {
    private final CoffeeOrderRepository coffeeOrderRepository;

    public CoffeeOrderController(CoffeeOrderRepository coffeeOrderRepository) {
        this.coffeeOrderRepository = coffeeOrderRepository;
    }

    @GetMapping("/api/coffee/orders/{id}")
    public ResponseEntity<CoffeeOrderResponse> coffeeOrder(@PathVariable("id") long orderId) {
        if (orderId < 0)
            throw new IllegalArgumentException();
        Optional<CoffeeOrder> coffeeOrderOptional = coffeeOrderRepository.findById(orderId);
        return coffeeOrderOptional.map(coffeeOrder -> ResponseEntity
                .ok(CoffeeOrderResponse.from(coffeeOrder))).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
