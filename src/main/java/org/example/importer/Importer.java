package org.example.importer;

import lombok.Data;
import lombok.NonNull;
import org.example.warehouse.Warehouse;

@Data
public abstract class Importer {
    @NonNull
    protected Warehouse warehouse;

    public abstract void deliverProduct(int count);

}
