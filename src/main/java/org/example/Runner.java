package org.example;

import org.example.importer.AbsoluteImporter;
import org.example.importer.Importer;
import org.example.importer.StorkImporter;
import org.example.shopper.Shopper;
import org.example.warehouse.Warehouse;
import org.example.warehouse.Worker;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Runner {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("org.example");
        Warehouse warehouse = context.getBean(Warehouse.class);
        warehouse.addWorker(new Worker("Миша"));
        warehouse.addWorker(new Worker("Зеля"));
        Importer absoluteImporter = context.getBean(AbsoluteImporter.class);
        Importer storkImporter = context.getBean(StorkImporter.class);
        absoluteImporter.deliverProduct(3);
        storkImporter.deliverProduct(3);
        Shopper shopperPetrovish = (Shopper) context.getBean("shopper1");
        Shopper shopperReshar = (Shopper) context.getBean("shopper2");
        shopperPetrovish.getProducts(true, "Водка");
        shopperReshar.getProducts(false, "Велосипед");
        System.out.println(warehouse);
    }
}
