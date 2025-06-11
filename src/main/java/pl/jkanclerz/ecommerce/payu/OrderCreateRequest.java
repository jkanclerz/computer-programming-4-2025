package pl.jkanclerz.ecommerce.payu;

import java.util.List;

public class OrderCreateRequest {
    String notifyUrl;
    String customerIp;
    String merchantPosId;
    String description;
    String currencyCode;
    Integer totalAmount;
    String extOrderId;
    Buyer buyer;
    List<Product> products;

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public OrderCreateRequest setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
        return this;
    }

    public String getCustomerIp() {
        return customerIp;
    }

    public OrderCreateRequest setCustomerIp(String customerIp) {
        this.customerIp = customerIp;
        return this;
    }

    public String getMerchantPosId() {
        return merchantPosId;
    }

    public OrderCreateRequest setMerchantPosId(String merchantPosId) {
        this.merchantPosId = merchantPosId;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public OrderCreateRequest setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public OrderCreateRequest setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
        return this;
    }

    public Integer getTotalAmount() {
        return totalAmount;
    }

    public OrderCreateRequest setTotalAmount(Integer totalAmount) {
        this.totalAmount = totalAmount;
        return this;
    }

    public String getExtOrderId() {
        return extOrderId;
    }

    public OrderCreateRequest setExtOrderId(String extOrderId) {
        this.extOrderId = extOrderId;
        return this;
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public OrderCreateRequest setBuyer(Buyer buyer) {
        this.buyer = buyer;
        return this;
    }

    public List<Product> getProducts() {
        return products;
    }

    public OrderCreateRequest setProducts(List<Product> products) {
        this.products = products;
        return this;
    }

    //    "notifyUrl": "https://your.eshop.com/notify",
//            "customerIp": "127.0.0.1",
//            "merchantPosId": "300746",
//            "description": "RTV market",
//            "currencyCode": "PLN",
//            "totalAmount": "21000",
//            "extOrderId":"2uikc6gjd99b4lxc75ip4k",
//            "buyer": {
        //        "email": "john.doe@example.com",
        //                "phone": "654111654",
        //                "firstName": "John",
        //                "lastName": "Doe",
        //                "language": "pl"
//    },
//            "products": [
//    {
//        "name": "Wireless Mouse for Laptop",
//            "unitPrice": "15000",
//            "quantity": "1"
//    },
//    {
//        "name": "HDMI cable",
//            "unitPrice": "6000",
//            "quantity": "1"
//    }
//        ]

}
