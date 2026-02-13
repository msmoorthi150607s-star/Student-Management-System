-- Create Database
CREATE DATABASE sms;
USE sms;

-- Admin Table
CREATE TABLE admin (
    admin_id INT AUTO_INCREMENT PRIMARY KEY,
    admin_name VARCHAR(50) NOT NULL,
    age INT NOT NULL,
    password VARCHAR(100) NOT NULL
);

-- Staff Table (Teaching + Clerical)
CREATE TABLE staff (
    staff_id INT AUTO_INCREMENT PRIMARY KEY,
    staff_name VARCHAR(50) NOT NULL,
    role ENUM('Teaching','Clerical') NOT NULL,
    department VARCHAR(50),
    age INT,
    salary DECIMAL(10,2)
);

-- ----- Student table --------
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


-- Insert Admins Menaka and Sundar
INSERT INTO admin (admin_name, age, password)
VALUES
('Menaka', 32, 'Menaka@123'),
('Sundar', 37, 'Sundar@456');


INSERT INTO staff (staff_name, role, department, age, salary)
VALUES
('John Smith', 'Teaching', 'Computer Science', 40, 52000.00),
('Maria Gonzalez', 'Teaching', 'Mathematics', 35, 48000.00),
('Chen Wei', 'Teaching', 'Physics', 42, 53000.00),
('Ahmed Hassan', 'Clerical', 'Library', 39, 41000.00),
('Elena Petrova', 'Clerical', 'Admissions', 45, 43000.00),
('David Johnson', 'Teaching', 'English', 36, 47000.00),
('Fatima Noor', 'Clerical', 'Accounts', 44, 40000.00);


INSERT INTO student (roll_number, student_name, age, grade, section, fees, address, parent_name, contact_number, courses_enrolled)
VALUES
('101', 'Rahul Verma', 20, 'B', 'A', 15000.00, 'Sivakasi, India', 'Kumar Verma', '9876543210', 'Java Basics, DBMS'),
('102', 'Ananya Singh', 19, 'A', 'B', 16000.00, 'Chennai, India', 'Raj Singh', '9123456780', 'Python Programming'),
('103', 'Vikram Das', 21, 'C', 'A', 15500.00, 'Madurai, India', 'Sita Das', '9988776655', 'Web Development'),
('104', 'Sneha Reddy', 20, 'B', 'C', 17000.00, 'Coimbatore, India', 'Ramesh Reddy', '9090909090', 'Java Basics, Python Programming'),
('105', 'Emily Brown', 19, 'A', 'B', 16000.00, 'London, UK', 'Michael Brown', '441234567890', 'Java Basics'),
('106', 'Carlos Silva', 20, 'B', 'C', 15500.00, 'Lisbon, Portugal', 'Ana Silva', '351987654321', 'DBMS'),
('107', 'Yuki Tanaka', 21, 'A', 'A', 17000.00, 'Tokyo, Japan', 'Hiro Tanaka', '819012345678', 'Python Programming'),
('108', 'Sophia Müller', 22, 'C', 'B', 16500.00, 'Berlin, Germany', 'Hans Müller', '491234567890', 'Web Development'),
('109', 'Liam O\'Connor', 19, 'B', 'C', 15000.00, 'Dublin, Ireland', 'Patrick O\'Connor', '353987654321', 'Java Basics, DBMS'),
('110', 'Isabella Rossi', 20, 'A', 'A', 16000.00, 'Rome, Italy', 'Marco Rossi', '390123456789', 'Python Programming'),
('111', 'Hassan Ali', 21, 'C', 'B', 15500.00, 'Cairo, Egypt', 'Omar Ali', '201234567890', 'Web Development'),
('112', 'Chloe Martin', 22, 'B', 'C', 17000.00, 'Paris, France', 'Pierre Martin', '331234567890', 'Java Basics'),
('113', 'Lucas Fernandez', 19, 'A', 'B', 16500.00, 'Madrid, Spain', 'Jose Fernandez', '349876543210', 'DBMS'),
('114', 'Aisha Khan', 20, 'C', 'A', 16000.00, 'Dubai, UAE', 'Mohammed Khan', '971234567890', 'Python Programming'),
('115', 'Daniel Kim', 21, 'B', 'C', 15500.00, 'Seoul, South Korea', 'Jin Kim', '821234567890', 'Web Development'),
('116', 'Olivia Johnson', 22, 'A', 'A', 17000.00, 'New York, USA', 'Robert Johnson', '121234567890', 'Java Basics, Python Programming'),
('117', 'Mateusz Kowalski', 19, 'B', 'C', 15000.00, 'Warsaw, Poland', 'Tomasz Kowalski', '481234567890', 'DBMS'),
('118', 'Hiroshi Yamamoto', 20, 'C', 'B', 16000.00, 'Osaka, Japan', 'Kenji Yamamoto', '819876543210', 'Web Development'),
('119', 'Amara Okafor', 21, 'A', 'A', 15500.00, 'Lagos, Nigeria', 'Chinedu Okafor', '234123456789', 'Python Programming');




INSERT INTO course (course_id, course_name, course_description, course_fee)
VALUES
('C105', 'Data Structures', 'Algorithms and data structures in Java', 5500.00),
('C106', 'Operating Systems', 'Concepts of OS, processes, and memory management', 6000.00),
('C107', 'Computer Networks', 'Networking fundamentals and protocols', 5800.00),
('C108', 'Artificial Intelligence', 'Introduction to AI concepts and applications', 7000.00),
('C109', 'Machine Learning', 'Supervised and unsupervised learning techniques', 7500.00),
('C110', 'Cloud Computing', 'AWS, Azure, and cloud architecture basics', 7200.00),
('C111', 'Cyber Security', 'Principles of information security and cryptography', 6800.00);

SELECT * FROM course;


INSERT INTO student_course (roll_number, course_id)
VALUES
('105', 'C105'),
('106', 'C106'),
('107', 'C107'),
('108', 'C108'),
('109', 'C109'),
('110', 'C110'),
('111', 'C111');


-- drop database sms;