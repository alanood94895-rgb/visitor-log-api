# Visitor Log API

## Project Description

Visitor Log API is a simple RESTful web service built using Spring Boot.

It allows users to manage visitors in memory by adding, viewing, and deleting visitor records. Since the application uses a Java List instead of a database, all data is lost when the application restarts.

---

## Technologies

- Java 17
- Spring Boot 3
- Maven
- Docker

---

## Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | /api/visitors | Get all visitors |
| GET | /api/visitors/{id} | Get visitor by ID |
| POST | /api/visitors | Add a new visitor |
| DELETE | /api/visitors/{id} | Delete a visitor |
| GET | /api/visitors/count | Get total number of visitors |
| GET | /api/health | Application health check |

---

## Run Locally

Clone the repository:

```bash
git clone https://github.com/alanood94895-rgb/visitor-log-api.git
```

Go to the project folder:

```bash
cd visitor-log-api
```

Run the application:

```bash
mvn spring-boot:run
```

The application will start on:

```
http://localhost:8080
```

---

## Run with Docker

Build the image:

```bash
docker build -t visitor-log:1.0 .
```

Run the container:

```bash
docker run -d -p 8080:8080 --name visitorlog visitor-log:1.0
```

View logs:

```bash
docker logs -f visitorlog
```

---

## Example Health Endpoint

```
GET /api/health
```

Response:

```json
{
  "status": "UP",
  "developer": "Alanoud"
}
```