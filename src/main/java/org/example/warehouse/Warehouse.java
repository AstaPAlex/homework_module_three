package org.example.warehouse;

import java.util.*;
import lombok.Getter;
import lombok.ToString;
import org.example.product.Product;
import org.springframework.stereotype.Component;


@Getter
@Component
@ToString(exclude = "workers")
public class Warehouse {
    private final Map<String, List<Product>> products = new HashMap<>();
    private final Set<Worker> workers = new HashSet<>();

    public <T extends Product> void acceptProduct(List<T> dequeProducts) {
        ArrayDeque<Product> queue = new ArrayDeque<>(dequeProducts);
        unloadProducts(queue);
    }

    public void addWorker(Worker worker) {
        workers.add(worker);
    }

    private void unloadProducts(Queue<Product> queue) {
        while (queue.peek() != null) {
            unloadingWorkers(queue);
        }
    }

    private void unloadingWorkers(Queue<Product> queue) {
        for (Worker worker : workers) {
            Product product = queue.poll();
            if (product == null) {
                return;
            }
            worker.acceptItem(product);
            addProducts(product);
        }
    }

    private void addProducts(Product product) {
        if (!products.containsKey(product.getName())) {
            products.put(product.getName(), new ArrayList<>());
        }
        products.get(product.getName()).add(product);
    }

    public void giveProduct(Boolean isBroken, String name) {
        List<Product> productsTaken = products.get(name).stream()
                .filter(product -> isBroken.equals(product.getIsBroken()))
                .toList();
        products.get(name).removeAll(productsTaken);
    }

}
