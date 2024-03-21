package org.example.importer;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.example.product.BicycleProduct;
import org.example.warehouse.Warehouse;
import org.springframework.stereotype.Component;

@Component
public class StorkImporter extends Importer {

    public StorkImporter(Warehouse warehouse) {
        super(warehouse);
    }

    public List<BicycleProduct> produceBicycle(int count) {
        return Stream.generate(BicycleProduct::new)
                .limit(count)
                .collect(Collectors.toList());
    }

    @Override
    public void deliverProduct(int count) {
        warehouse.acceptProduct(produceBicycle(count));
    }
}
