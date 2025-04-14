package pl.jkanclerz.ecommerce.catalog;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public class ProductCatalog {

    private final ProductStorage productStorage;

    public ProductCatalog(ProductStorage productStorage) {
        this.productStorage = productStorage;
    }

    public List<Product> allProducts() {
        return productStorage.allProducts();
    }

    public String addProduct(String name, String description) {
        UUID id = UUID.randomUUID();
        Product newProduct = new Product(id, name, description);
        productStorage.add(newProduct);

        return newProduct.getId();
    }

    public Product getProductBy(String id) {
        return productStorage.getProductBy(id);
    }

    public void changePrice(String id, BigDecimal newPrice) {
        Product loaded = productStorage.getProductBy(id);
        loaded.changePrice(newPrice);
    }
}
