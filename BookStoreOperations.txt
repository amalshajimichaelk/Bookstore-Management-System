1) searchBooks() : method is used to search books.
        search by author_name.
        search by title.
        search by isbn.
        search by publisher_name.
        search by release year.
        search by  keyword.
        *note:using a single text field and 'LIKE' keyword in java we can search book by author,title,isbn or using any keywords.

2)filterBooks(): method  used to filter books based on customers's  interest.
        filter by genre.(we can choose  different variety  of genre (like action,romance etc) or mixture of two or more genres (like actionn comedy,rom-com,mystery thriller etc ))
        filter by price.
        filter  by newly released books.
        filter  by most viewed/popular books.
        filter by award winning entries.
        filter by  author.
        filter by type of book(comics,philosophy,religious texts,novels,visual novels,etc)
        filter  by year.
        filter by publisher.
         filter by language.
        

3) addBook(): method used to add a new book entry to our database.
    - accept information such as title, author_name, release year, genre, isbn etc.

4) updateBook(): method used to update detail information of book entry.
    - update details such as title of book, author name, release date.
    - additional changes such as price, genre.

5) deleteBook(): method used to delete a book entry from our database.
    - enter the bookid or isbn and the book entry is deleted from the table.

6) calculateLoyaltyPoints(): method used for loyal customers, to calculate their points.
    - depending on their purchases, genre purchased by them we can give them points.
    - we can offer benefits for them depending on their points calculated like discounts for books and sales etc.

7) viewSalesReport(): method used to view information related to sales in the stall.
    - view list of books sold and the details related to them.
    - view sales revenue or profit or total amount of sales for the day.

8) generateReceipts(): method used to generate receipts for the books purchased or rented for the user.
    - view the contents of purchased books or rented books.

9) manageInventory(): method used to keep track of the inventory of books.
    - view the number of books_available, number of books_sold or number of books_rented etc.

10) recordTransaction(): method used to manually record book sales or rentals.
    - enter book title or isbn.
    - enter customer name.
    - enter quantity sold or rented.
    - enter price and payment mode (cash).
    - enter date of transaction.
    - store transaction in sales table.

11) returnBook(): method used to mark rented books as returned.
    - enter rental ID or book ID.
    - update status to 'returned'.
    - calculate late fee if applicable.
    - update inventory count.

12) viewCustomerHistory(): method used to view transaction history of a customer.
    - enter customer name or ID.
    - view list of books purchased or rented.
    - view total amount spent.
    - view loyalty points earned.

13) applyDiscount(): method used to apply discounts during purchase.
    - enter discount percentage or fixed amount.
    - apply based on customer loyalty or promotional offer.
    - update final price in transaction.

14) searchTransactions(): method used to search past transactions.
    - search by customer name.
    - search by book title or isbn.
    - search by date range.
    - view transaction details.

15) generateDailyReport(): method used to generate daily summary of sales.
    - view total books sold.
    - view total revenue.
    - view total rentals.
    - export report if needed.

16) manageCustomer(): method used to add or update customer details.
    - add new customer with name, contact info.
    - update existing customer details.
    - delete customer entry if needed.

17) trackRentalDue(): method used to track books that are due for return.
    - view list of rented books with due dates.
    - highlight overdue rentals.
    - notify staff for follow-up.

18) exportData(): method used to export book or transaction data.
    - export book list to CSV or PDF.
    - export sales report.
    - export customer history.

19) importBooks(): method used to bulk import book entries.
    - upload CSV file with book details.
    - validate and insert into database.
    - show summary of imported records.

20) viewInventoryStatus(): method used to monitor stock levels.
    - view available quantity of each book.
    - view books with low stock.
    - view books out of stock.


