package org.example.shopper;

import org.example.warehouse.Warehouse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ShopperConfig {

    @Bean
    public Shopper shopper1(Warehouse warehouse) {
        return new Shopper("Петрович", warehouse);
    }

    @Bean
    public Shopper shopper2(Warehouse warehouse) {
        return new Shopper("Решар", warehouse);
    }

}
