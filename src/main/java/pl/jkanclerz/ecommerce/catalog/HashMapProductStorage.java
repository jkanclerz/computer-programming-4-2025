package pl.jkanclerz.ecommerce.catalog;

import java.util.HashMap;
import java.util.List;

public class HashMapProductStorage implements ProductStorage {

    HashMap<String, Product> productHashMap;

    public HashMapProductStorage() {
        this.productHashMap = new HashMap<>();
    }

    @Override
    public List<Product> allProducts() {
        return productHashMap.values().stream().toList();
    }

    @Override
    public void add(Product product) {
        productHashMap.put(product.getId(), product);
    }

    @Override
    public Product getProductBy(String id) {
        return productHashMap.get(id);
    }
}
