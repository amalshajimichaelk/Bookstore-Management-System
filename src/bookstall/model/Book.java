package bookstall.model;

/**
 * Model class for a Book, mirroring the Books SQL table structure.
 */
public class Book {
    private String bookId;
    private String isbn;
    private String title;
    private String author;
    private String publisher;
    private double price;
    private int quantity;
    private String genre;
    private String language;
    
    // Constructor (using all fields for full representation)
    public Book(String bookId, String isbn, String title, String author, String publisher, double price, int quantity, String genre, String language) {
        this.bookId = bookId;
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.price = price;
        this.quantity = quantity;
        this.genre = genre;
        this.language = language;
    }

    // Default constructor for creating new instances
    public Book() {
    }

    // Standard getters and setters

    public String getBookId() { return bookId; }
    public void setBookId(String bookId) { this.bookId = bookId; }

    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) { this.isbn = isbn; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    public String getPublisher() { return publisher; }
    public void setPublisher(String publisher) { this.publisher = publisher; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public String getGenre() { return genre; }
    public void setGenre(String genre) { this.genre = genre; }

    public String getLanguage() { return language; }
    public void setLanguage(String language) { this.language = language; }
}
