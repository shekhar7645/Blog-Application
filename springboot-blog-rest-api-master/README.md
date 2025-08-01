# Blog Application using Spring Boot

## 📌 Project Description
This is a **Blog Application** built using **Spring Boot** as the backend. The application allows users to **create, edit, delete, and view blogs** with features like **role-based access control, comment management, and category filtering**.

## 🚀 Features
- **User Authentication & Authorization** (JWT-based security)
- **CRUD Operations** for Blogs & Comments
- **Role-Based Access Control** (Admin & User roles)
- **Category-based Blog Filtering**
- **Exception Handling & Validation** for API security
- **RESTful API** development using Spring Boot
- **Swagger API Documentation**

## 🛠️ Tech Stack
- **Backend:** Spring Boot, Spring Security, Hibernate, JPA
- **Database:** MySQL
- **Authentication:** JWT (JSON Web Token)
- **API Documentation:** Swagger
- **Build Tool:** Maven
- **IDE:** IntelliJ IDEA / Eclipse / VS Code

## 🎯 Project Setup & Installation

### 1️⃣ Clone the Repository
```bash
git clone https://github.com/yourusername/blog-application.git
cd blog-application
```

### 2️⃣ Configure Database
Update `application.properties` with your MySQL database credentials:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/blog_db
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

### 3️⃣ Build and Run the Application
```bash
mvn clean install
mvn spring-boot:run
```

### 4️⃣ Access API
- Swagger UI: [http://localhost:8080/swagger-ui/](http://localhost:8080/swagger-ui/)
- API Base URL: `http://localhost:8080/api/v1/`

## 📌 API Endpoints
### User Authentication
- `POST /api/auth/register` ➝ Register new user
- `POST /api/auth/login` ➝ Login and get JWT token

### Blog Management
- `GET /api/blogs` ➝ Get all blogs
- `GET /api/blogs/{id}` ➝ Get a single blog by ID
- `POST /api/blogs` ➝ Create a new blog (Auth Required)
- `PUT /api/blogs/{id}` ➝ Update a blog (Auth Required)
- `DELETE /api/blogs/{id}` ➝ Delete a blog (Auth Required)

### Comments Management
- `POST /api/blogs/{id}/comments` ➝ Add comment to blog
- `DELETE /api/comments/{id}` ➝ Delete comment (Admin only)

## 🏗️ Future Enhancements
- Implementing pagination for blog listing
- Adding search functionality
- Integrating a frontend (React/Angular)
- Social media sharing features

## 🤝 Contribution
Feel free to fork and submit a pull request to improve this project. 😊

## 📜 License
This project is licensed under the MIT License.

---
**🚀 Happy Coding!**
