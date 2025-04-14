package pl.jkanclerz.ecommerce.catalog;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArrayListProductStorage implements ProductStorage {
    private ArrayList<Product> products;

    public ArrayListProductStorage() {
        this.products = new ArrayList<>();
    }

    @Override
    public List<Product> allProducts() {
        return Collections.unmodifiableList(products);
    }

    @Override
    public void add(Product product) {
        products.add(product);
    }

    @Override
    public Product getProductBy(String id) {
        return products.stream()
                .filter(product -> product.getId().equals(id))
                .findFirst()
                .get();
    }
}
