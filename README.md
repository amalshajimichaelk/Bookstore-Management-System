# 📖 Book Store Management System

<p align="center">
  <img src="https://img.shields.io/badge/Java-11%2B-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white" alt="Java 11+">
  <img src="https://img.shields.io/badge/MySQL-8.0%2B-4479A1?style=for-the-badge&logo=mysql&logoColor=white" alt="MySQL 8.0+">
  <img src="https://img.shields.io/badge/Architecture-MVC-blueviolet?style=for-the-badge&logo=designernews&logoColor=white" alt="MVC Architecture">
  <img src="https://img.shields.io/badge/UI-Java%20Swing-blue?style=for-the-badge&logo=java&logoColor=white" alt="Java Swing">
</p>

<p align="center">
  <i>An elegant, database-driven desktop application for managing a complete book store, from inventory to sales.</i>
</p>

---

Welcome to the Book Store Management System, a comprehensive Java Swing application designed to handle all aspects of a modern bookstore. This project is built with a strict **Model-View-Controller (MVC)** architecture, ensuring a clean separation of concerns, high maintainability, and seamless integration with a MySQL database.

## 🧭 Navigation

- [✨ Key Features](#-key-features)
- [🛠️ Tech Stack](#-tech-stack)
- [🏛️ Architecture](#-architecture)
- [🗄️ Database Setup](#-database-setup)
- [🚀 How to Run](#-how-to-run)
- [📂 Project Structure](#-project-structure)
- [📸 Screenshots](#-screenshots)

---

## ✨ Key Features

* **Secure Authentication:** Login system to protect application data.
* **Complete Book Management (CRUD):**
    * **Add:** Easily add new books to the inventory with a unique `bookId`.
    * **Load & Update:** Fetch existing book details by `bookId` and modify any field.
    * **Delete:** Remove books from the database.
* **Advanced Book Search:**
    * Search by Book ID, Title, Author, ISBN, Publisher.
    * "Show All Books" functionality to view the entire inventory.
* **Multi-Criteria Filtering:**
    * Filter search results by **Language**, **Genre**, **Price Range**, and **Availability** (In Stock).
* **Sales & Transactions:**
    * A dedicated "Checkout" module to process sales.
    * Automatically validates stock (`quantity`) before a sale.
    * Updates book quantity and records the sale in the `Transactions` table.
* **Data Views:**
    * **Customer Info:** View a complete list of all customers.
    * **Supplier Info:** View a complete list of all suppliers.
    * **Transaction History:** View a detailed log of all sales.

---


## 🛠️ Tech Stack

| Component | Technology |
| :--- | :--- |
| **Language** | Java 11+ |
| **Database** | MySQL 8.0+ |
| **UI Toolkit** | Java Swing |
| **Database Connector** | MySQL Connector/J (JDBC) |
| **Architecture** | Model-View-Controller (MVC) |

---

## 🏛️ Architecture

This project strictly adheres to the **Model-View-Controller (MVC)** design pattern.

* **Model (`model` package):** Represents the data and business logic. It contains the `DatabaseManager` for all SQL operations and the data-holding classes (`Book`, `User`, `Customer`, etc.).
* **View (`view` package):** The complete user interface. It consists of `LoginPageView` and `MainAppView`, built with Java Swing. It is responsible *only* for displaying data and capturing user input.
* **Controller (`controller` package):** Acts as the intermediary. The `LoginController` and `MainAppController` listen for user actions from the View, process requests (by calling the Model), and update the View with new data.

This separation makes the application robust, easy to debug, and simple to extend with new features.

---

## 🗄️ Database Setup

The entire database schema and sample data are included in a single file.

1.  **Database:** `BookStoreManagementSystem` (as defined in your `DatabaseManager.java`)
2.  **File:** `bookstore_database_setup.sql`
3.  **Tables:**
    * `Users`: Stores login credentials.
    * `Books`: The main inventory table.
    * `Customers`: Stores customer details.
    * `Suppliers`: Stores supplier details.
    * `Transactions`: A log of all sales, linked to `Customers` and `Books`.

To set up your database, simply execute the full `bookstore_database_setup.sql` script in your MySQL client (like MySQL Workbench). It will drop any old tables, create the new schema, and populate all tables with diverse sample data.

---

## 🚀 How to Run

### Prerequisites

1.  **JDK 11+:** Ensure you have the Java Development Kit installed.
2.  **MySQL Server:** Your MySQL database server must be running.
3.  **Database:** The `BookStoreManagementSystem` database must be created and populated using the SQL script.
4.  **MySQL Connector/J:** The `.jar` file (`mysql-connector-j-9.5.0.jar`) must be in the `lib` folder and included in your project's build path/classpath.
5.  **Credentials:** Update the `DB_URL`, `DB_USER`, and `DB_PASSWORD` constants in `bookstall/model/DatabaseManager.java` to match your local MySQL setup.

### Run from an IDE (Recommended)

1.  Open the project in your IDE (Eclipse, IntelliJ IDEA, NetBeans).
2.  Add the `mysql-connector-j-9.5.0.jar` to the project's build path.
3.  Locate `BookStallApp.java` inside the `bookstall` package.
4.  Right-click the file and select "Run As" > "Java Application" (or equivalent).

### Run from Command Line

1.  Open your terminal or command prompt.
2.  Navigate to the project's root directory (the one containing `src` and `lib`).
3.  **Compile:**
    ```bash
    # On Windows
    javac -d bin -cp ".;lib/mysql-connector-j-9.5.0.jar" src/bookstall/*.java src/bookstall/controller/*.java src/bookstall/model/*.java src/bookstall/view/*.java

    # On Linux/macOS
    javac -d bin -cp ".:lib/mysql-connector-j-9.5.0.jar" src/bookstall/*.java src/bookstall/controller/*.java src/bookstall/model/*.java src/bookstall/view/*.java
    ```
4.  **Run:**
    ```bash
    # On Windows
    java -cp ".;bin;lib/mysql-connector-j-9.5.0.jar" bookstall.BookStallApp

    # On Linux/macOS
    java -cp ".:bin:lib/mysql-connector-j-9.5.0.jar" bookstall.BookStallApp
    ```

---

## 📂 Project Structure

```
Book-Store-Management-System/
├── .classpath
├── .project
├── lib/
│   └── mysql-connector-j-9.5.0.jar
├── sql/
│   └── bsms_db.sql
└── src/
    └── bookstall/
        ├── BookStallApp.java
        ├── controller/
        │   ├── LoginController.java
        │   └── MainAppController.java
        ├── model/
        │   ├── AuthModel.java
        │   ├── Book.java
        │   ├── Customer.java
        │   ├── DatabaseManager.java
        │   ├── Supplier.java
        │   ├── Transaction.java
        │   └── User.java
        └── view/
            ├── LoginPageView.java
            └── MainAppView.java
```
                
---

## 📸 Screenshots


| Login Screen | Home Dashboard |
| :---: | :---: |
| <img width="734" height="369" alt="Screenshot 2025-11-01 002211" src="https://github.com/user-attachments/assets/30773922-f0e7-4c73-99e6-e6d7b5d3307d" /> | <img width="1298" height="959" alt="Screenshot 2025-11-01 002540" src="https://github.com/user-attachments/assets/53e25189-059c-4bfb-9d0d-9e32d896fb6d" />|

| Search & Filter Panel | Update Book Panel |
| :---: | :---: |
| <img width="1295" height="960" alt="Screenshot 2025-11-01 002716" src="https://github.com/user-attachments/assets/b86dd88d-0720-43f8-8917-3109229cefa9" /> | <img width="1298" height="962" alt="Screenshot 2025-11-01 003223" src="https://github.com/user-attachments/assets/31260ded-f2f3-46fd-8ac3-edfc51ab9629" />|

| Checkout Panel | Transaction History |
| :---: | :---: |
| <img width="1298" height="955" alt="Screenshot 2025-11-01 003927" src="https://github.com/user-attachments/assets/1b76adbc-2c66-4bf2-bd59-6118e654c8ec" />| <img width="1300" height="962" alt="Screenshot 2025-11-01 003416" src="https://github.com/user-attachments/assets/143decad-d377-48ed-88ca-9a241fd1782d" />|

| Customer Info | Supplier Info  |
| :---: | :---: |
| <img width="1292" height="952" alt="Screenshot 2025-11-01 003459" src="https://github.com/user-attachments/assets/de5506b8-4cda-47b6-8672-22424c02573b" /> | <img width="1301" height="960" alt="Screenshot 2025-11-01 003716" src="https://github.com/user-attachments/assets/d7347e0f-c8c4-4a30-9f6b-b715ef1644e4" /> |


## 👨‍💻 Team Members

| Member | GitHub | Role |
| :---: | :---: | :---: |
| Amal Shaji Michael | <a href="https://github.com/amalshajimichaelk">@amalshajimichaelk</a> | Full Stack Developer & Documentation |
| Dawn K Vinod | <a href="https://github.com/Dawn-K-Vinod">@Dawn-K-Vinod</a> | Team Lead & Tester |
| Noel Shaji | <a href="https://github.com/NoelShaji001">@NoelShaji001</a> | UI Designer |
| Harisankar C R | <a href="https://github.com/Ha4i606">@Ha4i606</a> | Database Designer |
