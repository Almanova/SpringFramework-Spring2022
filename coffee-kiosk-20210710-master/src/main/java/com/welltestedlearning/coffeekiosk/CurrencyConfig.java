package com.welltestedlearning.coffeekiosk;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@ConfigurationProperties(prefix = "currency")
@Validated
@ConstructorBinding
public class CurrencyConfig {
    @NotBlank
    final private String uriTemplate;

    public CurrencyConfig(String uriTemplate) {
        this.uriTemplate = uriTemplate;
    }

    public String getUriTemplate() {
        return uriTemplate;
    }
}
