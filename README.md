# Kotlin Spring Boot Notes API with JWT Authentication

This project is a secure and stateless RESTful Notes API built using Kotlin and Spring Boot. It includes full-featured JWT-based authentication, access/refresh token management, and MongoDB for persistent storage.

## 🔧 Technologies Used

- **Kotlin** (JVM)
- **Spring Boot** (Web, Security)
- **MongoDB** (Data Persistence)
- **JWT (JSON Web Tokens)** (Authentication)
- **BCrypt** (Password Hashing)
- **Gradle** (Build Tool)

## 🛡️ Key Features

### 🔐 Authentication
- Secure user registration and login with hashed passwords (BCrypt)
- Stateless JWT-based access control
- Support for refresh tokens to renew access tokens without re-login
- Token validation, expiration handling, and exception management

### 📝 Notes Management
- CRUD operations for Notes (`title`, `content`, `color`)
- Notes are user-specific (protected by JWT token)
- Ownership verification on every note request

### 🛠️ Project Structure

src/
├── controllers/ # Auth and Notes endpoints
├── models/ # MongoDB document models: User, Note, RefreshToken
├── repositories/ # Spring Data MongoDB Repos
├── security/ # JWT filter, token service, config
├── services/ # AuthService and JwtService logic
└── exception/ # Global error handling (validation + auth)


## 🧪 API Endpoints

### Authentication

| Method | Endpoint         | Description         |
|--------|------------------|---------------------|
| POST   | `/auth/register` | Register new user   |
| POST   | `/auth/login`    | Login user, returns access & refresh token |
| POST   | `/auth/refresh`  | Get new access token using refresh token |

### Notes (JWT Protected)

| Method | Endpoint      | Description          |
|--------|---------------|----------------------|
| GET    | `/notes`      | Get all notes of user|
| POST   | `/notes`      | Create new note      |
| PUT    | `/notes/{id}` | Update a note        |
| DELETE | `/notes/{id}` | Delete a note        |

## 📦 Setup Instructions

### Prerequisites
- Java 17+
- MongoDB (local or Atlas)
- Gradle

### Run Locally

git clone https://github.com/your-username/notes-api-kotlin-springboot.git
cd notes-api-kotlin-springboot
./gradlew bootRunn


Security Design
JWT tokens signed using HMAC SHA-256

Refresh tokens stored securely in the database

No session state on the server (fully stateless)

Invalid or expired tokens rejected with proper error messages
