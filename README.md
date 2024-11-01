# 🎫 Tickets Trading Platform

[![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.3.5-green.svg)](https://spring.io/projects/spring-boot)
[![PostgreSQL](https://img.shields.io/badge/PostgreSQL-17.0-blue.svg)](https://www.postgresql.org/)


## 📋 Overview
A modern web application enabling users to buy and sell event tickets securely. Built with Spring Boot and PostgreSQL, this platform provides a seamless experience for ticket trading with robust user authentication.

---

## ✨ Features
| Feature | Description |
|---------|-------------|
| 🔐 **User Authentication** | Secure registration and login system |
| 📝 **Listings Management** | Create and browse ticket listings |
| 👤 **User Management** | Secure user data handling with encryption |
| 🔒 **Protected Routes** | Authentication required for sensitive operations |

---

## 🛠️ Technologies Used
- ![Spring Boot](https://img.shields.io/badge/Spring_Boot-6DB33F?style=flat&logo=spring&logoColor=white) Core framework
- ![Spring Security](https://img.shields.io/badge/Spring_Security-6DB33F?style=flat&logo=spring&logoColor=white) Authentication
- ![Thymeleaf](https://img.shields.io/badge/Thymeleaf-005F0F?style=flat&logo=thymeleaf&logoColor=white) Template engine
- ![Spring Data JPA](https://img.shields.io/badge/Spring_Data_JPA-6DB33F?style=flat) Data access
- ![PostgreSQL](https://img.shields.io/badge/PostgreSQL-316192?style=flat&logo=postgresql&logoColor=white) Database
- ![Lombok](https://img.shields.io/badge/Lombok-Red?style=flat) Code reduction

---

## 🔄 API Endpoints

### 👤 User Management
| Endpoint | Method | Description |
|----------|--------|-------------|
| `/register` | `GET` | 📝 Display registration form |
| `/register` | `POST` | ✨ Process new user registration |
| `/login` | `GET` | 🔑 Show login page |

### 🎫 Listing Management
| Endpoint | Method | Description |
|----------|--------|-------------|
| `/listings` | `GET` | 📋 View all available listings |
| `/createListing` | `GET` | 📝 Show listing creation form |
| `/createListing` | `POST` | ✨ Create new ticket listing |

---

## ⚙️ Configuration

### Application Properties

```properties
# Application name
spring.application.name=TicketsTradingPlatform

# Thymeleaf template engine configuration
spring.thymeleaf.enabled=true

# Database connection configuration
spring.datasource.url=jdbc:postgresql://<DATABASE_HOST>:<DATABASE_PORT>/<DATABASE_NAME>
spring.datasource.username=<DATABASE_USERNAME>
spring.datasource.password=<DATABASE_PASSWORD>
spring.datasource.driver-class-name=org.postgresql.Driver

# JPA and Hibernate configuration
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true