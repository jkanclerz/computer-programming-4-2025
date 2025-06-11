package pl.jkanclerz.ecommerce.payu;

public class OrderCreateResponse {
    Status status;
    String redirectUri;
    String orderId;
    String extOrderId;

    public String getOrderId() {
        return orderId;
    }

    public String redirectUri() {
        return redirectUri;
    }

    public Status getStatus() {
        return status;
    }

    public OrderCreateResponse setStatus(Status status) {
        this.status = status;
        return this;
    }

    public String getRedirectUri() {
        return redirectUri;
    }

    public OrderCreateResponse setRedirectUri(String redirectUri) {
        this.redirectUri = redirectUri;
        return this;
    }

    public OrderCreateResponse setOrderId(String orderId) {
        this.orderId = orderId;
        return this;
    }

    public String getExtOrderId() {
        return extOrderId;
    }

    public OrderCreateResponse setExtOrderId(String extOrderId) {
        this.extOrderId = extOrderId;
        return this;
    }
}
