# Student Management System (JDBC)

## 📖 Overview
The **Student Management System (SMS)** is a console-based Java application built using **JDBC** and **MySQL**.  
It demonstrates CRUD operations, transaction handling, and relational database design.  
This project is part of my learning journey:
- Bus Reservation System (Collections)
- Bank Management System (Collections)
- Student Management System (JDBC)

---

## 🗄️ Database Schema

### Database
```sql
CREATE DATABASE sms;
USE sms;

CREATE TABLE admin (
    admin_id INT AUTO_INCREMENT PRIMARY KEY,
    admin_name VARCHAR(50) NOT NULL,
    age INT NOT NULL,
    password VARCHAR(100) NOT NULL
);

CREATE TABLE staff (
    staff_id INT AUTO_INCREMENT PRIMARY KEY,
    staff_name VARCHAR(50) NOT NULL,
    role ENUM('Teaching','Clerical') NOT NULL,
    department VARCHAR(50),
    age INT,
    salary DECIMAL(10,2)
);

CREATE TABLE student (
    roll_number VARCHAR(10) PRIMARY KEY,
    student_name VARCHAR(50) NOT NULL,
    age INT NOT NULL,
    grade VARCHAR(10),
    section VARCHAR(10),
    fees DECIMAL(10,2),
    address VARCHAR(100),
    parent_name VARCHAR(50),
    contact_number VARCHAR(15),
    courses_enrolled VARCHAR(100)
);

CREATE TABLE course (
    course_id VARCHAR(10) PRIMARY KEY,
    course_name VARCHAR(50) NOT NULL,
    course_description VARCHAR(200),
    course_fee DECIMAL(10,2)
);

CREATE TABLE student_course (
    roll_number VARCHAR(10),
    course_id VARCHAR(10),
    PRIMARY KEY (roll_number, course_id),
    FOREIGN KEY (roll_number) REFERENCES student(roll_number),
    FOREIGN KEY (course_id) REFERENCES course(course_id)
);

## ⚙️ Features

### Admin
- Add, update, delete students  
- View student by roll number  
- View all students  
- Manage courses  
- Manage fees  
- Control staff attendance and records (future scope)  

### Student
- Login using roll number + contact number  
- View personal details  
- View fee details  
- View enrolled courses  

### Staff (Future Scope)
- Teaching staff → attendance, grading, marks entry  
- Clerical staff → salary, records  
- Staff access to update grades, marks, and attendance  

---

## 🚀 Tech Stack
- **Java** (JDK 17)  
- **JDBC** for database connectivity  
- **MySQL** for persistence  
- **Console UI** for interaction  

---

## 📌 Learning Goals
- Practice **CRUD operations** with JDBC  
- Understand **transactions** (commit/rollback)  
- Design **relational schemas** with foreign keys  
- Build a foundation for moving into **Servlets & JSP**  

---

## 🏆 Next Steps
- Add authentication for students and staff  
- Implement attendance and payment modules  
- Give staff access to manage grades, marks, and attendance  
- Provide admin control over staff attendance and performance  
- Migrate to **Servlets & JSP** for a web-based UI  

## 📝 Conclusion
The **Student Management System (JDBC)** project successfully demonstrates how Java applications can interact with relational databases using JDBC.  
It covers all core CRUD operations, transaction handling, and schema design with foreign keys.  
This project marks a major milestone in my learning journey, moving from in-memory applications (Collections) to persistent storage with MySQL.  
It lays the foundation for future upgrades into **Servlets & JSP**, where the system will evolve into a full-fledged web-based ERP solution.

---

## 👨‍💻 About Me
I am an aspiring backend developer passionate about building scalable systems and learning step by step through practical projects.  
My journey so far:
- **Bus Reservation System (Collections)** → learned object-oriented design and CRUD with in-memory data.  
- **Bank Management System (Collections)** → explored transactions, validations, and business rules.  
- **Student Management System (JDBC)** → leveled up to persistence, schema design, and transaction safety.  

I enjoy polishing my code for clarity, designing professional outputs, and making technical growth fun.  
This repo is part of my continuous learning path toward **web development, enterprise systems, and beyond** 🚀.



