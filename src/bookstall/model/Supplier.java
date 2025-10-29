package bookstall.model;

/**
 * Model class for a Supplier, mirroring the Suppliers SQL table structure.
 */
public class Supplier {
    private String supplierId;
    private String name; // Contact Person Name
    private String email;
    private String phone; // Changed int to String
    private String companyName;
    private String address;

    public Supplier(String supplierId, String name, String email, String phone, String companyName, String address) {
        this.supplierId = supplierId;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.companyName = companyName;
        this.address = address;
    }

    public Supplier() {
    }

    // Standard getters and setters

    public String getSupplierId() { return supplierId; }
    public void setSupplierId(String supplierId) { this.supplierId = supplierId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getCompanyName() { return companyName; }
    public void setCompanyName(String companyName) { this.companyName = companyName; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
}
