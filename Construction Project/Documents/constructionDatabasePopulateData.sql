use construction;
INSERT INTO ADDRESS (adr_line1, adr_line2, city, country, state, zipcode) VALUES
('12 MG Road', 'Near Brigade Towers', 'Bangalore', 'India', 'Karnataka', '560001'),
('45 Sarojini Nagar', 'Near Metro Station', 'New Delhi', 'India', 'Delhi', '110023'),
('78 Banjara Hills', 'Near Jubilee Hills', 'Hyderabad', 'India', 'Telangana', '500034'),
('22 Park Street', 'Opposite Victoria Memorial', 'Kolkata', 'India', 'West Bengal', '700016'),
('101 Marine Drive', 'Near Gateway of India', 'Mumbai', 'India', 'Maharashtra', '400020'),
('56 Ashok Nagar', 'Opposite Lotus Temple', 'Chennai', 'India', 'Tamil Nadu', '600083'),
('89 Shastri Nagar', 'Near Airport Road', 'Pune', 'India', 'Maharashtra', '411014'),
('23 Connaught Place', 'Near Central Park', 'New Delhi', 'India', 'Delhi', '110001'),
('34 Civil Lines', 'Near Mall Road', 'Lucknow', 'India', 'Uttar Pradesh', '226001'),
('50 Ellis Bridge', 'Near Sabarmati Ashram', 'Ahmedabad', 'India', 'Gujarat', '380006');

INSERT INTO BASIC_DETAILS (birth_date, first_name, gender, last_name) VALUES
('1985-05-15', 'Rajesh', 'Male', 'Kumar'),
('1990-08-22', 'Sita', 'Female', 'Sharma'),
('1987-12-30', 'Amit', 'Male', 'Verma'),
('1992-03-12', 'Priya', 'Female', 'Singh'),
('1980-07-07', 'Vikram', 'Male', 'Rao'),
('1989-09-09', 'Arjun', 'Male', 'Patel'),
('1991-04-16', 'Neha', 'Female', 'Chaudhary'),
('1984-11-23', 'Rohan', 'Male', 'Gupta'),
('1993-02-02', 'Meena', 'Female', 'Kapoor'),
('1982-06-18', 'Sanjay', 'Male', 'Mehta');

INSERT INTO CONTACT_DETAILS (contact_number, email, url) VALUES
('9876543210', 'rajesh.kumar@example.com', 'www.rajbuilders.com'),
('8765432109', 'sita.sharma@example.com', 'www.sharmaconstructions.com'),
('9123456780', 'amit.verma@example.com', 'www.vermaconstructions.com'),
('9988776655', 'priya.singh@example.com', 'www.singhbuilders.com'),
('9090909090', 'vikram.rao@example.com', 'www.raobuilders.com'),
('9191919191', 'arjun.patel@example.com', 'www.patelconstructions.com'),
('9292929292', 'neha.chaudhary@example.com', 'www.nehabuilders.com'),
('9393939393', 'rohan.gupta@example.com', 'www.guptaconstructions.com'),
('9494949494', 'meena.kapoor@example.com', 'www.kapoorbuilders.com'),
('9595959595', 'sanjay.mehta@example.com', 'www.mehtabuilders.com');


INSERT INTO ADMIN (password, role, status, user_name, last_login, last_password_change, address_id, basic_details_id, contact_details_id) VALUES
('adminPass1', 'ADMIN', 'ACTIVE', 'admin1', '2024-07-15', '2024-08-01', 1, 1, 1),
('adminPass2', 'ADMIN', 'ACTIVE', 'admin2', '2024-07-20', '2024-08-05', 2, 2, 2),
('adminPass3', 'ADMIN', 'ACTIVE', 'admin3', '2024-07-25', '2024-08-08', 3, 3, 3),
('adminPass4', 'ADMIN', 'ACTIVE', 'admin4', '2024-07-30', '2024-08-10', 4, 4, 4);


INSERT INTO BUILDER (password, role, status, user_name, availability, construction_type, emergency_contact_number, rate_per_month, years_of_experience, address_id, basic_details_id, contact_details_id) VALUES
('builderPass1', 'BUILDER', 'ACTIVE', 'builder1', 'YES', 'HOUSE', '9876543210', 50000, 10, 5, 5, 5),
('builderPass2', 'BUILDER', 'ACTIVE', 'builder2', 'YES', 'APARTMENT', '8765432109', 75000, 8, 6, 6, 6),
('builderPass3', 'BUILDER', 'ACTIVE', 'builder3', 'YES', 'MALL', '9123456780', 65000, 12, 7, 7, 7),
('builderPass4', 'BUILDER', 'ACTIVE', 'builder4', 'YES', 'WAREHOUSE', '9988776655', 70000, 9, 8, 8, 8),
('builderPass5', 'BUILDER', 'ACTIVE', 'builder5', 'YES', 'HOUSE', '9090909090', 55000, 11, 9, 9, 9);


INSERT INTO CUSTOMER (password, role, status, user_name, account_creation_date, address_id, basic_details_id, contact_details_id) VALUES
('customerPass1', 'CUSTOMER', 'ACTIVE', 'customer1', '2024-06-01', 10, 10, 10),
('customerPass2', 'CUSTOMER', 'ACTIVE', 'customer2', '2024-06-15', 9, 9, 9),
('customerPass3', 'CUSTOMER', 'ACTIVE', 'customer3', '2024-06-20', 8, 8, 8),
('customerPass4', 'CUSTOMER', 'ACTIVE', 'customer4', '2024-06-25', 7, 7, 7),
('customerPass5', 'CUSTOMER', 'ACTIVE', 'customer5', '2024-06-30', 6, 6, 6);


INSERT INTO BUILDER_REVIEW (rating, review, review_date, builder_id, customer_id) VALUES
(5, 'Excellent work, timely delivery!', '2024-07-30', 1, 1),
(4, 'Good quality but delayed', '2024-08-05', 2, 2),
(3, 'Average service, needs improvement', '2024-08-10', 3, 3),
(5, 'Outstanding craftsmanship!', '2024-08-15', 4, 4),
(4, 'Reliable and professional', '2024-08-20', 5, 5);


INSERT INTO COMPANY (annual_revenue, company_name, construction_type, founding_date, license_number, number_of_employees, address_id, builder_id, contact_details_id) VALUES
(15000000, 'ABC Constructions', 'HOUSE', '2001-04-15', '123456', 50, 1, 1, 1),
(25000000, 'XYZ Builders', 'APARTMENT', '2005-09-25', '654321', 80, 2, 2, 2),
(18000000, 'Verma Developers', 'MALL', '2008-02-20', '112233', 60, 3, 3, 3),
(22000000, 'Singh Enterprises', 'WAREHOUSE', '2010-05-18', '445566', 75, 4, 4, 4),
(19000000, 'Rao Infra', 'HOUSE', '2003-11-09', '778899', 70, 5, 5, 5);


INSERT INTO CONSTRUCTION_DETAILS (area_in_sq_ft, construction_description, construction_type, builder_id) VALUES
(2500, '3BHK Residential House', 'HOUSE', 1),
(1200, '2BHK Apartment', 'APARTMENT', 2),
(5000, 'Shopping Mall Construction', 'MALL', 3),
(3500, 'Warehouse Construction', 'WAREHOUSE', 4),
(2800, '4BHK Residential House', 'HOUSE', 5);


INSERT INTO PROJECT (end_date, project_description, project_name, project_status, start_date, total_price, address_id, builder_id, construction_details_id, customer_id) VALUES
('2024-12-31', 'Construction of 3BHK House', 'Dream House', 'IN_PROGRESS', '2024-07-01', 3000000, 1, 1, 1, 1),
('2025-03-30', 'Construction of Luxury Apartment', 'Skyline Heights', 'PENDING', '2024-09-15', 8000000, 2, 2, 2, 2),
('2025-06-30', 'Construction of Mega Mall', 'City Mall', 'IN_PROGRESS', '2024-10-01', 12000000, 3, 3, 3, 3),
('2024-11-30', 'Warehouse for Storage', 'Logistics Hub', 'COMPLETE', '2024-05-01', 5000000, 4, 4, 4, 4),
('2025-01-31', 'Construction of 4BHK House', 'Luxury Villa', 'IN_PROGRESS', '2024-08-01', 4000000, 5, 5, 5, 5);
