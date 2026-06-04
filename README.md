# Journal App Backend

A simple backend application built using **Spring Boot** and **MongoDB** that provides RESTful APIs for managing journal entries. The application supports full CRUD (Create, Read, Update, Delete) operations and demonstrates the integration of Spring Boot with MongoDB.

## Features

* Create new journal entries
* Retrieve all journal entries
* Retrieve a journal entry by ID
* Update existing journal entries
* Delete journal entries
* RESTful API architecture
* MongoDB integration using Spring Data MongoDB

## Tech Stack

* Java 17+
* Spring Boot
* Spring Data MongoDB
* MongoDB
* Maven

## Getting Started

### Prerequisites

* Java 17 or later
* Maven
* MongoDB

### Installation

1. Clone the repository:

```bash
git clone https://github.com/your-username/journal-app-backend.git
cd journal-app-backend
```

2. Configure MongoDB in `application.properties`:

```properties
spring.data.mongodb.uri=mongodb://localhost:27017/journaldb
```

3. Run MongoDB.

4. Start the application:

```bash
mvn spring-boot:run
```

The server will start on:

```text
http://localhost:8080
```

## API Endpoints

| Method | Endpoint      | Description                |
| ------ | ------------- | -------------------------- |
| GET    | /journal      | Get all journal entries    |
| GET    | /journal/{id} | Get a journal entry by ID  |
| POST   | /journal      | Create a new journal entry |
| PUT    | /journal/{id} | Update a journal entry     |
| DELETE | /journal/{id} | Delete a journal entry     |

## Sample Request

```json
{
  "title": "My First Journal",
  "content": "Today I started learning Spring Boot with MongoDB."
}
```

## Future Enhancements

* Spring Security Integration
* JWT Authentication & Authorization
* User Management
* Search and Filtering
* Pagination and Sorting
* Docker Support

## Author

**Rakesh Sarkar**
