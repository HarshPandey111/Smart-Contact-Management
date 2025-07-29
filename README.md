# 📇 Smart Contact Manager

A secure and user-centric contact management REST API built using **Spring Boot**, **JWT**, and **MySQL**.  
It allows users to register, log in, and manage their personal contact list with full **CRUD**, **search**, and **pagination** features.

---

## 🚀 Features

- 🔐 **Secure Authentication** using Spring Security + JWT
- 👤 **User-specific Contact Management** (One-to-Many Relationship)
- 🔄 **Full CRUD** for Users & Contacts
- 🔍 **Fuzzy Search** (by name, email, or phone)
- 📑 **Pagination** for large contact lists
- 🧠 **Password hashing** with BCrypt
- 💾 **MySQL backend** using Spring Data JPA (Hibernate)

---

## 🛠️ Tech Stack

| Layer        | Technology                  |
|--------------|------------------------------|
| Backend      | Java 17, Spring Boot 3.x     |
| Security     | Spring Security + JWT        |
| ORM          | Hibernate / JPA              |
| Database     | MySQL                        |
| Build Tool   | Maven                        |
| Extras       | Lombok (optional)            |

---

## 📂 Project Structure

```
src/
 └── main/
     ├── java/com/example/contactmanager/
     │   ├── controller/
     │   ├── entity/
     │   ├── repository/
     │   ├── service/
     │   └── security/
     └── resources/
         └── application.properties
```

---

## 🧑‍💻 Setup Instructions

### 1. ✅ Clone the Repository
```bash
git clone https://github.com/your-username/smart-contact-manager.git
cd smart-contact-manager
```

### 2. ✅ MySQL Database Setup
Create a database named:
```
smart_contact_manager
```

### 3. ✅ Configure `application.properties`
Edit: `src/main/resources/application.properties`

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/smart_contact_manager
spring.datasource.username=YOUR_DB_USERNAME
spring.datasource.password=YOUR_DB_PASSWORD

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

# Optional JWT secret
jwt.secret=your_jwt_secret
```

### 4. ✅ Build & Run
```bash
mvn clean install
mvn spring-boot:run
```

Application runs at: [http://localhost:8080](http://localhost:8080)

---

## 🔗 REST API Endpoints

| Endpoint                               | Method | Description                          | Auth Required |
|----------------------------------------|--------|--------------------------------------|----------------|
| `/api/auth/login`                      | POST   | Login and get JWT token              | ❌ No          |
| `/api/users`                           | POST   | Register a new user                  | ❌ No          |
| `/api/users/{id}`                      | GET    | Get user details by ID               | ✅ Yes         |
| `/api/users/email/{email}`            | GET    | Get user by email                    | ✅ Yes         |
| `/api/users/{id}`                      | DELETE | Delete user by ID                    | ✅ Yes         |
| `/api/contacts`                        | GET    | Get contacts for logged-in user      | ✅ Yes         |
| `/api/contacts`                        | POST   | Add a new contact                    | ✅ Yes         |
| `/api/contacts/{id}`                   | GET    | Get a contact by ID                  | ✅ Yes         |
| `/api/contacts/{id}`                   | DELETE | Delete a contact by ID               | ✅ Yes         |
| `/api/contacts/search?q=keyword`       | GET    | Search contacts                      | ✅ Yes         |
| `/api/contacts/paged?page=0&size=10`   | GET    | Paginated contacts list              | ✅ Yes         |

---

## 🔐 How to Test (Postman / Swagger)

### 1. 📥 Login & Get Token
```json
POST /api/auth/login
Body:
{
  "email": "user@example.com",
  "password": "yourpassword"
}
```

### 2. 🔑 Use JWT Token
For all protected endpoints, add the following header:

```
Authorization: Bearer <your-jwt-token>
```

### 3. ✅ Perform CRUD, search, pagination easily via Postman

---

## 🌱 Future Improvements

- ✅ Global Exception Handling (custom JSON errors)
- ✅ Swagger/OpenAPI Documentation
- ✅ Refresh Token Flow for JWT
- ✅ Docker Containerization
- ✅ CI/CD Pipeline with GitHub Actions
- ✅ Role-based Access Control

---

## 👨‍💻 Author

**Harsh Pandey**  
Smart Contact Manager Project — Spring Boot + MySQL + JWT  
[GitHub Profile](https://github.com/yHarshPandey111)

