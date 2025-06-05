package pl.jkanclerz.ecommerce.sales;

public class SalesFacade {
    public Offer getCurrentOffer(String customerId) {
        return new Offer();
    }

    public void addProduct(String customerId, String productId) {

    }

    public ReservationDetails acceptOffer(String customerId, AcceptOfferRequest acceptOfferRequest) {
        return new ReservationDetails();
    }
}
