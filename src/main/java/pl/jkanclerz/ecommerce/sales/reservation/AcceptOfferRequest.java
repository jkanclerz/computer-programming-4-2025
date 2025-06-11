package pl.jkanclerz.ecommerce.sales.reservation;

public class AcceptOfferRequest {
    private String fname;
    private String lname;
    private String email;

    public String getFname() {
        return fname;
    }

    public AcceptOfferRequest setFname(String fname) {
        this.fname = fname;
        return this;
    }

    public String getLname() {
        return lname;
    }

    public AcceptOfferRequest setLname(String lname) {
        this.lname = lname;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public AcceptOfferRequest setEmail(String email) {
        this.email = email;
        return this;
    }
}
