USE CONSTRUCTION;


-- Populate the ADDRESS Table
INSERT INTO ADDRESS (adr_line1, adr_line2, city, country, state, zipcode)
VALUES
('123 MG Road', 'Near City Mall', 'Bengaluru', 'India', 'Karnataka', '560001'),
('456 Park Street', 'Opposite Central Park', 'Kolkata', 'India', 'West Bengal', '700016'),
('789 Linking Road', 'Next to Shopping Center', 'Mumbai', 'India', 'Maharashtra', '400050'),
('321 Connaught Place', 'Near Rajiv Chowk', 'New Delhi', 'India', 'Delhi', '110001'),
('654 Marina Beach Road', 'Near Lighthouse', 'Chennai', 'India', 'Tamil Nadu', '600004'),
('987 Banjara Hills', 'Near Film Nagar', 'Hyderabad', 'India', 'Telangana', '500034'),
('432 Law Garden', 'Opposite AMA', 'Ahmedabad', 'India', 'Gujarat', '380009'),
('543 Civil Lines', 'Near Circuit House', 'Jaipur', 'India', 'Rajasthan', '302006'),
('876 MG Road', 'Next to Cyber Towers', 'Pune', 'India', 'Maharashtra', '411001'),
('135 Fort Aguada Road', 'Near Candolim Beach', 'Goa', 'India', 'Goa', '403515');

-- Populate the BASIC_DETAILS Table
INSERT INTO BASIC_DETAILS (birth_date, first_name, gender, last_name)
VALUES
('1985-05-15', 'Rahul', 'Male', 'Sharma'),
('1990-08-22', 'Priya', 'Female', 'Kapoor'),
('1982-12-05', 'Amit', 'Male', 'Verma'),
('1975-01-18', 'Sunita', 'Female', 'Mehta'),
('1988-07-14', 'Vikas', 'Male', 'Patel'),
('1992-11-25', 'Neha', 'Female', 'Singh'),
('1986-03-30', 'Ravi', 'Male', 'Desai'),
('1993-09-09', 'Anjali', 'Female', 'Rao'),
('1980-04-12', 'Karan', 'Male', 'Jain'),
('1987-06-18', 'Pooja', 'Female', 'Chaudhary');

-- Populate the CONTACT_DETAILS Table
INSERT INTO CONTACT_DETAILS (contact_number, email, url)
VALUES
('9876543210', 'rahul.sharma@example.com', 'http://rahulsharma.com'),
('9876543211', 'priya.kapoor@example.com', NULL),
('9876543212', 'amit.verma@example.com', NULL),
('9876543213', 'sunita.mehta@example.com', 'http://sunitamehta.com'),
('9876543214', 'vikas.patel@example.com', NULL),
('9876543215', 'neha.singh@example.com', NULL),
('9876543216', 'ravi.desai@example.com', NULL),
('9876543217', 'anjali.rao@example.com', NULL),
('9876543218', 'karan.jain@example.com', 'http://karanjain.com'),
('9876543219', 'pooja.chaudhary@example.com', NULL);

-- Populate the ADMIN Table
INSERT INTO ADMIN (password, role, status, user_name, last_login, last_password_change, address_id, basic_details_id, contact_details_id)
VALUES
('admin123', 'ADMIN', 'ACTIVE', 'rahuladmin', '2024-01-01', '2024-02-01', 1, 1, 1),
('admin456', 'ADMIN', 'ACTIVE', 'priyaadmin', '2024-01-01', '2024-02-01', 2, 2, 2);

-- Populate the BUILDER Table
INSERT INTO BUILDER (password, role, status, user_name, availability, construction_type, emergency_contact_number, rate_per_month, years_of_experience, address_id, basic_details_id, contact_details_id)
VALUES
('builder123', 'BUILDER', 'ACTIVE', 'amitbuilder', 'YES', 'HOUSE', '9876543210', 45000, 10, 3, 3, 3),
('builder456', 'BUILDER', 'ACTIVE', 'sunibuilder', 'YES', 'APARTMENT', '9876543211', 55000,  8, 4, 4, 4);

-- Populate the CUSTOMER Table
INSERT INTO CUSTOMER (password, role, status, user_name, account_creation_date, address_id, basic_details_id, contact_details_id)
VALUES
('cust123', 'CUSTOMER', 'ACTIVE', 'vikascust', '2024-03-01', 5, 5, 5),
('cust456', 'CUSTOMER', 'ACTIVE', 'nehacust', '2024-03-01', 6, 6, 6);

-- Populate the COMPANY Table
INSERT INTO COMPANY (annual_revenue, company_name, construction_type, founding_date, license_number, number_of_employees, address_id, builder_id, contact_details_id)
VALUES
(15000000, 'Sharma Constructions', 'HOUSE', '2010-05-01', 123456, 50, 7, 1, 7),
(25000000, 'Kapoor Builders', 'APARTMENT', '2015-08-15', 654321, 75, 8, 2, 8);

-- Populate the BUILDER_REVIEW Table
INSERT INTO BUILDER_REVIEW (rating, review, review_date, builder_id, customer_id)
VALUES
(5, 'Excellent work, highly recommended!', '2024-04-10', 1, 1),
(4, 'Good work but can improve on finishing touches.', '2024-04-11', 2, 2);

-- Populate the PROJECT_DETAILS Table
INSERT INTO PROJECT_DETAILS (area_in_sq_ft, construction_description, construction_type)
VALUES
(1200, '3BHK house with modern amenities', 'HOUSE'),
(2000, 'High-rise apartment complex with swimming pool', 'APARTMENT');


-- Populate the PROJECT Table
INSERT INTO PROJECT (end_date, project_description, project_name, start_date, total_price, address_id, builder_id, construction_details_id, customer_id,request_status)
VALUES
('2025-01-01', 'Residential project in Bengaluru', 'Bengaluru Residency',  '2024-05-01', 5000000, 1, 1, 1, 1,"PENDING"),
('2025-06-01', 'Luxury apartments in Mumbai', 'Mumbai Heights',  '2024-06-01', 10000000, 2, 2, 2, 2,"PENDING");
