package pl.jkanclerz.ecommerce.catalog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class CatalogConfiguration {

    @Bean
    ProductCatalog createMyCatalog(ProductStorage productStorage) {
        ProductCatalog productCatalog = new ProductCatalog(productStorage);

        productCatalog.addProduct("Nice One 1", "nice product");
        productCatalog.addProduct("Nice One 2", "nice product");
        productCatalog.addProduct("Nice One 3", "nice product");

        return productCatalog;
    }

    @Bean
    ProductStorage createArrayProductStorage() {
        return new ArrayListProductStorage();
    }


    ProductStorage createSqlStorage(JdbcTemplate jdbcTemplate) {
        return new SqlProductStorage(jdbcTemplate);
    }
}

