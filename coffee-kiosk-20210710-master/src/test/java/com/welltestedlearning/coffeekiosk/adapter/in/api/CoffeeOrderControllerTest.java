package com.welltestedlearning.coffeekiosk.adapter.in.api;


import com.welltestedlearning.coffeekiosk.adapter.out.currency.StubCurrencyConversionService;
import com.welltestedlearning.coffeekiosk.domain.CoffeeOrder;
import com.welltestedlearning.coffeekiosk.domain.CoffeeOrderRepository;
import com.welltestedlearning.coffeekiosk.domain.InMemoryCoffeeOrderRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.*;

@WebMvcTest(CoffeeMenuController.class)
public class CoffeeOrderControllerTest {
    @Test
    public void getWithPoundQueryParamConvertsPriceToPounds() throws Exception {
        CoffeeOrderRepository coffeeOrderRepository = new InMemoryCoffeeOrderRepository();
        CoffeeOrder coffeeOrder = new CoffeeOrder("Spring", LocalDateTime.now());

        coffeeOrder.setId(12L);
        coffeeOrderRepository.save(coffeeOrder);
        CoffeeOrderController controller = new CoffeeOrderController(coffeeOrderRepository,
                new StubCurrencyConversionService());

        CoffeeOrderResponse response = controller.coffeeOrder(coffeeOrder.getId(), "gbp").getBody();
        assertThat(response.getTotalPrice())
            .isEqualTo("1234");
    }
}
