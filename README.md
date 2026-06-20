# Student Task Manager API

A production-ready REST API for task management built with **Spring Boot**, **Spring Security**, **JWT Authentication**, and **MySQL**. Includes Docker support and automated CI/CD pipeline via GitHub Actions.

## Tech Stack

| Layer | Technology |
|-------|-----------|
| Language | Java 17 |
| Framework | Spring Boot 3.5 |
| Security | Spring Security + JWT |
| Database | MySQL 8.0 + Spring Data JPA |
| Build Tool | Maven |
| Containerization | Docker |
| CI/CD | GitHub Actions |

## Features

- JWT-based authentication (register & login)
- Role-based access control
- Full CRUD operations for tasks
- MySQL database with auto-managed schema
- Global exception handling
- Dockerized application
- Automated build pipeline with GitHub Actions

## Project Structure

```
src/main/java/com/ayesha/student_task_manager/
├── config/          # Security configuration
├── controller/      # REST controllers (Auth, Task)
├── dto/             # Data Transfer Objects
├── model/           # JPA entities (User, Task)
├── repository/      # Spring Data JPA repositories
├── security/        # JWT utility and filter
└── service/         # Business logic
```

## API Endpoints

### Auth Endpoints (Public)

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/api/auth/register` | Register a new user |
| POST | `/api/auth/login` | Login and get JWT token |

### Task Endpoints (Protected — requires JWT token)

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/api/tasks` | Get all tasks |
| POST | `/api/tasks` | Create a new task |
| PUT | `/api/tasks/{id}` | Update a task |
| DELETE | `/api/tasks/{id}` | Delete a task |

## Getting Started

### Prerequisites

- Java 17+
- MySQL 8.0+
- Maven
- Docker (optional)

### 1. Clone the repository

```bash
git clone https://github.com/ayeshacherkuri/student-task-manager.git
cd student-task-manager
```

### 2. Configure the database

Create a MySQL database:

```sql
CREATE DATABASE taskdb;
```

Update `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/taskdb
spring.datasource.username=root
spring.datasource.password=YOUR_PASSWORD
jwt.secret=mySecretKeyForJwtTokenGeneration123456789
jwt.expiration=86400000
```

### 3. Run the application

```bash
mvn spring-boot:run
```

The API will start at `http://localhost:8080`

### 4. Run with Docker

```bash
docker build -t student-task-manager .
docker run -p 8080:8080 student-task-manager
```

## Usage Example

### Register a user

```bash
POST /api/auth/register
Content-Type: application/json

{
  "username": "ayesha",
  "password": "pass123"
}
```

Response:
```json
{
  "message": "User registered successfully"
}
```

### Login and get token

```bash
POST /api/auth/login
Content-Type: application/json

{
  "username": "ayesha",
  "password": "pass123"
}
```

Response:
```json
{
  "token": "eyJhbGciOiJIUzI1NiJ9..."
}
```

### Create a task (with token)

```bash
POST /api/tasks
Authorization: Bearer eyJhbGciOiJIUzI1NiJ9...
Content-Type: application/json

{
  "title": "Complete assignment",
  "description": "Math homework",
  "status": "TODO"
}
```

Response:
```json
{
  "id": 1,
  "title": "Complete assignment",
  "description": "Math homework",
  "status": "TODO",
  "createdAt": "2026-06-19T10:00:00"
}
```

## Task Status Values

- `TODO` — Task not started
- `IN_PROGRESS` — Task in progress
- `DONE` — Task completed

## CI/CD Pipeline

This project uses **GitHub Actions** for automated builds. On every push to `main`:

1. Code is checked out
2. Java 17 is set up
3. Maven builds the project
4. Docker image is built

## Author

**Cherukuru Ayesha**  
[GitHub](https://github.com/ayeshacherkuri) • [LinkedIn](https://linkedin.com/in/ayesha-cherkuru) • [LeetCode](https://leetcode.com/u/cherkuriayesha)
