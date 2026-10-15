# 🗄️ Employee Management System using Java & MySQL

A console-based **Employee Management System** built using Java, JDBC, and MySQL. This project allows users to manage employee records through a menu-driven interface, perform CRUD operations, and manage database tables.

## 🚀 Features

- **Add Employee** — Insert new employee records into the database.
- **Update Employee** — Modify employee names using employee codes.
- **Display All Employees** — View all employee records.
- **Search Employee** — Find an employee by their unique code.
- **Delete Employee** — Remove a specific employee record.
- **Create Backup Table** — Create a separate table for backup records.
- **Backup Employee Data** — Copy employee records filtered by city into the backup table.
- **Delete Backup Table** — Drop the backup table when it is no longer needed.
- **Menu-Driven Interface** — Perform operations through a simple console menu.

## 🛠️ Technologies Used

- **Java** — Core programming language
- **JDBC** — Database connectivity
- **MySQL** — Relational database management system
- **MySQL Connector/J** — JDBC driver for MySQL

## 📋 Database Structure

**Main Table: `staff`**

| Column | Data Type | Description |
|---|---|---|
| `code` | VARCHAR(4) | Employee code |
| `name` | VARCHAR(20) | Employee name |
| `city` | VARCHAR(20) | Employee city |
| `age` | INT | Employee age |

**Backup Table: `staffback`**

Stores employee records copied from the main table based on the selected city.

## ⚙️ Setup and Installation

### 1. Install Requirements
- Install Java JDK.
- Install MySQL Server.
- Add MySQL Connector/J to your project's dependencies.

### 2. Create the Database

Open MySQL and execute:

```sql
CREATE DATABASE Your_datbasename;
USE Your_datbasename;

CREATE TABLE staff (
    code VARCHAR(4),
    name VARCHAR(20),
    city VARCHAR(20),
    age INT
);
```

### 3. Configure Database Connection

Update the connection details in your Java code:

```java
Connection con = DriverManager.getConnection(
    "jdbc:mysql://localhost:3306/Your_datbasename",
    "root",
    "Your_Password"
);
```

Replace `Your_datbasename` and `Your_Password` with your actual database name and MySQL password.

### 4. Run the Application

Compile and execute the Java program after adding the MySQL JDBC driver to your classpath.

## 📖 Menu Operations

| Option | Operation |
|---|---|
| 1 | Add a new employee |
| 2 | Edit an employee record |
| 3 | Display all employee records |
| 4 | Search for an employee |
| 5 | Delete an employee |
| 6 | Create a backup table |
| 7 | Copy employee records by city |
| 8 | Delete the backup table |
| 9 | Exit the menu |

## 🎯 Learning Outcomes

- Understanding JDBC connectivity between Java and MySQL.
- Executing SQL queries using `Statement`.
- Retrieving database records using `ResultSet`.
- Performing CRUD operations.
- Using conditional statements, loops, and switch cases.
- Creating tables and copying data between tables.
- Handling database exceptions in Java.

## 🔮 Future Improvements

- Use `PreparedStatement` for safer SQL queries.
- Add employee age and input validation.
- Implement employee records with a primary key.
- Improve exception handling and database resource management.
- Add employee search by name or city.
- Introduce a graphical user interface.

## 👨‍💻 Author

**Harsh Singh**

- GitHub: [itsHarshSingh](https://github.com/itsHarshSingh)
- LinkedIn: [Harsh Singh](https://www.linkedin.com/in/harsh-singh-b51710328/)

---

⭐ If you find this project useful, consider giving it a star!
