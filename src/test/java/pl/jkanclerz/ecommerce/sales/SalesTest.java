package pl.jkanclerz.sales;

import org.junit.jupiter.api.Test;
import pl.jkanclerz.ecommerce.sales.Offer;
import pl.jkanclerz.ecommerce.sales.SalesFacade;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class SalesTest {

    @Test
    void itShowsCurrentOffer() {
        String customerId = thereIsCustomer("Kuba");
        SalesFacade sales = thereIsSales();

        Offer offer = sales.getCurrentOffer(customerId);

        assertThat(offer.getTotal()).isEqualTo(BigDecimal.ZERO);
        assertThat(offer.getItemsCount()).isEqualTo(0);
    }

    @Test
    void itAddsProductToCart() {

    }

    @Test
    void itAcceptCustomersCurrentOffer() {

    }

    @Test
    void itConfirmPayment() {

    }

    private SalesFacade thereIsSales() {
        return new SalesFacade();
    }

    private String thereIsCustomer(String name) {
        return name;
    }
}
