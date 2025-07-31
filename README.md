# 📚 Bookstore API

A RESTful API for managing a virtual bookstore, developed using **Java** and **JAX-RS (Jersey)**.  
Supports CRUD operations on books, authors, customers, shopping carts, and orders with in-memory storage.

---

## 🚀 Features

- 📘 **Books** – Create, read, update, delete
- ✍️ **Authors** – Manage author data and their books
- 👤 **Customers** – Create and manage customers
- 🛒 **Shopping Cart** – Add, update, remove books in a customer’s cart
- 📦 **Orders** – Place and view customer orders
- ❌ **Custom Exception Handling** – Friendly error messages using `ExceptionMapper`
- 📮 **Tested with Postman** – Collection included

---

## 🛠️ Technologies Used

- Java 17+
- JAX-RS (Jersey)
- JSON (Request & Response bodies)
- Postman (for testing)
- In-memory data storage (HashMap, ArrayList)


---

## 📬 Endpoints Overview

| Resource | Endpoint | Method | Description |
|----------|----------|--------|-------------|
| Books    | `/books` | GET, POST, PUT, DELETE | Manage books |
| Authors  | `/authors` | GET, POST, PUT, DELETE | Manage authors |
| Customers | `/customers` | GET, POST, PUT, DELETE | Manage customers |
| Cart | `/customers/{id}/cart` | GET, POST, PUT, DELETE | Manage cart items |
| Orders | `/customers/{id}/orders` | GET, POST | Place and view orders |

---

## ▶️ Running the Project

1. Clone this repository:
   ```bash
   git clone https://github.com/your-username/bookstore-api.git
   cd bookstore-api
2. Import it into NetBeans or your preferred Java IDE.

3. Run the application using the embedded server (e.g., Grizzly or Tomcat via Jersey).

4. Use Postman to test the endpoints (Postman collection included if available).

---

Sample Test Case (Postman)

{
  "id": 1,
  "title": "Clean Code",
  "authorId": 1,
  "isbn": "9780132350884",
  "publicationYear": 2008,
  "price": 45.99,
  "stock": 10
}





