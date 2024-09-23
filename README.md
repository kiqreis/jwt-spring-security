
# Spring Boot 3.0 Security with JWT Implementation

This project showcases the implementation of security using Spring Boot 3.0 and JSON Web Tokens (JWT). It includes the following features:

## Features
- User registration and login with JWT authentication
- Password encryption using BCrypt
- Role-based authorization with Spring Security
- Custom access denied handling
- Logout mechanism
- Refresh token support

## Technologies
- Spring Boot 3.0
- Spring Security
- JSON Web Tokens (JWT)
- BCrypt
- Maven

## Getting Started
To get started with this project, you will need to have the following installed on your local machine:

- JDK 17+
- Maven 3+

## Build and Run the Project
To build and run the project, follow these steps:

1. Clone the repository:
   ```bash
   git clone https://github.com/kiqreis/jwt-spring-security.git
   ```

2. Navigate to the project directory:
   ```bash
   cd jwt-spring-security
   ```

3. Create the database `jwt_security` in MySQL.

4. Build the project:
   ```bash
   mvn clean install
   ```

5. Run the project:
   ```bash
   mvn spring-boot:run
   ```

- The application will be available at: `http://localhost:8080`.
