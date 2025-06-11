package pl.jkanclerz.ecommerce.sales;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.jkanclerz.ecommerce.sales.cart.HashMapCartStorage;
import pl.jkanclerz.ecommerce.sales.offering.OfferCalculator;
import pl.jkanclerz.ecommerce.sales.payment.PaymentDetails;
import pl.jkanclerz.ecommerce.sales.payment.RegisterPaymentRequest;
import pl.jkanclerz.ecommerce.sales.reservation.ReservationRepository;

@Configuration
public class SalesConfiguration {
    @Bean
    SalesFacade createSales() {
        return new SalesFacade(
                new HashMapCartStorage(),
                new OfferCalculator(),
                (RegisterPaymentRequest request) -> {
                    return new PaymentDetails("http://payment");
                },
                new ReservationRepository()
        );
    }

}
