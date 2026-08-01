# 💳 PPC E-Commerce Payment Microservice

[![Deploy to AWS ECS](https://github.com/PPC2001/ppc-ecommerce-payment-service/actions/workflows/deploy-to-ecs.yml/badge.svg)](https://github.com/PPC2001/ppc-ecommerce-payment-service/actions/workflows/deploy-to-ecs.yml)
[![Java Version](https://img.shields.io/badge/Java-21-orange.svg)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.4.2-brightgreen.svg)](https://spring.io/projects/spring-boot)
[![Docker](https://img.shields.io/badge/Docker-Non--Root%20USER%20nobody-blue.svg)](https://www.docker.com/)

---

## 📌 Overview

**`ppc-ecommerce-payment-service`** is the Payment Gateway REST microservice for the PPC E-Commerce ecosystem. Built with Java 21 and Spring Boot 3.4.2, it processes customer payments and financial transaction records.

---

## 🏗️ Architecture & SDK Integration

- **Port**: `8083` (Container exposed ports `8083` and `8080`)
- **Shared SDK**: Consumes [`ppc-ecommerce-common-sdk:1.0.1`](https://github.com/PPC2001/ppc-ecommerce-common-sdk) for domain models (`PaymentDto`, `PaymentCompletedEvent`, `ApiResponse<T>`).
- **Container Security**: Runs in Docker as a non-root user (`USER nobody`).

---

## 🚀 REST API Specification

### 1. Actuator Health Check
```http
GET /ppc-ecommerce-payment-service/actuator/health
```

### 2. Get All Payments
```http
GET /ppc-ecommerce-payment-service/api/v1/payments
```

### 3. Process New Payment
```http
POST /ppc-ecommerce-payment-service/api/v1/payments
Content-Type: application/json
```
```json
{
  "orderId": "ORD-1001",
  "customerId": "CUST-501",
  "amount": 289.98,
  "paymentMethod": "CREDIT_CARD"
}
```

---

## ☁️ AWS ECS Fargate Deployment & CI/CD

- **ECR Repository**: `ppc-ecommerce-payment-service`
- **ECS Cluster**: `pratik-dev-cluster`
- **ECS Service**: `ppc-ecommerce-payment-service-dev`
- **Target Group**: `ppc-payment-tg-dev`
- **ALB Path**: `/ppc-ecommerce-payment-service/*`
- **CloudWatch Log Group**: `/ecs/ppc-ecommerce-payment-task-dev`

---

## 💻 Local Execution

```bash
mvn clean package --settings settings.xml
java -jar target/ppc-ecommerce-payment-service-1.0.0.jar
```

Or run via Docker:
```bash
docker build -t ppc-ecommerce-payment-service:latest .
docker run -p 8083:8083 ppc-ecommerce-payment-service:latest
```
