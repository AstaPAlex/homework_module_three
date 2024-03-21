package org.example.warehouse;

import lombok.*;
import org.example.product.Product;

@RequiredArgsConstructor
@Setter
public class Worker {
    @NonNull
    private final String name;
    private boolean shouldBreak = false;

    public void acceptItem(Product product) {
        if (shouldBreak) {
            product.setIsBroken(true);
            shouldBreak = false;
        } else {
            shouldBreak = true;
        }
    }



}
