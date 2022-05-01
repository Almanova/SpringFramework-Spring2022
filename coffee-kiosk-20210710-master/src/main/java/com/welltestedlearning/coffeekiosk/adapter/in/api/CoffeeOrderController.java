package com.welltestedlearning.coffeekiosk.adapter.in.api;

import com.welltestedlearning.coffeekiosk.adapter.out.currency.StubCurrencyConversionService;
import com.welltestedlearning.coffeekiosk.domain.*;
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
    private final CurrencyConversionService currencyConversionService;

    @Value("${order.price.currency.prefix}")
    private String currencyPrefix;

    public CoffeeOrderController(CoffeeOrderRepository coffeeOrderRepository,
                                 CurrencyConversionService currencyConversionService) {
        this.coffeeOrderRepository = coffeeOrderRepository;
        this.currencyConversionService = currencyConversionService;
    }

    @GetMapping("/api/coffee/orders/{id}")
    public ResponseEntity<CoffeeOrderResponse> coffeeOrder(@PathVariable("id") long orderId,
                                                           @RequestParam(value = "currency", defaultValue = "usd") String currency) {
        if (orderId < 0)
            throw new IllegalArgumentException();
        Optional<CoffeeOrder> coffeeOrderOptional = coffeeOrderRepository.findById(orderId);
        CoffeeOrder coffeeOrder = null;
        if (coffeeOrderOptional.isPresent())
            coffeeOrder = coffeeOrderOptional.get();
        else
            return ResponseEntity.notFound().build();

        CoffeeOrderResponse coffeeOrderResponse = CoffeeOrderResponse.from(coffeeOrder, currencyPrefix);
        if (currency.equals("gbp"))
            coffeeOrderResponse.setTotalPrice(Integer.toString(currencyConversionService.convertToBritishPound(
                    coffeeOrder.totalPrice())));

        return ResponseEntity
                .ok(coffeeOrderResponse);
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
