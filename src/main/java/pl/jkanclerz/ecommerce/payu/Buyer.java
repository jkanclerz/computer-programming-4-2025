package pl.jkanclerz.ecommerce.payu;

public class Buyer {
    String email;
    String phone;
    String firstName;
    String lastName;
    String language;

    public String getEmail() {
        return email;
    }

    public Buyer setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public Buyer setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public Buyer setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public Buyer setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getLanguage() {
        return language;
    }

    public Buyer setLanguage(String language) {
        this.language = language;
        return this;
    }

    //     "email": "john.doe@example.com",
    //                "phone": "654111654",
    //                "firstName": "John",
    //                "lastName": "Doe",
    //                "language": "pl"
}
