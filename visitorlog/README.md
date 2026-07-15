# Visitor Log API

## Project Description

Visitor Log API is a simple Spring Boot REST API used to manage visitors in a training center.

The application stores visitor information in memory using a Java List, so all data is lost when the application restarts.

## Technologies

- Java 17
- Spring Boot 3
- Maven

## Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | /api/visitors | Get all visitors |
| GET | /api/visitors/{id} | Get visitor by ID |
| POST | /api/visitors | Add a visitor |
| DELETE | /api/visitors/{id} | Delete a visitor |
| GET | /api/visitors/count | Get total visitors |
| GET | /api/health | Health check |

## Run the Project

1. Open the project in IntelliJ IDEA.
2. Run `VisitorlogApplication`.
3. Open:

http://localhost:8080

Use Postman to test the endpoints.       