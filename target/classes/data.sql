CREATE TABLE IF NOT EXISTS employee(
    employee_id INT AUTO_INCREMENT  PRIMARY KEY,
    first_name VARCHAR(250) NOT NULL,
    last_name VARCHAR(250) NOT NULL,
    date_of_birth DATE NOT NULL,
    gender VARCHAR(25) NOT NULL,
    department VARCHAR(25) NOT NULL
);