# 📚 Library Book Borrowing System – Spring Boot CRUD Project

**Description:**  
A simple and clean Spring Boot CRUD application that demonstrates how users can borrow and return books from a library.  
This project showcases RESTful APIs, layered architecture, JPA/Hibernate mappings, and relational database design.

---

## ✅ Features

- CRUD operations for **Books**
- CRUD operations for **Users**
- Create and manage **Borrow Records**
- Prevent users from borrowing unavailable books
- Automatically update book availability on borrow/return

### 📌 Structured Project Using:
- Controllers  
- Services  
- Repositories  
- Entities / Models  

---

## 🛠 Tech Stack

- **Java 17+**
- **Spring Boot 3+**
- **Spring Data JPA**
- **Hibernate**
- **MySQL / PostgreSQL**

---

# 📁 Project Structure

## 👨‍💻 Controllers

### 1️⃣ **BookController**
Handles all book-related API endpoints:

| Method | Endpoint        | Description       |
|--------|----------------|-------------------|
| GET    | `/books`       | Get all books     |
| GET    | `/books/{id}`  | Get book by ID    |
| POST   | `/books`       | Add a book        |
| PUT    | `/books/{id}`  | Update a book     |
| DELETE | `/books/{id}`  | Delete a book     |

---

### 2️⃣ **UserController**
Handles all user-related API endpoints:

| Method | Endpoint        | Description        |
|--------|----------------|--------------------|
| GET    | `/users`       | Get all users      |
| GET    | `/users/{id}`  | Get user by ID     |
| POST   | `/users`       | Add a user         |
| PUT    | `/users/{id}`  | Update a user      |
| DELETE | `/users/{id}`  | Delete a user      |

---

### 3️⃣ **BorrowController**
Handles book borrowing and return process:

| Method | Endpoint            | Description          |
|--------|--------------------|----------------------|
| POST   | `/borrow`          | User borrows a book  |
| POST   | `/return`          | User returns a book  |
| GET    | `/borrow-records`  | Get all borrow records |

---

# 🧩 Entities / Models

## 1️⃣ **User**
**Relationship:** One User → Many BorrowRecords

| Field           | Type               | Description          |
|-----------------|--------------------|----------------------|
| `id`            | Long               | Primary Key          |
| `name`          | String             | User's name          |
| `email`         | String             | Unique email         |
| `borrowRecords` | List\<BorrowRecord> | One-to-Many relation |

---

## 2️⃣ **Book**
**Relationship:** One Book → Many BorrowRecords

| Field           | Type               | Description          |
|-----------------|--------------------|----------------------|
| `id`            | Long               | Primary Key          |
| `title`         | String             | Book title           |
| `author`        | String             | Author               |
| `available`     | Boolean            | Book availability    |
| `borrowRecords` | List\<BorrowRecord> | One-to-Many relation |

---

## 3️⃣ **BorrowRecord**
**Relationships:**  
- Many BorrowRecords → One User  
- Many BorrowRecords → One Book  

| Field        | Type          | Description        |
|--------------|---------------|--------------------|
| `id`         | Long          | Primary Key        |
| `user`       | User          | Borrower           |
| `book`       | Book          | Borrowed book      |
| `borrowDate` | LocalDateTime | When borrowed      |
| `returnDate` | LocalDateTime | When returned      |

---
