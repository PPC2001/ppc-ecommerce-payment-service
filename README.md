# 💳 `ppc-ecommerce-payment-service`

Payment Gateway REST Microservice for PPC E-Commerce Ecosystem.

## 📌 Features
- Payment Gateway REST APIs (`GET /api/v1/payments`, `POST /api/v1/payments/process`)
- Spring Boot 3.4.2 & Java 21
- Lombok & Spring Boot Actuator (`/actuator/health`)
- Consumes `ppc-ecommerce-common-sdk` DTOs

## ⚙️ Configuration
Dynamic placeholders in `application.properties`:
- Port: `${PORT:8083}`
- Profile: `${SPRING_PROFILES_ACTIVE:dev}`

## 🛠️ Local Run
```bash
mvn spring-boot:run
```
