package org.example.importer;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.example.product.VodkaProduct;
import org.example.warehouse.Warehouse;
import org.springframework.stereotype.Component;


@Component
public class AbsoluteImporter extends Importer {

    public AbsoluteImporter(Warehouse warehouse) {
        super(warehouse);
    }

    private List<VodkaProduct> produceVodka(int count) {
        return Stream.generate(VodkaProduct::new)
                .limit(count)
                .collect(Collectors.toList());
    }

    @Override
    public void deliverProduct(int count) {
        warehouse.acceptProduct(produceVodka(count));
    }

}
