Here's the updated `README.md` with the **database configuration** section added:

---

# Employee Management System

## Overview

This **Employee Management System** provides **CRUD (Create, Read, Update, Delete)** operations for managing employee data. Built with **Spring Boot**, it offers a **RESTful API** that allows users to perform basic employee management tasks such as creating, retrieving, updating, and deleting employee records.

---

## Features

- **Create**: Add new employee records to the system.
- **Read**: Retrieve employee details by ID or fetch all employees.
- **Update**: Modify existing employee details.
- **Delete**: Remove employee records from the system.
- **Exception Handling**: Custom exception (`ResourceNotFoundException`) is thrown when an employee is not found.

---

## Technologies Used

- **Java**: Programming language for the backend logic.
- **Spring Boot**: Framework for building RESTful services and backend.
- **JPA (Java Persistence API)**: Used for database integration and operations.
- **MySQL**: Database used for storing employee records.
- **Lombok**: Used for reducing boilerplate code in DTOs and entities.
- **Maven**: Build and dependency management tool.

---

## Project Structure

### 1. **Controller**
`EmployeeController`:  
Handles HTTP requests for employee operations. It uses **EmployeeService** to process requests and return appropriate responses.

- `POST /emp/add` – Create a new employee
- `GET /emp/{id}` – Get employee details by ID
- `GET /emp` – Get all employees
- `PUT /emp/{id}` – Update employee details
- `DELETE /emp/{id}` – Delete employee by ID

### 2. **Service**
`EmployeeService`:  
Defines methods for employee management:
- `createEmployee()`
- `getEmpById()`
- `getAllEmp()`
- `updateEmp()`
- `deleteEmp()`

`EmployeeServiceImpl`:  
Implements the `EmployeeService` interface and provides the business logic.

### 3. **DTO (Data Transfer Object)**
`EmployeeDto`:  
The data structure used to transfer employee data between the client and the server.

### 4. **Entity**
`Employee`:  
Represents the employee entity in the database, mapped to the **employees** table.

### 5. **Mapper**
`EmployeeMapper`:  
Utility class to convert between `EmployeeDto` and `Employee` entity.

### 6. **Repository**
`EmployeeRepo`:  
Extends `JpaRepository` to perform CRUD operations on employee entities in the database.

### 7. **Exception Handling**
`ResourceNotFoundException`:  
Custom exception to handle cases when an employee is not found in the database.

---

## Setup and Installation

### Prerequisites
- Java 17 or higher
- MySQL Database
- Maven
- IDE (IntelliJ IDEA, Eclipse, etc.)

### Steps

1. **Clone the repository**:
   ```bash
   git clone https://github.com/your-username/employee-management-system.git
   cd employee-management-system
   ```

2. **Configure the Database**:  
   In the `application.properties` file, configure the MySQL database connection:
   
   ```properties
   spring.application.name=com.EMS
   spring.datasource.url=jdbc:mysql://localhost:3306/EMS?createDatabaseIfNotExist=true
   spring.datasource.username=username
   spring.datasource.password=password
   spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.show-sql=true
   spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
   ```

3. **Build the project**:
   ```bash
   mvn clean install
   ```

4. **Run the application**:
   ```bash
   mvn spring-boot:run
   ```

5. **Access the API**:  
   The application will be running on `http://localhost:8080`.

---

## API Endpoints

| HTTP Method | Endpoint       | Description                         |
|-------------|----------------|-------------------------------------|
| **POST**    | `/emp/add`     | Add a new employee                  |
| **GET**     | `/emp/{id}`    | Get employee by ID                  |
| **GET**     | `/emp`         | Get all employees                   |
| **PUT**     | `/emp/{id}`    | Update employee details             |
| **DELETE**  | `/emp/{id}`    | Delete employee by ID               |

---

## Example Requests

### Create Employee

**Request**:  
`POST /emp/add`
```json
{
  "fName": "John",
  "lName": "Doe",
  "eMail": "john.doe@example.com"
}
```

**Response**:  
`201 Created`
```json
{
  "id": 1,
  "fName": "John",
  "lName": "Doe",
  "eMail": "john.doe@example.com"
}
```

### Get Employee by ID

**Request**:  
`GET /emp/1`

**Response**:  
`200 OK`
```json
{
  "id": 1,
  "fName": "John",
  "lName": "Doe",
  "eMail": "john.doe@example.com"
}
```

---

## Error Handling

If an employee with the given ID is not found, the API will respond with a `404 Not Found` error and a message like:

**Response**:  
`404 Not Found`
```json
{
  "message": "Employee is not exists with given id : 1"
}
```

---


## Acknowledgments

- **Spring Boot** for making backend development quick and easy.
- **MySQL** for providing a reliable relational database system.
- **Lombok** for reducing boilerplate code.

---
