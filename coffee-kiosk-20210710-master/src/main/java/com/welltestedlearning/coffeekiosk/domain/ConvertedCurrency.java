package com.welltestedlearning.coffeekiosk.domain;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ConvertedCurrency {
    private String currency;
    private BigDecimal converted;
}
