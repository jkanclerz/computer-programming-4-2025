package pl.jkanclerz.ecommerce.payu;

public class PayUCredentials {
    String clientId;
    String clientSecret;
    boolean sandbox;

    public PayUCredentials(String clientId, String clientSecret, boolean sandbox) {
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.sandbox = sandbox;
    }

    public static PayUCredentials sandbox(String clientId, String clientSecret) {
        return new PayUCredentials(clientId, clientSecret, true);
    }

    public String getClientId() {
        return clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public String getBaseUrl() {
        if (sandbox) {
            return "https://secure.snd.payu.com";
        } else {
            return "https://secure.payu.com";
        }
    }
}
