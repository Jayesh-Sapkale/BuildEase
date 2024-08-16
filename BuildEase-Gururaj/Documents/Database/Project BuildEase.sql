drop database buildeasesample;
create database buildeasesample;
use buildeasesample;
-- Table: Person
CREATE TABLE Customer (
    id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50) NOT NULL,
    password VARCHAR(50) NOT NULL,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    birthdate DATE NOT NULL,
    gender ENUM('Male', 'Female', 'Other') NOT NULL,
    email VARCHAR(100) NOT NULL,
    phone VARCHAR(10) NOT NULL,
    address TEXT NOT NULL,
     last_login DATETIME NOT NULL,
    last_password_change DATETIME NOT NULL,
    role ENUM('User', 'Builder', 'Admin') NOT NULL
);


-- Table: Builder
CREATE TABLE Builder_extra_details (
    builder_id INT PRIMARY KEY AUTO_INCREMENT,
    years_of_experience INT NOT NULL CHECK (years_of_experience BETWEEN 0 AND 20),
    rate_per_month DECIMAL(10, 2) NOT NULL CHECK (rate_per_month >= 0),
    construction_type ENUM('WAREHOUSE', 'HOUSE', 'APARTMENT', 'MALL') NOT NULL,
    emergency_contact_number VARCHAR(10) NOT NULL,
    availability ENUM('YES', 'NO') NOT NULL,
    name VARCHAR(100) NOT NULL,
    address TEXT NOT NULL,
    phone_number VARCHAR(10) NOT NULL,
    email VARCHAR(100) NOT NULL,
    website VARCHAR(100) NOT NULL,
    founding_date DATE NOT NULL,
    license_number VARCHAR(5) NOT NULL,
    annual_revenue DECIMAL(15, 2) NOT NULL,
    number_of_employees INT NOT NULL CHECK (number_of_employees >= 5),
    FOREIGN KEY (builder_id) REFERENCES Customer(id)
);


-- Table: Construction_Detail
CREATE TABLE Construction_Detail (
    project_detail_id INT PRIMARY KEY AUTO_INCREMENT,
    project_id INT NOT NULL,
    area_in_sqft DOUBLE NOT NULL,
    construction_type ENUM('WAREHOUSE', 'HOUSE', 'APARTMENT', 'MALL') NOT NULL,
    builder_name VARCHAR(100) NOT NULL,
    construction_description TEXT NOT NULL
);

-- Table: Project
CREATE TABLE Project (
    project_id INT PRIMARY KEY AUTO_INCREMENT,
    project_name VARCHAR(100) NOT NULL,
    pincode VARCHAR(6) NOT NULL,
    start_date DATE NOT NULL,
    end_date DATE NOT NULL,
    project_status ENUM('COMPLETE', 'PENDING', 'IN_PROGRESS') NOT NULL,
    project_description TEXT NOT NULL,
    total_price DECIMAL(15, 2) NOT NULL,
    builder_id int not null,
    customer_id int not null,
    project_detail_id int not null,
    FOREIGN KEY (builder_id) REFERENCES Builder_extra_details(builder_id),
      FOREIGN KEY (customer_id) REFERENCES Customer(id),
    FOREIGN KEY (project_detail_id) REFERENCES Construction_Detail(project_detail_id)
);



-- Table: Review
CREATE TABLE Review (
    review_id INT PRIMARY KEY AUTO_INCREMENT,
      customer_id int not null,
    FOREIGN KEY (customer_id) REFERENCES Customer(id),
    rating INT NOT NULL CHECK (rating BETWEEN 0 AND 5),
    review TEXT NOT NULL,
    review_date DATE NOT NULL,
      builder_id int not null,
    FOREIGN KEY (builder_id) REFERENCES Builder_extra_details(builder_id)
);
