package org.example.shopper;

import lombok.Value;
import org.example.warehouse.Warehouse;

@Value
public class Shopper {
    String name;
    Warehouse warehouse;

    public void getProducts(Boolean isBroken, String name) {
        warehouse.giveProduct(isBroken, name);
    }
}
