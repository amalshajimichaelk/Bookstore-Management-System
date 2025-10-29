package bookstall.model;

import java.sql.Timestamp;

/**
 * Model class for a Transaction, mirroring the Transactions SQL table structure.
 */
public class Transaction {
    private String transactionId;
    private String customerId;
    private String bookId;
    private int quantity;
    private double totalAmount;
    private Timestamp dateTime;

    public Transaction(String transactionId, String customerId, String bookId, int quantity, double totalAmount, Timestamp dateTime) {
        this.transactionId = transactionId;
        this.customerId = customerId;
        this.bookId = bookId;
        this.quantity = quantity;
        this.totalAmount = totalAmount;
        this.dateTime = dateTime;
    }

    public Transaction() {
    }

    // Standard getters and setters

    public String getTransactionId() { return transactionId; }
    public void setTransactionId(String transactionId) { this.transactionId = transactionId; }

    public String getCustomerId() { return customerId; }
    public void setCustomerId(String customerId) { this.customerId = customerId; }

    public String getBookId() { return bookId; }
    public void setBookId(String bookId) { this.bookId = bookId; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public double getTotalAmount() { return totalAmount; }
    public void setTotalAmount(double totalAmount) { this.totalAmount = totalAmount; }

    public Timestamp getDateTime() { return dateTime; }
    public void setDateTime(Timestamp dateTime) { this.dateTime = dateTime; }
}
