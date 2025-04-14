package pl.jkanclerz.ecommerce.catalog;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ProductCatalog {

    private ArrayList<Product> products;

    public ProductCatalog() {
        this.products = new ArrayList<>();
    }

    public List<Product> allProducts() {
        return products;
    }

    public String addProduct(String name, String description) {
        UUID id = UUID.randomUUID();
        Product newProduct = new Product(id, name, description);

        products.add(newProduct);

        return newProduct.getId();
    }

    public Product getProductBy(String id) {
        return products.stream()
                .filter(product -> product.getId().equals(id))
                .findFirst()
                .get();
    }

    public void changePrice(String id, BigDecimal newPrice) {
        Product loaded = this.getProductBy(id);
        loaded.changePrice(newPrice);
    }
}
