package pl.jkanclerz.ecommerce.sales.reservation;

public class CustomerDetails {
    private final String customerId;
    private final String firstName;
    private final String lastName;
    private final String email;

    public CustomerDetails(String customerId, String firstName, String lastName, String email) {

        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }
}
