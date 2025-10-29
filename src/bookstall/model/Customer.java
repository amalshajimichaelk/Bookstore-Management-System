package bookstall.model;

/**
 * Model class for a Customer, mirroring the Customers SQL table structure.
 */
public class Customer {
    private String customerId;
    private String name;
    private String email;
    private String phone; // Changed int to String to avoid leading zero issues and handle formatting
    private String address;

    public Customer(String customerId, String name, String email, String phone, String address) {
        this.customerId = customerId;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    public Customer() {
    }

    // Standard getters and setters

    public String getCustomerId() { return customerId; }
    public void setCustomerId(String customerId) { this.customerId = customerId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
}
