package org.example.product;

import lombok.Data;
import lombok.NonNull;

@Data
public abstract class Product {
    @NonNull
    protected final String name;
    protected Boolean isBroken = false;

}
