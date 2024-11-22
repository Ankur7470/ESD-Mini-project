CREATE TABLE domains (
            domain_id INT AUTO_INCREMENT PRIMARY KEY,
            program VARCHAR(255),
            batch VARCHAR(255),
            capacity INT,
            qualification VARCHAR(255)
);

CREATE TABLE specialisation (
            specialisation_id INT AUTO_INCREMENT PRIMARY KEY,
            code VARCHAR(255) UNIQUE NOT NULL,
            name VARCHAR(255),
            description TEXT,
            year INT,
            credits_required INT
);

CREATE TABLE placement (
            id INT AUTO_INCREMENT PRIMARY KEY,
            organisation VARCHAR(255),
            profile VARCHAR(255),
            description TEXT,
            intake INT,
            minimum_grade FLOAT
);

CREATE TABLE placement_filter (
            id INT AUTO_INCREMENT PRIMARY KEY,
            placement_id INT,
            specialisation INT,
            domain INT
);

CREATE TABLE students (
            student_id INT AUTO_INCREMENT PRIMARY KEY,
            roll_num VARCHAR(20) UNIQUE NOT NULL,
            first_name VARCHAR(255),
            last_name VARCHAR(255),
            email VARCHAR(255) UNIQUE NOT NULL,
            photograph_path VARCHAR(255),
            cgpa FLOAT,
            total_credits INT,
            graduation_year INT,
            domain INT,
            specialisation INT,
            placement_id INT,
            password varchar(255)
);

CREATE TABLE placement_student (
            id INT AUTO_INCREMENT PRIMARY KEY,
            placement_id INT,
            student_id INT,
            cv_application VARCHAR(255),
            about TEXT,
            acceptance BOOLEAN,
            comments TEXT,
            date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

