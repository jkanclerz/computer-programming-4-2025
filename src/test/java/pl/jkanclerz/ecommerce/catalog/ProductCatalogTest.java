package pl.jkanclerz.ecommerce.catalog;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ProductCatalogTest {

    @Test
    void itListAvailableProducts() {
        ProductCatalog catalog = thereIsProductCatalog();

        List<Product> products = catalog.allProducts();

        assert products.isEmpty();
    }



    @Test
    void itAllowsToAddProduct() {
        ProductCatalog catalog = thereIsProductCatalog();

        catalog.addProduct("Lego set 8083", "Nice one");
        List<Product> products = catalog.allProducts();

        assertThat(products)
                .hasSize(1);
    }

    @Test
    void itLoadsSingleProductById() {
        ProductCatalog catalog = thereIsProductCatalog();
        String id = catalog.addProduct("Lego set 8083", "Nice one");

        Product loaded = catalog.getProductBy(id);

        assertThat(id).isEqualTo(loaded.getId());
    }

    @Test
    void itAllowsChangePrice() {
        ProductCatalog catalog = thereIsProductCatalog();
        String id = catalog.addProduct("Lego set 8083", "Nice one");

        catalog.changePrice(id, BigDecimal.valueOf(10.10));
        Product loaded = catalog.getProductBy(id);

        assertThat(BigDecimal.valueOf(10.10)).isEqualTo(loaded.getPrice());
    }

    private static ProductCatalog thereIsProductCatalog() {
        return new ProductCatalog(new ArrayListProductStorage());
    }
}
