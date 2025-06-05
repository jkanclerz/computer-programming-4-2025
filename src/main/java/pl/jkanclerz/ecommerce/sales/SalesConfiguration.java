package pl.jkanclerz.ecommerce.sales;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SalesConfiguration {
    @Bean
    SalesFacade createSales() {
        return new SalesFacade();
    }
}
