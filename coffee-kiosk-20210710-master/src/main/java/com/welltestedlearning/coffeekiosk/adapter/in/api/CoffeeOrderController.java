package com.welltestedlearning.coffeekiosk.adapter.in.api;

import com.welltestedlearning.coffeekiosk.domain.CoffeeItem;
import com.welltestedlearning.coffeekiosk.domain.CoffeeItemResponse;
import com.welltestedlearning.coffeekiosk.domain.CoffeeOrder;
import com.welltestedlearning.coffeekiosk.domain.CoffeeOrderRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.Optional;

@RestController
public class CoffeeOrderController {
    private final CoffeeOrderRepository coffeeOrderRepository;

    @Value("${order.price.currency.prefix}")
    private String currencyPrefix;

    public CoffeeOrderController(CoffeeOrderRepository coffeeOrderRepository) {
        this.coffeeOrderRepository = coffeeOrderRepository;
    }

    @GetMapping("/api/coffee/orders/{id}")
    public ResponseEntity<CoffeeOrderResponse> coffeeOrder(@PathVariable("id") long orderId) {
        if (orderId < 0)
            throw new IllegalArgumentException();
        Optional<CoffeeOrder> coffeeOrderOptional = coffeeOrderRepository.findById(orderId);
        return coffeeOrderOptional.map(coffeeOrder -> ResponseEntity
                .ok(CoffeeOrderResponse.from(coffeeOrder, currencyPrefix)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("api/coffee/orders")
    public ResponseEntity createCoffeeOrder(@RequestBody CoffeeOrderRequest coffeeOrderRequest) {
        CoffeeOrder coffeeOrder = new CoffeeOrder(coffeeOrderRequest.getCustomerName(),
                LocalDateTime.of(2022, 4, 5, 12, 13));
        CoffeeItem coffeeItem = new CoffeeItem(coffeeOrderRequest.getSize(), coffeeOrderRequest.getKind(),
                coffeeOrderRequest.getCreamer());
        coffeeOrder.add(coffeeItem);
        CoffeeOrder savedCoffeeOrder = coffeeOrderRepository.save(coffeeOrder);
        return ResponseEntity.created(
                URI.create("/api/coffee/orders/" + savedCoffeeOrder.getId()))
                .build();
    }
}
