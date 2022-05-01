package com.welltestedlearning.coffeekiosk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com"})
@ConfigurationPropertiesScan
public class CoffeeKioskApplication {

    public static void main(String[] args) {
        SpringApplication.run(CoffeeKioskApplication.class, args);
    }

}
