# Fitoria Backend - Workout Journal API 💪📝

## 📋 Table of Contents
- [Introduction](#introduction)
- [Tech Stack](#tech-stack)
- [Installation](#installation)
- [API Documentation](#api-documentation)
- [Future Improvements](#future-improvements)
- [License](#license)

---

## 🏋️‍♂️ Introduction
This repository contains the backend API for Fitoria, a workout journal and training assistant application. The backend is built using Java, Spring Boot, and MySQL, and provides RESTful APIs for user registration, workout logging, body info tracking, and AI-powered training advice.

## 🛠️ Tech Stack
- **Backend**: Java, Spring Boot, Spring Data JPA, Lombok
- **Database**: MySQL
- **AI Integration**: OpenAI GPT-3.5-turbo API
- **Tools**: Swagger UI (API documentation), Postman (API testing)

---

## 💻 Installation

### Prerequisites
- Java JDK 11+
- MySQL Server
- Maven
- An OpenAI API key

### Step 1: Clone the Repository
```bash
git clone https://github.com/yourusername/fitoria-backend.git
cd fitoria-backend
```

### Step 2: Configure MySQL Database
- Open src/main/resources/application.properties and update the database credentials:
```bash
spring.datasource.url=jdbc:mysql://localhost:3306/fitoria-db
spring.datasource.username=root
spring.datasource.password=yourpassword
```

### Step 3: Build and Run the Backend
```bash
./mvnw spring-boot:run
```

### Step 4: Set Up the OpenAI API Key
Create an environment variable for your OpenAI API key:
```bash
export OPENAI_API_KEY=your_openai_api_key
```

---

## API Documentation

### Access Swagger UI

To explore the API endpoints using Swagger, visit:
```bash
http://localhost:8080/swagger-ui/index.html
```

### API Endpoints Overview

#### User Management
- POST `/api/users/register` - Register a new user
- POST `/api/users/login` - User login

#### Workout Logging
- POST `/api/workouts/user/{userId}` - Log a new workout
- GET `/api/workouts/user/{userId}/past-three-weeks` - Get workouts from the past 3 weeks
- GET `/api/workouts/user/{userId}/past-two-months` - Get workouts from the past 2 months
- GET `/api/workouts/user/{userId}/past-six-months` - Get workouts from the past 6 months
- GET `/api/workouts/user/{userId}/past-year` - Get workouts from the past year

#### Body Info Logging
- POST `/api/body-info/user/{userId}` - Log body information
- GET `/api/body-info/user/{userId}/past-three-weeks` - Get body info from the past 3 weeks
- GET `/api/body-info/user/{userId}/past-two-months` - Get body info from the past 2 months
- GET `/api/body-info/user/{userId}/past-six-months` - Get body info from the past 6 months
- GET `/api/body-info/user/{userId}/past-year` - Get body info from the past year

---

## Future Improvements
- Add progress tracking and achievement badges.
- Integration with fitness wearables for automatic data logging.
- Implement a leaderboard to compare user progress.

---

## License

This project is licensed under the MIT License.
